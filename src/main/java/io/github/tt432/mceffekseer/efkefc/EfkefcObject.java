package io.github.tt432.mceffekseer.efkefc;

import Effekseer.swig.EffekseerEffectCore;

import java.io.InputStream;

/**
 * @author DustW
 */
public class EfkefcObject {
    private final EffekseerEffectCore effectCore;

    public EfkefcObject(InputStream fileStream) {
        effectCore = new EffekseerEffectCore();
    }

    public void read() {

    }
}
