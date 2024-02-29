package dev.microcontrollers.mixmetica.mixin;

import dev.microcontrollers.mixmetica.config.MixmeticaConfig;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Pseudo
@Mixin(targets = "net.optifine.player.CapeUtils", remap = false)
public abstract class CapeUtilsMixin {
    @Dynamic
    @ModifyConstant(method = "downloadCape", constant = @Constant(stringValue = "http://s.optifine.net/capes/", ordinal = 0))
    private static String modifyCapeUrl(String originalUrl) {
        if (MixmeticaConfig.disable) return "http://s.optifine.net/capes/";
        String modifiedUrl =  "http://23.95.137.176/capes/";
        if (MixmeticaConfig.customInstance) {
            String link = MixmeticaConfig.instanceLink;
            if (link.endsWith("/")) modifiedUrl = link.substring(0, link.length() - 1) + "/capes/";
        }
        modifiedUrl = modifiedUrl + originalUrl.substring(originalUrl.lastIndexOf('/') + 1);
        return modifiedUrl;
    }
}
