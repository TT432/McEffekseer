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
        effekseerManagerCore.Initialize(8000);


        efkefcMap.clear();
        FileToIdConverter filetoidconverter = new FileToIdConverter(DIRECTORY, ".efkefc");

        for (var file : filetoidconverter.listMatchingResources(pResourceManager)) {
            ResourceLocation id = filetoidconverter.fileToId(file);

            try (var is = pResourceManager.getResource(file).getInputStream()) {
                efkefcMap.put(id, new EfkefcObject(id, pResourceManager, is));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
