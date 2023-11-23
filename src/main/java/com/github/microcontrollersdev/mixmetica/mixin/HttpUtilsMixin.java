package com.github.microcontrollersdev.mixmetica.mixin;

import com.github.microcontrollersdev.mixmetica.config.MixmeticaConfig;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Pseudo
@Mixin(targets = "net.optifine.http.HttpUtils", remap = false)
public abstract class HttpUtilsMixin {
    @Dynamic
    @ModifyConstant(method = "getPlayerItemsUrl", constant = @Constant(stringValue = "http://s.optifine.net", ordinal = 0))
    private static String modifyCapeUrl(String originalUrl) {
        if (MixmeticaConfig.disable) return "http://s.optifine.net/capes/";
        if (MixmeticaConfig.customInstance) {
            String link = MixmeticaConfig.instanceLink;
            if (link.endsWith("/")) link = link.substring(0, link.length() - 1);
            return link;
        }
        return "http://23.95.137.175";
    }
}