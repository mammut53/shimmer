package com.lowdragmc.shimmer.core;

import com.lowdragmc.shimmer.client.light.ColorPointLight;

import java.util.List;

public interface IRenderSection {
    List<ColorPointLight> getShimmerLights();
    void setShimmerLights(List<ColorPointLight> lights);
}
