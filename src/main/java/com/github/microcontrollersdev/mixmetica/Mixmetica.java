package com.github.microcontrollersdev.mixmetica;

import com.github.microcontrollersdev.mixmetica.command.MixmeticaCommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "mixmetica", name = "Mixmetica", clientSideOnly = true)
public class Mixmetica {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new MixmeticaCommand());
    }
}
