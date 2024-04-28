package dev.microcontrollers.mixmetica.config;

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
    @Info(
            text = "Mixmetica does not support animated capes. Only the first frame of the cape will show.",
            type = InfoType.ERROR,
            size=2
    )
    private boolean animatedCapesError = false;

    @Info(
            text = "Cosmetica will ask you to sign into your Microsoft account to authenticate. Disabling cosmetics will require a game restart.",
            size = 2,
            type = InfoType.INFO,
            subcategory = "General"
    )
    private boolean loginAndDisableWarning = false;

    @Button(
            name = "Change Cosmetics",
            text = "Click",
            description = "This will take you to the Cosmetica website where you can log in and manage your cosmetics.",
            subcategory = "General"
    )
    Runnable openCosmetica = () -> {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://login.cosmetica.cc/microsoft-java"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    };

    @Switch(
            name = "Disable Cosmetica Cosmetics",
            description = "This will revert back to using OptiFine cosmetics.",
            subcategory = "General"
    )
    public static boolean disable = false;

    @Info(
            text = "Only use a custom instance if you know what you are doing.",
            type = InfoType.WARNING,
            size = 2,
            subcategory = "Instance"
    )
    private boolean arcmeticaInstanceWarning = false;

    @Info(
            text = "If Cosmetica servers are down, use the disable toggle above.",
            type = InfoType.INFO,
            subcategory = "Status"
    )
    public static boolean status = false;

    @Button(
            name = "Check Cosmetica Status",
            text = "Click",
            subcategory = "Status"
    )
    Runnable cosmeticaStatus = () -> {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://status.cosmetica.cc/"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    };

    @Switch(
            name = "Use Custom Arcmetica Instance",
            subcategory = "Instance"
    )
    public static boolean customInstance = false;

    @Text(
            name = "Arcmetica Instance",
            placeholder = "http://",
            secure = true,
            subcategory = "Instance"
    )
    public static String instanceLink = "";

    @Button(
            name = "Join the Cosmetica Discord",
            text = "Click",
            subcategory = "Socials"
    )
    Runnable cosmeticaDiscord = () -> {
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
            text = "Click",
            subcategory = "Socials"
    )
    Runnable cosmeticaKofi = () -> {
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
            text = "Click",
            subcategory = "Socials"
    )
    Runnable mixmeticaDiscord = () -> {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://discord.gg/rejfv9kFJj"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    };

    @Button(
            name = "Check Out My Other Mods",
            text = "Click",
            subcategory = "Socials"
    )
    Runnable modrinthProfile = () -> {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://modrinth.com/user/Microcontrollers"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public MixmeticaConfig() {
        super(new Mod("Mixmetica", ModType.UTIL_QOL, "/mixmetica.png"), "mixmetica.json");
        initialize();
        addDependency("instanceLink", "customInstance");
    }
}
