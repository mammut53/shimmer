package com.lowdragmc.shimmer.platform;

import com.lowdragmc.shimmer.ShimmerConstants;
import com.lowdragmc.shimmer.platform.services.IPlatformHelper;
import net.minecraft.client.ClientBrandRetriever;

/**
 * @author HypherionSA
 * @date 2022/06/09
 */
public class Services {

    public static final IPlatformHelper PLATFORM = load();

    private static IPlatformHelper load() {
        String loaderName = ClientBrandRetriever.getClientModName().toLowerCase().trim();
        var classLocation = switch (loaderName) {
            case "neoforge" -> "com.lowdragmc.shimmer.neoforge.platform.NeoForgePlatformHelper";
            case "forge" -> {
                ShimmerConstants.LOGGER.warn("forge detected, just works under neoforge");
                ShimmerConstants.LOGGER.warn("behaviour may not be correct");
                yield "com.lowdragmc.shimmer.fabric.platform.ForgePlatformHelper";
            }
            case "fabric" -> "com.lowdragmc.shimmer.fabric.platform.FabricPlatformHelper";
            case "quilt" -> {
                ShimmerConstants.LOGGER.warn("quilt detected, just works under fabric");
                ShimmerConstants.LOGGER.warn("behaviour may not be correct");
                yield "com.lowdragmc.shimmer.fabric.platform.FabricPlatformHelper";
            }
            //https://github.com/sp614x/optifine/issues/1631
            case "optifine" -> throw new RuntimeException("doesn't support under optifine, please uninstall shimmer");
            case "vanilla" -> throw new RuntimeException("run on vanilla?");
            default -> throw new RuntimeException("unknown loader " + loaderName);
        };
        ShimmerConstants.LOGGER.debug("detect loader " + loaderName);
        IPlatformHelper loadedService;
        try {
            loadedService = (IPlatformHelper) Class.forName(classLocation).getConstructor().newInstance();
        } catch (Exception e) {
            ShimmerConstants.LOGGER.error("failed to init PlatformHelper");
            throw new RuntimeException(e);
        }
        ShimmerConstants.LOGGER.debug("Loaded {} for service", loadedService);
        return loadedService;
    }
}
