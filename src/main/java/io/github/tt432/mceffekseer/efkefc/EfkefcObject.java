package io.github.tt432.mceffekseer.efkefc;

import Effekseer.swig.EffekseerEffectCore;
import Effekseer.swig.EffekseerTextureType;
import com.google.common.base.CaseFormat;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * @author DustW
 */
@Slf4j
public class EfkefcObject {
    private static final EffekseerTextureType[] textureTypes = new EffekseerTextureType[]{
            EffekseerTextureType.Color,
            EffekseerTextureType.Normal,
            EffekseerTextureType.Distortion,
    };

    @Getter
    private final EffekseerEffectCore effectCore;

    public EfkefcObject(ResourceLocation location, ResourceManager manager, InputStream is) throws IOException {
        effectCore = new EffekseerEffectCore();
        byte[] bytes = IOUtils.toByteArray(is);

        if (!effectCore.Load(bytes, bytes.length, 1)) {
            log.error("Failed to load efkefc : " + location);
            return;
        }

        String namespace = location.getNamespace();

        loadTexture(manager, namespace);
        loadModel(manager, namespace);
        loadMaterial(manager, namespace);
        loadCurve(manager, namespace);

        log.info("Success load efkefc : " + location);
    }

    private void loadTexture(ResourceManager manager, String namespace) throws IOException {
        for (EffekseerTextureType textureType : textureTypes) {
            for (int i = 0; i < effectCore.GetTextureCount(textureType); i++) {
                String path = effectCore.GetTexturePath(i, textureType);
                Optional<Resource> resource = manager.getResource(toLoc(namespace, "textures", path));

                if (resource.isPresent()) {
                    try (var isi = resource.get().open()) {
                        byte[] bytes = IOUtils.toByteArray(isi);
                        effectCore.LoadTexture(bytes, bytes.length, i, textureType);
                    }
                }
            }
        }
    }

    private void loadModel(ResourceManager manager, String namespace) throws IOException {
        for (int i = 0; i < effectCore.GetModelCount(); i++) {
            String path = effectCore.GetModelPath(i);
            Optional<Resource> resource = manager.getResource(toLoc(namespace, "models", path));

            if (resource.isPresent()) {
                try (var isi = resource.get().open()) {
                    byte[] bytes = IOUtils.toByteArray(isi);
                    effectCore.LoadModel(bytes, bytes.length, i);
                }
            }
        }
    }

    private void loadMaterial(ResourceManager manager, String namespace) throws IOException {
        for (int i = 0; i < effectCore.GetMaterialCount(); i++) {
            String path = effectCore.GetMaterialPath(i);
            Optional<Resource> resource = manager.getResource(toLoc(namespace, "materials", path));

            if (resource.isPresent()) {
                try (var isi = resource.get().open()) {
                    byte[] bytes = IOUtils.toByteArray(isi);
                    effectCore.LoadMaterial(bytes, bytes.length, i);
                }
            }
        }
    }

    private void loadCurve(ResourceManager manager, String namespace) throws IOException {
        for (int i = 0; i < effectCore.GetCurveCount(); i++) {
            String path = effectCore.GetCurvePath(i);
            Optional<Resource> resource = manager.getResource(toLoc(namespace, "curves", path));

            if (resource.isPresent()) {
                try (var isi = resource.get().open()) {
                    byte[] bytes = IOUtils.toByteArray(isi);
                    effectCore.LoadCurve(bytes, bytes.length, i);
                }
            }
        }
    }

    public static ResourceLocation toLoc(String namespace, String type, String sourcePath) {
        StringBuilder dir = new StringBuilder("efkefc/").append(type);
        String[] split = sourcePath.split("/");

        for (int i = typeEqual(split[0], type) ? 1 : 0; i < split.length; i++) {
            dir.append("/").append(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, split[i]));
        }

        return new ResourceLocation(namespace, dir.toString());
    }

    private static boolean typeEqual(String start, String type) {
        return start.equalsIgnoreCase(type) || start.equalsIgnoreCase(type.substring(0, type.length() - 1));
    }
}
