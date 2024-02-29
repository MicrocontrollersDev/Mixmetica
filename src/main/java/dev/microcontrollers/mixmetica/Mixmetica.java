package dev.microcontrollers.mixmetica;

import dev.microcontrollers.mixmetica.config.MixmeticaConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "mixmetica", name = "Mixmetica", clientSideOnly = true)
public class Mixmetica {
    public static MixmeticaConfig config;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        config = new MixmeticaConfig();
    }
}
