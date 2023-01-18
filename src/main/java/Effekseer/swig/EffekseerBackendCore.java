package Effekseer.swig;

public class EffekseerBackendCore {
    private transient long swigCPtr;
    protected transient boolean swigCMemOwn;

    protected EffekseerBackendCore(long var1, boolean var3) {
        this.swigCMemOwn = var3;
        this.swigCPtr = var1;
    }

    protected static long getCPtr(EffekseerBackendCore var0) {
        return var0 == null ? 0L : var0.swigCPtr;
    }

    protected static long swigRelease(EffekseerBackendCore var0) {
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
                EffekseerCoreJNI.delete_EffekseerBackendCore(this.swigCPtr);
            }

            this.swigCPtr = 0L;
        }

    }

    public EffekseerBackendCore() {
        this(EffekseerCoreJNI.new_EffekseerBackendCore(), true);
    }

    public static EffekseerCoreDeviceType GetDevice() {
        return EffekseerCoreDeviceType.swigToEnum(EffekseerCoreJNI.EffekseerBackendCore_GetDevice());
    }

    public static boolean InitializeWithOpenGL() {
        return EffekseerCoreJNI.EffekseerBackendCore_InitializeWithOpenGL();
    }

    public static void Terminate() {
        EffekseerCoreJNI.EffekseerBackendCore_Terminate();
    }
}
