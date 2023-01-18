package io.github.tt432.mceffekseer;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.tt432.mceffekseer.efkefc.EfkefcManager;
import io.github.tt432.mceffekseer.efkefc.EfkefcRenderer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;
import org.joml.Vector3f;

/**
 * @author DustW
 */
@Mod.EventBusSubscriber(Dist.CLIENT)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RenderHandler {
    private static int time;
    private static boolean started;

    private static final ResourceLocation laser03 = new ResourceLocation(Mceffekseer.MOD_ID, "laser03");

    @SubscribeEvent
    @SuppressWarnings({"removal"})
    public static void onEvent(RenderLevelLastEvent event) {
        boolean firstTick = !started;

        if (firstTick)
            started = true;

        var camera = Minecraft.getInstance().gameRenderer.getMainCamera();

        EfkefcRenderer.render(EfkefcManager.getEfkefcMap().get(laser03), new Vector3f(0, 0, 0),
                to(event.getProjectionMatrix()),
                new Matrix4f()
                        .rotate((float) Math.toRadians(camera.getXRot()), new Vector3f(1, 0, 0))
                        .rotate((float) Math.toRadians(camera.getYRot()), new Vector3f(0, 1, 0))
                        .translate(to(camera.getPosition()).mul(1, -1, 1)),
                to(RenderSystem.getModelViewMatrix()),
                firstTick);
    }

    private static Vector3f to(Vec3 source) {
        return new Vector3f((float) source.x(), (float) source.y(), (float) source.z());
    }

    static Matrix4f to(com.mojang.math.Matrix4f m) {
        return new Matrix4f(
                m.m00, m.m10, m.m20, m.m30,
                m.m01, m.m11, m.m21, m.m31,
                m.m02, m.m12, m.m22, m.m32,
                m.m03, m.m13, m.m23, m.m33
        );
    }

    @SubscribeEvent
    public static void onEvent(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            time++;

            if (time >= 20 * 2) {
                time = 0;
                started = false;
            }
        }
    }
}
