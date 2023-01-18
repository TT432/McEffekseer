package Effekseer.swig;

public class EffekseerEffectCore {
    private transient long swigCPtr;
    protected transient boolean swigCMemOwn;

    protected EffekseerEffectCore(long var1, boolean var3) {
        this.swigCMemOwn = var3;
        this.swigCPtr = var1;
    }

    protected static long getCPtr(EffekseerEffectCore var0) {
        return var0 == null ? 0L : var0.swigCPtr;
    }

    protected static long swigRelease(EffekseerEffectCore var0) {
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
                EffekseerCoreJNI.delete_EffekseerEffectCore(this.swigCPtr);
            }

            this.swigCPtr = 0L;
        }

    }

    public EffekseerEffectCore() {
        this(EffekseerCoreJNI.new_EffekseerEffectCore(), true);
    }

    public boolean Load(byte[] var1, int var2, float var3) {
        return EffekseerCoreJNI.EffekseerEffectCore_Load(this.swigCPtr, this, var1, var2, var3);
    }

    public String GetTexturePath(int var1, EffekseerTextureType var2) {
        return EffekseerCoreJNI.EffekseerEffectCore_GetTexturePath(this.swigCPtr, this, var1, var2.swigValue());
    }

    public int GetTextureCount(EffekseerTextureType var1) {
        return EffekseerCoreJNI.EffekseerEffectCore_GetTextureCount(this.swigCPtr, this, var1.swigValue());
    }

    public boolean LoadTexture(byte[] var1, int var2, int var3, EffekseerTextureType var4) {
        return EffekseerCoreJNI.EffekseerEffectCore_LoadTexture(this.swigCPtr, this, var1, var2, var3, var4.swigValue());
    }

    public boolean HasTextureLoaded(int var1, EffekseerTextureType var2) {
        return EffekseerCoreJNI.EffekseerEffectCore_HasTextureLoaded(this.swigCPtr, this, var1, var2.swigValue());
    }

    public String GetModelPath(int var1) {
        return EffekseerCoreJNI.EffekseerEffectCore_GetModelPath(this.swigCPtr, this, var1);
    }

    public int GetModelCount() {
        return EffekseerCoreJNI.EffekseerEffectCore_GetModelCount(this.swigCPtr, this);
    }

    public boolean LoadModel(byte[] var1, int var2, int var3) {
        return EffekseerCoreJNI.EffekseerEffectCore_LoadModel(this.swigCPtr, this, var1, var2, var3);
    }

    public boolean HasModelLoaded(int var1) {
        return EffekseerCoreJNI.EffekseerEffectCore_HasModelLoaded(this.swigCPtr, this, var1);
    }

    public String GetMaterialPath(int var1) {
        return EffekseerCoreJNI.EffekseerEffectCore_GetMaterialPath(this.swigCPtr, this, var1);
    }

    public int GetMaterialCount() {
        return EffekseerCoreJNI.EffekseerEffectCore_GetMaterialCount(this.swigCPtr, this);
    }

    public boolean LoadMaterial(byte[] var1, int var2, int var3) {
        return EffekseerCoreJNI.EffekseerEffectCore_LoadMaterial(this.swigCPtr, this, var1, var2, var3);
    }

    public String GetCurvePath(int var1) {
        return EffekseerCoreJNI.EffekseerEffectCore_GetCurvePath(this.swigCPtr, this, var1);
    }

    public boolean HasMaterialLoaded(int var1) {
        return EffekseerCoreJNI.EffekseerEffectCore_HasMaterialLoaded(this.swigCPtr, this, var1);
    }

    public int GetCurveCount() {
        return EffekseerCoreJNI.EffekseerEffectCore_GetCurveCount(this.swigCPtr, this);
    }

    public boolean LoadCurve(byte[] var1, int var2, int var3) {
        return EffekseerCoreJNI.EffekseerEffectCore_LoadCurve(this.swigCPtr, this, var1, var2, var3);
    }

    public boolean HasCurveLoaded(int var1) {
        return EffekseerCoreJNI.EffekseerEffectCore_HasCurveLoaded(this.swigCPtr, this, var1);
    }

    public int GetTermMax() {
        return EffekseerCoreJNI.EffekseerEffectCore_GetTermMax(this.swigCPtr, this);
    }

    public int GetTermMin() {
        return EffekseerCoreJNI.EffekseerEffectCore_GetTermMin(this.swigCPtr, this);
    }
}
