package io.github.elementera.config;

import io.github.elementera.Loggers;

import java.io.*;
import java.util.Properties;

/**
 * if you server don't want about item? you can do this.
 */
public class RemoveItemConfig implements Loggers {
    public static final Properties pr = new Properties();
    public RemoveItemConfig() {
        File files = new File("config\\elementera");
        File file = new File("config\\elementera\\remove");
        if (!files.exists() && !files.isDirectory()) files.mkdir();if (!file.exists() && !file.isDirectory()) file.mkdir();
        try {
            pr.load(new BufferedInputStream(new FileInputStream("config\\elementera\\remove\\removeItem.rmv")));
        } catch (FileNotFoundException e) {
            pr.put("protium", "true");pr.put("helium_4", "true");pr.put("lithium_7", "true");pr.put("beryllium_8", "true");
            pr.put("carbon_12", "true");pr.put("fluorine_19", "true");pr.put("helium_5", "true");pr.put("deuterium", "true");
            pr.put("tritium", "true");pr.put("helium_2", "true");pr.put("helium_3", "true");pr.put("helium_6", "true");
            pr.put("helium_7", "true");pr.put("helium_8","true");pr.put("helium_9", "true");pr.put("helium_10", "true");
            pr.put("lithium_6", "true");pr.put("beryllium_7", "true");pr.put("beryllium_9", "true");pr.put("beryllium_10", "true");
            pr.put("boron_6", "true");pr.put("boron_7", "true");pr.put("boron_8", "true");pr.put("boron_9", "true");
            pr.put("boron_10", "true");pr.put("boron_11", "true");pr.put("boron_12", "true");pr.put("boron_13", "true");
            pr.put("boron_14", "true");pr.put("boron_15", "true");pr.put("boron_16", "true");pr.put("boron_17", "true");
            pr.put("boron_18", "true");
            try {
                pr.store(new BufferedOutputStream(new FileOutputStream("config\\elementera\\remove\\removeItem.rmv")),
                        "Remove Item Configs File.");
            } catch (IOException f) {
                f.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
