package io.github.elementera.config;

import io.github.elementera.Loggers;

import java.io.*;

import static java.io.File.separator;

public class Config implements Loggers {
    public static final MyProperties myproperties = new MyProperties();
    /*public static final Properties properties = new Properties();*/
    public Config() {
        File file = new File("config" + separator + separator + "elementera");
        File gui = new File("config" + separator + separator + "elementera" + separator + separator + "GUI");
        if (!file.exists() && !file.isDirectory()) file.mkdir(); if (!gui.exists() && !gui.isDirectory()) gui.mkdir();
        try {
            myproperties.load(new BufferedInputStream(new FileInputStream("config" + separator + separator + "elementera" + separator + separator + "GUI" + separator + separator + "config.ee")));
        } catch (FileNotFoundException e) {
            three("title","you can edit titleScreen but You can't block the words fabric and mojang", "eula", "true","editGui", "no");
            three("authors", "this is a authors button size", "author_hide", "no", "author_this_a", "1");
            three("author_this_b", "2", "author_this_c", "-100", "author_this_y", "y");
            three("author_button_width", "200", "author_button_height", "20", "sing_player_this_a", "1");
            three("sing_player_this_b", "2", "sing_player_this_c", "-100", "sing_player_this_y", "100");
            three("sing_player_button_width", "100", "sing_player_button_height", "20", "multiplayer_this_a", "1");
            three("multiplayer_this_b", "2", "multiplayer_this_c", "0", "multiplayer_this_y", "100");
            three("multiplayer_button_width", "100", "multiplayer_button_height", "20", "online_this_a", "1");
            three("online_this_b", "2", "online_this_c", "-100", "online_this_y", "120");
            three("online_button_width", "200", "online_button_height", "20", "titleScreen_mouseX_hide", "no");
            three("titleScreen_mouseY_hide", "no","BoPt_tick", "3000", "null", "");
            myproperties.put("titleScreen_mouseY_hide", "no");
            myproperties.put("BoPt_tick", "3000");
            configs.info("create config success");
            try {
                myproperties.store(new BufferedOutputStream(new FileOutputStream("config" + separator + separator + "elementera" + separator + separator + "GUI" + separator + separator + "config.ee")),
                        "Save Configs File.");
            } catch (IOException f) { f.printStackTrace(); }
        } catch (IOException i) { i.printStackTrace(); }
    }
    public static void three(String string, String string1, String string2, String string3, String string4, String string5) {
        myproperties.put(string, string1); myproperties.put(string2, string3); if (!string4.equals("null")) myproperties.put(string4, string5);
    }
}
