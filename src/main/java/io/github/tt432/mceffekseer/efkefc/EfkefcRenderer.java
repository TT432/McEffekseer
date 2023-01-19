package io.github.tt432.mceffekseer.efkefc;

import net.minecraft.client.Minecraft;
import org.joml.Matrix4f;
import org.joml.Vector3f;

/**
 * @author DustW
 */
public class EfkefcRenderer {
    public static void addToCore(EfkefcObject object, Vector3f pos, Vector3f size) {
        var core = EfkefcManager.getEffekseerManagerCore();

        pos = new Vector3f(pos).mul(-1, 1, -1);

        int play = core.Play(object.getEffectCore());
        core.SetEffectScale(play, size.x, size.y, size.z);
        core.SetEffectPosition(play, pos.x(), pos.y(), pos.z());
    }

    public static void coreUpdate(Matrix4f projection, Matrix4f cameraMatrix, Matrix4f modelView) {
        var core = EfkefcManager.getEffekseerManagerCore();
        Minecraft mc = Minecraft.getInstance();

        Matrix4f mul = new Matrix4f(projection).mul(modelView);
        setMatrix(core::SetProjectionMatrix, mul);

        setMatrix(core::SetCameraMatrix, cameraMatrix);
        core.Update(mc.getDeltaFrameTime());
        core.DrawBack();
        core.DrawFront();
    }

    private static void setMatrix(MatrixHolder holder, Matrix4f matrix) {
        holder.setMatrix(
                matrix.m00(), matrix.m10(), matrix.m20(), matrix.m30(),
                matrix.m01(), matrix.m11(), matrix.m21(), matrix.m31(),
                matrix.m02(), matrix.m12(), matrix.m22(), matrix.m32(),
                matrix.m03(), matrix.m13(), matrix.m23(), matrix.m33()
        );
    }

    @FunctionalInterface
    public interface MatrixHolder {
        void setMatrix(
                float var1, float var2, float var3, float var4,
                float var5, float var6, float var7, float var8,
                float var9, float var10, float var11, float var12,
                float var13, float var14, float var15, float var16
        );
    }
}
