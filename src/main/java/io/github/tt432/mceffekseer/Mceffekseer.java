package io.github.tt432.mceffekseer;

import io.github.tt432.mceffekseer.test.Registry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

/**
 * @author DustW
 */
@Mod(Mceffekseer.MOD_ID)
public class Mceffekseer {

    public static final String MOD_ID = "mceffekseer";

    public Mceffekseer() {
        if (!FMLEnvironment.production) {
            Registry.register(FMLJavaModLoadingContext.get().getModEventBus());
        }
    }
}
