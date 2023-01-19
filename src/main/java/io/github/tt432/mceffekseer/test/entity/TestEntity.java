package io.github.tt432.mceffekseer.test.entity;

import io.github.tt432.mceffekseer.test.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

/**
 * @author DustW
 */
public class TestEntity extends ThrowableItemProjectile {
    public boolean needStart;

    public TestEntity(double pX, double pY, double pZ, Level pLevel) {
        super(Registry.TEST_ENTITY.get(), pX, pY, pZ, pLevel);
    }

    public TestEntity(LivingEntity pShooter, Level pLevel) {
        super(Registry.TEST_ENTITY.get(), pShooter, pLevel);
    }

    public TestEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    int removeTime;

    @Override
    public void tick() {
        super.tick();

        if (removeTime != 0 && removeTime < tickCount)
            discard();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        if (!needStart) {
            removeTime = tickCount;
            needStart = true;
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);

        if (!needStart) {
            removeTime = tickCount;
            needStart = true;
        }
    }

    @Override
    protected Item getDefaultItem() {
        return Registry.TEST_ITEM.get();
    }
}
