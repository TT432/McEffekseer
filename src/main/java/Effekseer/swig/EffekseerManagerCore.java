package Effekseer.swig;

public class EffekseerManagerCore {
    private transient long swigCPtr;
    protected transient boolean swigCMemOwn;

    protected EffekseerManagerCore(long var1, boolean var3) {
        this.swigCMemOwn = var3;
        this.swigCPtr = var1;
    }

    protected static long getCPtr(EffekseerManagerCore var0) {
        return var0 == null ? 0L : var0.swigCPtr;
    }

    protected static long swigRelease(EffekseerManagerCore var0) {
        long var1 = 0L;
        if (var0 != null) {
            if (!var0.swigCMemOwn) {
                throw new RuntimeException("Cannot release ownership as memory is not owned");
            }

            var1 = var0.swigCPtr;
            var0.swigCMemOwn = false;
            var0.delete();
        }

        return var1;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                EffekseerCoreJNI.delete_EffekseerManagerCore(this.swigCPtr);
            }

            this.swigCPtr = 0L;
        }

    }

    public EffekseerManagerCore() {
        this(EffekseerCoreJNI.new_EffekseerManagerCore(), true);
    }

    public boolean Initialize(int var1, boolean var2) {
        return EffekseerCoreJNI.EffekseerManagerCore_Initialize__SWIG_0(this.swigCPtr, this, var1, var2);
    }

    public boolean Initialize(int var1) {
        return EffekseerCoreJNI.EffekseerManagerCore_Initialize__SWIG_1(this.swigCPtr, this, var1);
    }

    public void Update(float var1) {
        EffekseerCoreJNI.EffekseerManagerCore_Update(this.swigCPtr, this, var1);
    }

    public void BeginUpdate() {
        EffekseerCoreJNI.EffekseerManagerCore_BeginUpdate(this.swigCPtr, this);
    }

    public void EndUpdate() {
        EffekseerCoreJNI.EffekseerManagerCore_EndUpdate(this.swigCPtr, this);
    }

    public void UpdateHandleToMoveToFrame(int var1, float var2) {
        EffekseerCoreJNI.EffekseerManagerCore_UpdateHandleToMoveToFrame(this.swigCPtr, this, var1, var2);
    }

    public int Play(EffekseerEffectCore var1) {
        return EffekseerCoreJNI.EffekseerManagerCore_Play(this.swigCPtr, this, EffekseerEffectCore.getCPtr(var1), var1);
    }

    public void StopAllEffects() {
        EffekseerCoreJNI.EffekseerManagerCore_StopAllEffects(this.swigCPtr, this);
    }

    public void Stop(int var1) {
        EffekseerCoreJNI.EffekseerManagerCore_Stop(this.swigCPtr, this, var1);
    }

    public void SetPaused(int var1, boolean var2) {
        EffekseerCoreJNI.EffekseerManagerCore_SetPaused(this.swigCPtr, this, var1, var2);
    }

    public void SetShown(int var1, boolean var2) {
        EffekseerCoreJNI.EffekseerManagerCore_SetShown(this.swigCPtr, this, var1, var2);
    }

    public void SetEffectPosition(int var1, float var2, float var3, float var4) {
        EffekseerCoreJNI.EffekseerManagerCore_SetEffectPosition(this.swigCPtr, this, var1, var2, var3, var4);
    }

    public void SetEffectRotation(int var1, float var2, float var3, float var4) {
        EffekseerCoreJNI.EffekseerManagerCore_SetEffectRotation(this.swigCPtr, this, var1, var2, var3, var4);
    }

    public void SetEffectScale(int var1, float var2, float var3, float var4) {
        EffekseerCoreJNI.EffekseerManagerCore_SetEffectScale(this.swigCPtr, this, var1, var2, var3, var4);
    }

    public void SetEffectTransformMatrix(int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13) {
        EffekseerCoreJNI.EffekseerManagerCore_SetEffectTransformMatrix(this.swigCPtr, this, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
    }

    public void SetEffectTransformBaseMatrix(int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13) {
        EffekseerCoreJNI.EffekseerManagerCore_SetEffectTransformBaseMatrix(this.swigCPtr, this, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
    }

    public void DrawBack(int var1) {
        EffekseerCoreJNI.EffekseerManagerCore_DrawBack__SWIG_0(this.swigCPtr, this, var1);
    }

    public void DrawBack() {
        EffekseerCoreJNI.EffekseerManagerCore_DrawBack__SWIG_1(this.swigCPtr, this);
    }

    public void DrawFront(int var1) {
        EffekseerCoreJNI.EffekseerManagerCore_DrawFront__SWIG_0(this.swigCPtr, this, var1);
    }

    public void DrawFront() {
        EffekseerCoreJNI.EffekseerManagerCore_DrawFront__SWIG_1(this.swigCPtr, this);
    }

    public void SetLayer(int var1, int var2) {
        EffekseerCoreJNI.EffekseerManagerCore_SetLayer(this.swigCPtr, this, var1, var2);
    }

    public void SetProjectionMatrix(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16) {
        EffekseerCoreJNI.EffekseerManagerCore_SetProjectionMatrix(this.swigCPtr, this, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
    }

    public void SetCameraMatrix(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16) {
        EffekseerCoreJNI.EffekseerManagerCore_SetCameraMatrix(this.swigCPtr, this, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
    }

    public boolean Exists(int var1) {
        return EffekseerCoreJNI.EffekseerManagerCore_Exists(this.swigCPtr, this, var1);
    }

    public void SetViewProjectionMatrixWithSimpleWindow(int var1, int var2) {
        EffekseerCoreJNI.EffekseerManagerCore_SetViewProjectionMatrixWithSimpleWindow(this.swigCPtr, this, var1, var2);
    }

    public void SetDynamicInput(int var1, int var2, float var3) {
        EffekseerCoreJNI.EffekseerManagerCore_SetDynamicInput(this.swigCPtr, this, var1, var2, var3);
    }

    public float GetDynamicInput(int var1, int var2) {
        return EffekseerCoreJNI.EffekseerManagerCore_GetDynamicInput(this.swigCPtr, this, var1, var2);
    }

    public void LaunchWorkerThreads(int var1) {
        EffekseerCoreJNI.EffekseerManagerCore_LaunchWorkerThreads(this.swigCPtr, this, var1);
    }

    public void SetBackground(long var1, boolean var3) {
        EffekseerCoreJNI.EffekseerManagerCore_SetBackground(this.swigCPtr, this, var1, var3);
    }

    public void UnsetBackground() {
        EffekseerCoreJNI.EffekseerManagerCore_UnsetBackground(this.swigCPtr, this);
    }

    public void SetDepth(long var1, boolean var3) {
        EffekseerCoreJNI.EffekseerManagerCore_SetDepth(this.swigCPtr, this, var1, var3);
    }

    public void UnsetDepth() {
        EffekseerCoreJNI.EffekseerManagerCore_UnsetDepth(this.swigCPtr, this);
    }
}
