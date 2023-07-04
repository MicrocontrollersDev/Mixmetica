package com.github.microcontrollersdev.mixmetica.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Pseudo
@Mixin(targets = "net.optifine.player.CapeUtils", remap = false)
public class CapeUtilsMixin {
    @ModifyConstant(method = "downloadCape", constant = @Constant(stringValue = "http://s.optifine.net/capes/", ordinal = 0))
    private static String modifyCapeUrl(String originalUrl) {
        String modifiedUrl = "http://23.95.137.176/capes/";
        modifiedUrl = modifiedUrl + originalUrl.substring(originalUrl.lastIndexOf('/') + 1);
        return modifiedUrl;
    }
}

