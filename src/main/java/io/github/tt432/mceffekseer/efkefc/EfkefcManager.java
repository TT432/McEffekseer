package io.github.tt432.mceffekseer.efkefc;

import Effekseer.swig.EffekseerBackendCore;
import Effekseer.swig.EffekseerManagerCore;
import io.github.tt432.mceffekseer.util.FileToIdConverter;
import io.github.tt432.mceffekseer.util.SharedLibraryLoader;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DustW
 */
public class EfkefcManager {
    @Getter
    private static EffekseerManagerCore effekseerManagerCore;
    private static final String DIRECTORY = "efkefc";
    @Getter
    private static final Map<ResourceLocation, EfkefcObject> efkefcMap = new HashMap<>();

    public static void init(ResourceManager pResourceManager) {
        new SharedLibraryLoader().load("EffekseerNativeForJava");

        EffekseerBackendCore.InitializeWithOpenGL();

        effekseerManagerCore = new EffekseerManagerCore();
        effekseerManagerCore.Initialize(80000);


        efkefcMap.clear();

        scan(new FileToIdConverter(DIRECTORY, ".efkefc"), pResourceManager);
    }

    static void scan(FileToIdConverter fileToIdConverter, ResourceManager resourceManager) {
        for (var file : fileToIdConverter.listMatchingResources(resourceManager)) {
            ResourceLocation id = fileToIdConverter.fileToId(file);

            try (var is = resourceManager.getResource(file).getInputStream()) {
                efkefcMap.put(id, new EfkefcObject(id, resourceManager, is));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
