package com.github.microcontrollersdev.mixmetica.command;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class MixmeticaCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "mixmetica";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/mixmetica";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(
                EnumChatFormatting.GOLD + "[Mixmetica]" + EnumChatFormatting.WHITE +
                        " Go to https://cosmetica.cc to set your cosmetics!").setChatStyle(createClickStyle(ClickEvent.Action.OPEN_URL, "https://cosmetica.cc")));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }

    /*
        Taken from https://github.com/NotEnoughUpdates/NotEnoughUpdates/blob/master/src/main/java/io/github/moulberry/notenoughupdates/util/Utils.java
     */
    public static ChatStyle createClickStyle(ClickEvent.Action action, String value) {
        ChatStyle style = new ChatStyle();
        style.setChatClickEvent(new ClickEvent(action, value));
        style.setChatHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new ChatComponentText(EnumChatFormatting.YELLOW + value)
        ));
        return style;
    }
}
