package io.github.tt432.mceffekseer.api;

import io.github.tt432.mceffekseer.util.EntityPositionHolder;
import net.minecraft.world.entity.Entity;
import org.joml.Vector3f;

/**
 * @author DustW
 */
public interface PositionHolder {
    /**
     * 获取位置
     * @return 位置
     */
    Vector3f pos();

    /**
     * 获取旋转角度（弧度制）
     * @return 旋转角度
     */
    Vector3f rot();

    static PositionHolder entity(Entity entity) {
        return new EntityPositionHolder(entity);
    }

    static PositionHolder create(Vector3f pos, Vector3f rot) {
        return new PositionHolderImpl(pos, rot);
    }

    record PositionHolderImpl(Vector3f pos, Vector3f rot) implements PositionHolder {
    }
}
