package com.github.microcontrollersdev.mixmetica.mixin;

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
        return "http://23.95.137.176";
    }
}
