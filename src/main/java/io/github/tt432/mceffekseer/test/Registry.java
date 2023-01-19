package io.github.tt432.mceffekseer.test;

import com.google.common.base.CaseFormat;
import io.github.tt432.mceffekseer.Mceffekseer;
import io.github.tt432.mceffekseer.test.entity.TestEntity;
import io.github.tt432.mceffekseer.test.item.TestItem;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author DustW
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Registry {
    private static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mceffekseer.MOD_ID);

    private static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Mceffekseer.MOD_ID);

    public static final RegistryObject<TestItem> TEST_ITEM = ITEMS.register("test",
            () -> new TestItem(new Item.Properties().tab(CreativeTab.MAIN)));

    public static final RegistryObject<EntityType<TestEntity>> TEST_ENTITY = register(TestEntity.class, TestEntity::new);

    private static <T extends Entity> RegistryObject<EntityType<T>> register(
            Class<T> subClass,
            EntityType.EntityFactory<T> factory
    ) {
        String name = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, subClass.getSimpleName());
        return ENTITIES.register(name, () -> EntityType.Builder
                .of(factory, MobCategory.CREATURE)
                .sized(1, 1)
                .build(name));
    }

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
        ITEMS.register(bus);
    }
}
