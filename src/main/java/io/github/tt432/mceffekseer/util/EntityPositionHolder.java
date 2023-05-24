package io.github.tt432.mceffekseer.util;

import io.github.tt432.mceffekseer.api.PositionHolder;
import lombok.AllArgsConstructor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

/**
 * @author DustW
 */
@AllArgsConstructor
public class EntityPositionHolder implements PositionHolder {
    private final Entity entity;

    @Override
    public Vector3f pos() {
        return to(entity.position());
    }

    @Override
    public Vector3f rot() {
        return new Vector3f((float) -Math.toRadians(entity.getXRot()), (float) -Math.toRadians(entity.getYRot()), 0);
    }

    private static Vector3f to(Vec3 source) {
        return new Vector3f((float) source.x(), (float) source.y(), (float) source.z());
    }
}
