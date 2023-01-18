package io.github.tt432.mceffekseer;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.tt432.mceffekseer.efkefc.EfkefcManager;
import io.github.tt432.mceffekseer.efkefc.EfkefcRenderer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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

        EfkefcRenderer.render(EfkefcManager.getEfkefcMap().get(laser03), new Vector3f(0, 0, 0),
                event.getProjectionMatrix(),
                Minecraft.getInstance().gameRenderer.getMainCamera(),
                RenderSystem.getModelViewMatrix(),
                firstTick);
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
