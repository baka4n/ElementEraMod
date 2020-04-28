package io.github.elementera.config;

import io.github.elementera.Loggers;

import java.io.*;
import java.util.Properties;

public class Config implements Loggers {
    public static final Properties properties = new Properties();
    public Config() {
        File file = new File("config\\elementera");
        File gui = new File("config\\elementera\\GUI");
        if (!file.exists() && !file.isDirectory()) file.mkdir(); if (!gui.exists() && !gui.isDirectory()) gui.mkdir();
        try {
            properties.load(new BufferedInputStream(new FileInputStream("config\\elementera\\GUI\\config.ee")));
        } catch (FileNotFoundException e) {
            properties.put("title", "you can edit titleScreen but You can't block the words fabric and mojang");
            properties.put("eula", "true");
            properties.put("editGui", "no");
            properties.put("authors", "this is a authors button size");
            properties.put("author_hide", "no");
            properties.put("author_this_a", "1");
            properties.put("author_this_b", "2");
            properties.put("author_this_c", "-100");
            properties.put("author_this_y", "y");
            properties.put("author_button_width", "200");
            properties.put("author_button_height", "20");
            properties.put("sing_player_this_a", "1");
            properties.put("sing_player_this_b", "2");
            properties.put("sing_player_this_c", "-100");
            properties.put("sing_player_this_y", "100");
            properties.put("sing_player_button_width", "100");
            properties.put("sing_player_button_height", "20");
            properties.put("multiplayer_this_a", "1");
            properties.put("multiplayer_this_b", "2");
            properties.put("multiplayer_this_c", "0");
            properties.put("multiplayer_this_y", "100");
            properties.put("multiplayer_button_width", "100");
            properties.put("multiplayer_button_height", "20");
            properties.put("online_this_a", "1");
            properties.put("online_this_b", "2");
            properties.put("online_this_c", "-100");
            properties.put("online_this_y", "120");
            properties.put("online_button_width", "200");
            properties.put("online_button_height", "20");
            properties.put("titleScreen_mouseX_hide", "no");
            properties.put("titleScreen_mouseY_hide", "no");
            properties.put("BoPt_tick", "3000");
            configs.info("create config success");
            try {
                properties.store(new BufferedOutputStream(new FileOutputStream("config\\elementera\\GUI\\config.ee")),
                        "Save Configs File.");
            } catch (IOException f) { f.printStackTrace(); }
        } catch (IOException i) { i.printStackTrace(); }
    }
}
