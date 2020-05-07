package io.github.elementera.config;

import java.io.*;

import static io.github.elementera.Elementera.log;

public class Config {
    public static final String s = File.separator + File.separator;
    public static final MyProperties myproperties = new MyProperties();
    public Config() {
        mkDirs("config" + s + "elementera"); mkDirs("config" + s + "elementera" + s + "GUI");
        try { myproperties.load(new BufferedInputStream(new FileInputStream("config" + s + "elementera" + s + "GUI" + s + "config.ee")));
        } catch (FileNotFoundException e) {
            eight("title","you can edit titleScreen but You can't block the words fabric and mojang", "eula", "true","editGui", "no", "authors", "this is a authors button size", "author_hide", "no", "author_this_a", "1", "author_this_b", "2", "author_this_c", "-100");
            eight("author_this_y", "y", "author_button_width", "200", "author_button_height", "20", "sing_player_this_a", "1", "sing_player_this_b", "2", "sing_player_this_c", "-100", "sing_player_this_y", "100", "sing_player_button_width", "100");
            eight("sing_player_button_height", "20", "multiplayer_this_a","1", "multiplayer_this_b", "2", "multiplayer_this_c", "0", "multiplayer_this_y", "100", "multiplayer_button_width", "100", "multiplayer_button_height", "20", "online_this_a", "1");
            eight("online_this_b", "2", "online_this_c", "-100", "online_this_y", "120", "online_button_width", "200", "online_button_height", "20", "titleScreen_mouseX_hide", "no", "titleScreen_mouseY_hide", "no","BoPt_tick", "3000");
            log("Config", "create config success");
            try { myproperties.store(new BufferedOutputStream(new FileOutputStream("config" + s + "elementera" + s + "GUI" + s + "config.ee")), "Save Configs File.");
            } catch (IOException f) { f.printStackTrace(); }
        } catch (IOException i) { i.printStackTrace(); }
    }
    public static void eight(String s1, String s2, String s3, String s4,String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14, String s15, String s16) { myproperties.put(s1, s2);myproperties.put(s3, s4);myproperties.put(s5, s6);myproperties.put(s7, s8);myproperties.put(s9, s10);myproperties.put(s11, s12);myproperties.put(s13, s14);myproperties.put(s15, s16); }
    public static void mkDirs(String s1) { File file = new File(s1); if (!file.exists() && !file.isDirectory()) file.mkdir(); }

    public static String getProperties(String s) {
        return myproperties.getProperty(s);
    }
}
