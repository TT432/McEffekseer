package io.github.tt432.mceffekseer;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.tt432.mceffekseer.api.PositionHolder;
import io.github.tt432.mceffekseer.efkefc.EfkefcManager;
import io.github.tt432.mceffekseer.efkefc.EfkefcObject;
import io.github.tt432.mceffekseer.efkefc.EfkefcRenderer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author DustW
 */
@Mod.EventBusSubscriber(Dist.CLIENT)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RenderHandler {
    private static int time;

    private static final List<RenderInfo> RENDER_INFOS = new ArrayList<>();

    @RequiredArgsConstructor
    @Data
    public static class RenderInfo {
        final ResourceLocation name;
        final PositionHolder pos;
        final Vector3f size;
        final boolean once;

        int time;

        int pointer;
        boolean started;
    }

    public static void render(RenderInfo info) {
        info.time = time;

        RENDER_INFOS.add(info);
    }

    @SubscribeEvent
    public static void onEvent(ClientPlayerNetworkEvent.LoggedOutEvent event) {
        RENDER_INFOS.clear();
    }

    @SubscribeEvent
    @SuppressWarnings({"removal"})
    public static void onEvent(RenderLevelLastEvent event) {
        var camera = Minecraft.getInstance().gameRenderer.getMainCamera();

        Matrix4f cameraMatrix = new Matrix4f()
                .rotate((float) Math.toRadians(camera.getXRot()), new Vector3f(1, 0, 0))
                .rotate((float) Math.toRadians(camera.getYRot()), new Vector3f(0, 1, 0))
                .translate(to(camera.getPosition()).mul(1, -1, 1));
        Matrix4f projection = to(event.getProjectionMatrix());
        Matrix4f modelView = to(RenderSystem.getModelViewMatrix());

        EfkefcRenderer.begin();

        Iterator<RenderInfo> it = RENDER_INFOS.iterator();
        while (it.hasNext()) {
            RenderInfo info = it.next();
            EfkefcObject efkefcObject = EfkefcManager.getEfkefcMap().get(info.name);

            if (efkefcObject != null) {
                if (time - info.time > efkefcObject.getTermMax()) {
                    if (info.once) {
                        it.remove();
                    } else {
                        info.time = time;
                        info.started = false;
                    }
                } else if (time >= info.time && !info.started) {
                    EfkefcRenderer.addToCore(efkefcObject, info);

                    if (info.once)
                        it.remove();
                    else
                        info.started = true;
                } else {
                    if (!Minecraft.getInstance().isPaused())
                        EfkefcRenderer.update(info);
                }
            } else {
                it.remove();
            }
        }

        EfkefcRenderer.coreUpdate(projection, cameraMatrix, modelView);
    }

    @SubscribeEvent
    public static void onEvent(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END)
            time++;
    }

    private static Vector3f to(Vec3 source) {
        return new Vector3f((float) source.x(), (float) source.y(), (float) source.z());
    }

    private static Matrix4f to(com.mojang.math.Matrix4f m) {
        return new Matrix4f(
                m.m00, m.m10, m.m20, m.m30,
                m.m01, m.m11, m.m21, m.m31,
                m.m02, m.m12, m.m22, m.m32,
                m.m03, m.m13, m.m23, m.m33
        );
    }
}
