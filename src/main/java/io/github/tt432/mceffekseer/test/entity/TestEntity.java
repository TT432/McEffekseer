package io.github.tt432.mceffekseer.test.entity;

import io.github.tt432.mceffekseer.test.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

/**
 * @author DustW
 */
public class TestEntity extends ThrowableItemProjectile {
    public TestEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return Registry.TEST_ITEM.get();
    }
}
