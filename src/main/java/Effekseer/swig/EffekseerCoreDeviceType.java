package Effekseer.swig;

public final class EffekseerCoreDeviceType {
    public static final EffekseerCoreDeviceType Unknown = new EffekseerCoreDeviceType("Unknown");
    public static final EffekseerCoreDeviceType OpenGL = new EffekseerCoreDeviceType("OpenGL");
    public static final EffekseerCoreDeviceType DirectX9 = new EffekseerCoreDeviceType("DirectX9");
    public static final EffekseerCoreDeviceType DirectX11 = new EffekseerCoreDeviceType("DirectX11");
    private static EffekseerCoreDeviceType[] swigValues;
    private static int swigNext;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static EffekseerCoreDeviceType swigToEnum(int var0) {
        if (var0 < swigValues.length && var0 >= 0 && swigValues[var0].swigValue == var0) {
            return swigValues[var0];
        } else {
            for(int var1 = 0; var1 < swigValues.length; ++var1) {
                if (swigValues[var1].swigValue == var0) {
                    return swigValues[var1];
                }
            }

            throw new IllegalArgumentException("No enum " + EffekseerCoreDeviceType.class + " with value " + var0);
        }
    }

    private EffekseerCoreDeviceType(String var1) {
        this.swigName = var1;
        this.swigValue = swigNext++;
    }

    private EffekseerCoreDeviceType(String var1, int var2) {
        this.swigName = var1;
        this.swigValue = var2;
        swigNext = var2 + 1;
    }

    private EffekseerCoreDeviceType(String var1, EffekseerCoreDeviceType var2) {
        this.swigName = var1;
        this.swigValue = var2.swigValue;
        swigNext = this.swigValue + 1;
    }

    static {
        swigValues = new EffekseerCoreDeviceType[]{Unknown, OpenGL, DirectX9, DirectX11};
        swigNext = 0;
    }
}
