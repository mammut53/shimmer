package com.lowdragmc.shimmer.neoforge.core.mixins.rubidium;

import com.lowdragmc.shimmer.client.light.ColorPointLight;
import com.lowdragmc.shimmer.core.IRenderSection;
import me.jellysquid.mods.sodium.client.render.chunk.RenderSection;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Collections;
import java.util.List;

/**
 * @author KilaBash
 * @date 2022/05/28
 * @implNote TODO
 */
@Mixin(RenderSection.class)
public abstract class RenderSectionMixin implements IRenderSection {
    List<ColorPointLight> shimmerLights = Collections.emptyList();

    @Override
    public List<ColorPointLight> getShimmerLights() {
        return shimmerLights;
    }

    @Override
    public void setShimmerLights(List<ColorPointLight> lights) {
        shimmerLights = lights;
    }

}
