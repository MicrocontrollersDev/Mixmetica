package com.github.microcontrollersdev.mixmetica.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.data.InfoType;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MixmeticaConfig extends Config {
    @Exclude
    private static MixmeticaConfig INSTANCE = null;

    public static MixmeticaConfig getInstance() {
        return INSTANCE == null ? (INSTANCE = new MixmeticaConfig()) : INSTANCE;
    }

    @Info(
            text = "Mixmetica does not support animated capes. Only the first frame of the cape will show.",
            type = InfoType.ERROR,
            size=2
    )
    private boolean error = false;

    @Info(
            text = "Cosmetica will ask you to sign into your Microsoft account to authenticate. Disabling cosmetics will require a game restart.",
            size = 2,
            type = InfoType.INFO,
            subcategory = "General"
    )
    private boolean info = false;

    @Button(
            name = "Change Cosmetics",
            text = "Click!",
            subcategory = "General"
    )
    Runnable runnable = () -> {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://login.cosmetica.cc/microsoft-java"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    };

    @Switch(
            name = "Disable Cosmetics",
            subcategory = "General"
    )
    public static boolean disable = false;

    @Info(
            text = "Only use a custom instance if you've set one up.",
            type = InfoType.WARNING,
            size=2,
            subcategory = "General"
    )
    private boolean warning = false;

    @Switch(
            name = "Use Custom Arcmetica Instance",
            subcategory = "General"
    )
    public static boolean customInstance = false;

    @Text(
            name = "Arcmetica Instance",
            placeholder = "http://",
            secure = true,
            subcategory = "General"
    )
    public static String instanceLink = "";

    @Button(
            name = "Join the Cosmetica Discord",
            text = "Click!",
            subcategory = "Socials"
    )
    Runnable runnable2 = () -> {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://discord.gg/aQh5SJEUBm"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    };

    @Button(
            name = "Donate to Cosmetica",
            text = "Click!",
            subcategory = "Socials"
    )
    Runnable runnable3 = () -> {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://ko-fi.com/cosmetica"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    };

    @Button(
            name = "Join the Mixmetica Discord",
            text = "Click!",
            subcategory = "Socials"
    )
    Runnable runnable4 = () -> {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://discord.gg/rejfv9kFJj"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public MixmeticaConfig() {
        super(new Mod("Mixmetica", ModType.UTIL_QOL, "/mixmetica.png"), "mixmetica.json");
        initialize();
        addDependency("profileLink", "customProfile");
    }
}
