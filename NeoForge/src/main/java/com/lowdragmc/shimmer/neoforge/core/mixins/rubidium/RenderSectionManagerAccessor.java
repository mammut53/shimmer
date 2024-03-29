package com.lowdragmc.shimmer.neoforge.core.mixins.rubidium;

import me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager;
import me.jellysquid.mods.sodium.client.render.chunk.lists.SortedRenderLists;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * @author KilaBash
 * @date 2022/05/31
 * @implNote RenderSectionManagerAccessor
 */
@Mixin(RenderSectionManager.class)
public interface RenderSectionManagerAccessor {
    @Accessor(remap = false)
    SortedRenderLists getRenderLists();
}
