package Effekseer.swig;

public final class EffekseerTextureType {
    public static final EffekseerTextureType Color = new EffekseerTextureType("Color");
    public static final EffekseerTextureType Normal = new EffekseerTextureType("Normal");
    public static final EffekseerTextureType Distortion = new EffekseerTextureType("Distortion");
    private static EffekseerTextureType[] swigValues;
    private static int swigNext;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static EffekseerTextureType swigToEnum(int var0) {
        if (var0 < swigValues.length && var0 >= 0 && swigValues[var0].swigValue == var0) {
            return swigValues[var0];
        } else {
            for(int var1 = 0; var1 < swigValues.length; ++var1) {
                if (swigValues[var1].swigValue == var0) {
                    return swigValues[var1];
                }
            }

            throw new IllegalArgumentException("No enum " + EffekseerTextureType.class + " with value " + var0);
        }
    }

    private EffekseerTextureType(String var1) {
        this.swigName = var1;
        this.swigValue = swigNext++;
    }

    private EffekseerTextureType(String var1, int var2) {
        this.swigName = var1;
        this.swigValue = var2;
        swigNext = var2 + 1;
    }

    private EffekseerTextureType(String var1, EffekseerTextureType var2) {
        this.swigName = var1;
        this.swigValue = var2.swigValue;
        swigNext = this.swigValue + 1;
    }

    static {
        swigValues = new EffekseerTextureType[]{Color, Normal, Distortion};
        swigNext = 0;
    }
}
