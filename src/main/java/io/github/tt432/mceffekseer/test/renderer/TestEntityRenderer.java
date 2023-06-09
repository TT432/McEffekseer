package io.github.tt432.mceffekseer.test.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.tt432.mceffekseer.Mceffekseer;
import io.github.tt432.mceffekseer.RenderHandler;
import io.github.tt432.mceffekseer.api.PositionHolder;
import io.github.tt432.mceffekseer.test.entity.TestEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector3f;

/**
 * @author DustW
 */
public class TestEntityRenderer extends ThrownItemRenderer<TestEntity> {
    protected TestEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    private static final ResourceLocation rl =
            new ResourceLocation(Mceffekseer.MOD_ID, "simple_turbulence_fireworks");
    private static final ResourceLocation rl1 =
            new ResourceLocation(Mceffekseer.MOD_ID, "lightning_strike");
    private static final ResourceLocation rl2 =
            new ResourceLocation(Mceffekseer.MOD_ID, "herald");

    @Override
    public void render(TestEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);

        if (pEntity.needStart) {
            RenderHandler.render(new RenderHandler.RenderInfo(rl2,
                    PositionHolder.entity(pEntity), new Vector3f(1F), true));
            pEntity.needStart = false;
        }
    }
}
