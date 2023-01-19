package io.github.tt432.mceffekseer.test.renderer;

import io.github.tt432.mceffekseer.test.Registry;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author DustW
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RendererRegistry {
    @SubscribeEvent
    public static void onEvent(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Registry.TEST_ENTITY.get(), TestEntityRenderer::new);
    }
}
