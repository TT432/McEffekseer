package io.github.tt432.mceffekseer.test;

import io.github.tt432.mceffekseer.Mceffekseer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * @author DustW
 */
public class CreativeTab {
    public static final CreativeModeTab MAIN = new CreativeModeTab(Mceffekseer.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registry.TEST_ITEM.get());
        }
    };
}
