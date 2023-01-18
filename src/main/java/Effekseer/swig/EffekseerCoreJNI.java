package Effekseer.swig;

public class EffekseerCoreJNI {
    public EffekseerCoreJNI() {
    }

    public static final native long new_EffekseerBackendCore();

    public static final native void delete_EffekseerBackendCore(long var0);

    public static final native int EffekseerBackendCore_GetDevice();

    public static final native boolean EffekseerBackendCore_InitializeWithOpenGL();

    public static final native void EffekseerBackendCore_Terminate();

    public static final native long new_EffekseerEffectCore();

    public static final native void delete_EffekseerEffectCore(long var0);

    public static final native boolean EffekseerEffectCore_Load(long var0, EffekseerEffectCore var2, byte[] var3, int var4, float var5);

    public static final native String EffekseerEffectCore_GetTexturePath(long var0, EffekseerEffectCore var2, int var3, int var4);

    public static final native int EffekseerEffectCore_GetTextureCount(long var0, EffekseerEffectCore var2, int var3);

    public static final native boolean EffekseerEffectCore_LoadTexture(long var0, EffekseerEffectCore var2, byte[] var3, int var4, int var5, int var6);

    public static final native boolean EffekseerEffectCore_HasTextureLoaded(long var0, EffekseerEffectCore var2, int var3, int var4);

    public static final native String EffekseerEffectCore_GetModelPath(long var0, EffekseerEffectCore var2, int var3);

    public static final native int EffekseerEffectCore_GetModelCount(long var0, EffekseerEffectCore var2);

    public static final native boolean EffekseerEffectCore_LoadModel(long var0, EffekseerEffectCore var2, byte[] var3, int var4, int var5);

    public static final native boolean EffekseerEffectCore_HasModelLoaded(long var0, EffekseerEffectCore var2, int var3);

    public static final native String EffekseerEffectCore_GetMaterialPath(long var0, EffekseerEffectCore var2, int var3);

    public static final native int EffekseerEffectCore_GetMaterialCount(long var0, EffekseerEffectCore var2);

    public static final native boolean EffekseerEffectCore_LoadMaterial(long var0, EffekseerEffectCore var2, byte[] var3, int var4, int var5);

    public static final native String EffekseerEffectCore_GetCurvePath(long var0, EffekseerEffectCore var2, int var3);

    public static final native boolean EffekseerEffectCore_HasMaterialLoaded(long var0, EffekseerEffectCore var2, int var3);

    public static final native int EffekseerEffectCore_GetCurveCount(long var0, EffekseerEffectCore var2);

    public static final native boolean EffekseerEffectCore_LoadCurve(long var0, EffekseerEffectCore var2, byte[] var3, int var4, int var5);

    public static final native boolean EffekseerEffectCore_HasCurveLoaded(long var0, EffekseerEffectCore var2, int var3);

    public static final native int EffekseerEffectCore_GetTermMax(long var0, EffekseerEffectCore var2);

    public static final native int EffekseerEffectCore_GetTermMin(long var0, EffekseerEffectCore var2);

    public static final native long new_EffekseerManagerCore();

    public static final native void delete_EffekseerManagerCore(long var0);

    public static final native boolean EffekseerManagerCore_Initialize__SWIG_0(long var0, EffekseerManagerCore var2, int var3, boolean var4);

    public static final native boolean EffekseerManagerCore_Initialize__SWIG_1(long var0, EffekseerManagerCore var2, int var3);

    public static final native void EffekseerManagerCore_Update(long var0, EffekseerManagerCore var2, float var3);

    public static final native void EffekseerManagerCore_BeginUpdate(long var0, EffekseerManagerCore var2);

    public static final native void EffekseerManagerCore_EndUpdate(long var0, EffekseerManagerCore var2);

    public static final native void EffekseerManagerCore_UpdateHandleToMoveToFrame(long var0, EffekseerManagerCore var2, int var3, float var4);

    public static final native int EffekseerManagerCore_Play(long var0, EffekseerManagerCore var2, long var3, EffekseerEffectCore var5);

    public static final native void EffekseerManagerCore_StopAllEffects(long var0, EffekseerManagerCore var2);

    public static final native void EffekseerManagerCore_Stop(long var0, EffekseerManagerCore var2, int var3);

    public static final native void EffekseerManagerCore_SetPaused(long var0, EffekseerManagerCore var2, int var3, boolean var4);

    public static final native void EffekseerManagerCore_SetShown(long var0, EffekseerManagerCore var2, int var3, boolean var4);

    public static final native void EffekseerManagerCore_SetEffectPosition(long var0, EffekseerManagerCore var2, int var3, float var4, float var5, float var6);

    public static final native void EffekseerManagerCore_SetEffectRotation(long var0, EffekseerManagerCore var2, int var3, float var4, float var5, float var6);

    public static final native void EffekseerManagerCore_SetEffectScale(long var0, EffekseerManagerCore var2, int var3, float var4, float var5, float var6);

    public static final native void EffekseerManagerCore_SetEffectTransformMatrix(long var0, EffekseerManagerCore var2, int var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15);

    public static final native void EffekseerManagerCore_SetEffectTransformBaseMatrix(long var0, EffekseerManagerCore var2, int var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15);

    public static final native void EffekseerManagerCore_DrawBack__SWIG_0(long var0, EffekseerManagerCore var2, int var3);

    public static final native void EffekseerManagerCore_DrawBack__SWIG_1(long var0, EffekseerManagerCore var2);

    public static final native void EffekseerManagerCore_DrawFront__SWIG_0(long var0, EffekseerManagerCore var2, int var3);

    public static final native void EffekseerManagerCore_DrawFront__SWIG_1(long var0, EffekseerManagerCore var2);

    public static final native void EffekseerManagerCore_SetLayer(long var0, EffekseerManagerCore var2, int var3, int var4);

    public static final native void EffekseerManagerCore_SetProjectionMatrix(long var0, EffekseerManagerCore var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18);

    public static final native void EffekseerManagerCore_SetCameraMatrix(long var0, EffekseerManagerCore var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18);

    public static final native boolean EffekseerManagerCore_Exists(long var0, EffekseerManagerCore var2, int var3);

    public static final native void EffekseerManagerCore_SetViewProjectionMatrixWithSimpleWindow(long var0, EffekseerManagerCore var2, int var3, int var4);

    public static final native void EffekseerManagerCore_SetDynamicInput(long var0, EffekseerManagerCore var2, int var3, int var4, float var5);

    public static final native float EffekseerManagerCore_GetDynamicInput(long var0, EffekseerManagerCore var2, int var3, int var4);

    public static final native void EffekseerManagerCore_LaunchWorkerThreads(long var0, EffekseerManagerCore var2, int var3);

    public static final native void EffekseerManagerCore_SetBackground(long var0, EffekseerManagerCore var2, long var3, boolean var5);

    public static final native void EffekseerManagerCore_UnsetBackground(long var0, EffekseerManagerCore var2);

    public static final native void EffekseerManagerCore_SetDepth(long var0, EffekseerManagerCore var2, long var3, boolean var5);

    public static final native void EffekseerManagerCore_UnsetDepth(long var0, EffekseerManagerCore var2);
}
