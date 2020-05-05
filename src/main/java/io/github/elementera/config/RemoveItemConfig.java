package io.github.elementera.config;
import io.github.elementera.Loggers;
import java.io.*;
import static io.github.elementera.config.Config.*;
/**
 * if you server don't want about item? you can do this.
 */
public class RemoveItemConfig implements Loggers {
    public static final MyProperties pr = new MyProperties();
    public RemoveItemConfig() {
        mkDirs("config"+ s +"elementera"); mkDirs("config" + s +"elementera" + s + "remove");
        try {
            pr.load(new BufferedInputStream(new FileInputStream("config" + s +"elementera" + s + "remove" + s + "removeItem.rmv")));
        } catch (FileNotFoundException e) {
            putFour("protium", "deuterium", "tritium", "helium_2"); putFour("helium_3", "helium_4", "helium_5", "helium_6");
            putFour("helium_7", "helium_8", "helium_9", "helium_10"); putFour("lithium_6", "lithium_7", "beryllium_7", "beryllium_8");
            putFour("beryllium_9", "beryllium_10", "boron_6", "boron_7"); putFour("boron_8", "boron_9", "boron_10", "boron_11");
            putFour("boron_12", "boron_13", "boron_14", "boron_15"); putFour("boron_16", "boron_17", "boron_18", "boron_19");
            putFour("carbon_8", "carbon_9", "carbon_10", "carbon_11"); putFour("carbon_12", "carbon_13", "carbon_14", "carbon_15");
            putFour("carbon_16", "carbon_17", "carbon_18", "carbon_19"); putFour("carbon_20", "carbon_21", "carbon_22", "nitrogen_10");
            putFour("nitrogen_11", "nitrogen_12", "nitrogen_13", "nitrogen_14"); putFour("nitrogen_15", "nitrogen_16", "nitrogen_17", "nitrogen_18");
            putFour("nitrogen_19", "nitrogen_20", "nitrogen_21", "nitrogen_22"); putFour("nitrogen_23", "nitrogen_24", "nitrogen_25", "oxygen_13");
            putFour("oxygen_14", "oxygen_15", "oxygen_16", "oxygen_17"); putFour("oxygen_17", "oxygen_18", "oxygen_19", "oxygen_20");
            putFour("oxygen_21", "oxygen_22", "oxygen_23", "oxygen_24"); putFour("fluorine_14", "fluorine_15", "fluorine_16", "fluorine_17");
            putFour("fluorine_18", "fluorine_19", "fluorine_20", "fluorine_21"); putFour("fluorine_22", "fluorine_23", "fluorine_24", "fluorine_25");
            putFour("fluorine_26", "fluorine_27", "fluorine_28", "fluorine_29"); putin("fluorine_30", "fluorine_31");
            try {
                pr.store(new BufferedOutputStream(new FileOutputStream("config" + s +"elementera" + s + "remove" + s + "removeItem.rmv")),
                        "Remove Item Configs File.");
            } catch (IOException f) { f.printStackTrace(); }
        } catch (IOException e) { e.printStackTrace(); }
    }
    public static void putFour(String s1, String s2, String s3, String s4) { putin(s1, s2); putin(s3, s4); }
    public static void putin(String s1, String s2) { if (!s1.equals("null")) pr.put(s1, "true"); if (!s2.equals("null")) pr.put(s2, "true"); }

}
