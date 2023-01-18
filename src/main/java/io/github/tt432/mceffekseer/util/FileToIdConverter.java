package io.github.tt432.mceffekseer.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author DustW
 */
public class FileToIdConverter {
    private final String prefix;
    private final String extension;

    public FileToIdConverter(String p_248876_, String p_251478_) {
        this.prefix = p_248876_;
        this.extension = p_251478_;
    }

    public static FileToIdConverter json(String p_248754_) {
        return new FileToIdConverter(p_248754_, ".json");
    }

    public static ResourceLocation withPath(ResourceLocation rl, String path) {
        return new ResourceLocation(rl.getNamespace(), path);
    }
    
    public ResourceLocation idToFile(ResourceLocation id) {
        return withPath(id, this.prefix + "/" + id.getPath() + this.extension);
    }

    public ResourceLocation fileToId(ResourceLocation file) {
        String s = file.getPath();
        return withPath(file, s.substring(this.prefix.length() + 1, s.length() - this.extension.length()));
    }

    public Collection<ResourceLocation> listMatchingResources(ResourceManager manager) {
        return manager.listResources(this.prefix, s -> s.endsWith(this.extension));
    }
}