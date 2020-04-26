package io.github.elementera.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

public class Config implements Loggers {
    public static final Properties properties = new Properties();
    public Config() throws IOException {
        try { properties.load(new BufferedInputStream(new FileInputStream("config.ee"))); }
        catch (FileNotFoundException e) {
            List<String> strings = Arrays.asList(
                    "title", "eula", "editGui", "authors", "author_hide", "author_this_a", "author_this_b", "author_this_c",
                    "author_this_y","author_button_width", "author_button_height", "sing_player_this_a", "sing_player_this_b",
                    "sing_player_this_c", "sing_player_this_y", "author_button_width", "author_button_height", "sing_player_this_a",
                    "sing_player_this_b", "sing_player_this_c", "sing_player_this_y", "sing_player_button_width", "sing_player_button_height",
                    "multiplayer_this_a", "multiplayer_this_b", "multiplayer_this_c", "multiplayer_this_y", "multiplayer_button_width", "multiplayer_button_height",
                    "online_this_a", "online_this_b", "online_this_c", "online_this_y", "online_button_width", "online_button_height"
            );
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
            strings.forEach(s -> logger.info(s + "create"));
            try {

                properties.store(new BufferedOutputStream(new FileOutputStream("config.ee")),
                        "Save Configs File." +
                                "\n a * this.width / b + c" +
                                "\nthis button width and this height." +
                                "\nSave Configs File." +
                                "\n a * this.width / b + c this height = = this_y" +
                                "\nthis button width and this button height");
            }
            catch (FileNotFoundException f) { f.printStackTrace(); }
            catch (IOException i) { i.printStackTrace(); }
        }
        catch (IOException i) { i.printStackTrace(); }
    }
}
interface Loggers {
    Logger logger = LogManager.getLogger("Config");
}
