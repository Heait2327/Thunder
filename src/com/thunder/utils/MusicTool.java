package com.thunder.utils;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MusicTool {
    private static String file = "0";
    static URL battleUrl;

    static {
        try {
            battleUrl = new File("res/media/battle.wav").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static URL bossUrl;

    static {
        try {
            bossUrl = new File("res/media/boss.wav").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static URL clickUrl;

    static {
        try {
            clickUrl = new File("res/media/click.wav").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static URL explodeUrl;

    static {
        try {
            explodeUrl = new File("res/media/explode.wav").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static URL goUrl;

    static {
        try {
            goUrl = new File("res/media/go.wav").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static URL menuUrl;

    static {
        try {
            menuUrl = new File("res/media/menu.wav").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static URL rageUrl;

    static {
        try {
            rageUrl = new File("res/media/rage.wav").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static URL restoreUrl;

    static {
        try {
            restoreUrl = new File("res/media/restore.wav").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static URL shieldUrl;

    static {
        try {
            shieldUrl = new File("res/media/shield.wav").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static URL warningUrl;

    static {
        try {
            warningUrl = new File("res/media/warning.wav").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public MusicTool() throws MalformedURLException {
    }

    static AudioClip menuAudioClip = Applet.newAudioClip(menuUrl);
    static AudioClip clickAudioClip = Applet.newAudioClip(clickUrl);
    static AudioClip goAudioClip = Applet.newAudioClip(goUrl);
    static AudioClip battleAudioClip = Applet.newAudioClip(battleUrl);
    static AudioClip explodeAudioClip = Applet.newAudioClip(explodeUrl);
    static AudioClip rageAudioClip = Applet.newAudioClip(rageUrl);
    static AudioClip restoreAudioClip = Applet.newAudioClip(restoreUrl);
    static AudioClip shieldAudioClip = Applet.newAudioClip(shieldUrl);
    static AudioClip warningAudioClip = Applet.newAudioClip(warningUrl);
    static AudioClip bossAudioClip = Applet.newAudioClip(bossUrl);
    public static void playMenuMusic() {
        menuAudioClip.loop();
    }
    public static void playClickMusic() {
        clickAudioClip.play();
    }
    public static void playBattleMusic() {
        battleAudioClip.loop();
    }
    public static void playGoMusic() {
        goAudioClip.play();
    }
    public static void playExplodeMusic() {
        explodeAudioClip.play();
    }
    public static void playRageMusic() {
        rageAudioClip.play();
    }
    public static void playRestoreMusic() {
        restoreAudioClip.play();
    }
    public static void playShieldMusic() {
        shieldAudioClip.play();
    }
    public static void playWarningMusic() {
        warningAudioClip.play();
    }
    public static void playBossMusic() {
        bossAudioClip.loop();
    }
    public static void stopMenuMusic() {
        menuAudioClip.stop();
    }
    public static void stopBattleMusic() {
        battleAudioClip.stop();
    }
    public static void stopBossMusic() {
        bossAudioClip.stop();
    }
}
