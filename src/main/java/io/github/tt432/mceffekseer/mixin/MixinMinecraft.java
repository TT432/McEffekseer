package io.github.tt432.mceffekseer.mixin;

import io.github.tt432.mceffekseer.efkefc.EfkefcManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author DustW
 */
@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void initME(GameConfig pGameConfig, CallbackInfo ci) {
        EfkefcManager.init(((Minecraft) (Object) this).getResourceManager());
    }
}
