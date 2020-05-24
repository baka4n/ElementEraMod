package io.github.elementera.api.config;

import java.io.*;

import static io.github.elementera.api.config.Config.mkDirs;
import static io.github.elementera.api.config.Config.s;
/**
 * if you server don't want about item? you can do this.
 */
public class 移除物品 {
    public static final 有序排列对 pr = new 有序排列对();
    public static final String
            /*hydrogen*/protium = "protium", deuterium = "deuterium", tritium = "tritium", hydrogen_4 = "hydrogen_4", hydrogen_5 = "hydrogen_5", hydrogen_6 = "hydrogen_6", hydrogen_7 = "hydrogen_7",
            /*helium*/helium_3 = "helium_3", helium_4 = "helium_4", helium_5 = "helium_5", helium_6 = "helium_6", helium_7 = "helium_7", helium_8 = "helium_8", helium_9 = "helium_9", helium_10 = "helium_10",
            /*lithium*/lithium_4 = "lithium_4", lithium_5 = "lithium_5", lithium_6 = "lithium_6", lithium_7 = "lithium_7", lithium_8 = "lithium_8", lithium_9 = "lithium_9", lithium_10 = "lithium_10", lithium_11 = "lithium_11", lithium_12 = "lithium_12", lithium_13 ="lithium_13",
            /*beryllium*/beryllium_5 = "beryllium_5", beryllium_6 = "beryllium_6", beryllium_7 = "beryllium_7", beryllium_8 = "beryllium_8", beryllium_9 = "beryllium_9", beryllium_10 = "beryllium_10", beryllium_11 = "beryllium_11", beryllium_12 ="beryllium_12", beryllium_13 = "beryllium_13", beryllium_14 = "beryllium_14", beryllium_15 = "beryllium_15", beryllium_16 = "beryllium_16",
            /*boron*/boron_7 = "boron_7", boron_8 = "boron_8", boron_9 = "boron_9", boron_10 ="boron_10", boron_11 = "boron_11", boron_12 = "boron_12", boron_13 = "boron_13", boron_14 = "boron_14", boron_15 = "boron_15", boron_16 = "boron_16", boron_17 = "boron_17", boron_18 = "boron_18", boron_19 = "boron_19", boron_20 = "boron_20", boron_21 = "boron_21",
            /*carbon*/carbon_8 = "carbon_8", carbon_9 = "carbon_9", carbon_10 = "carbon_10", carbon_11 = "carbon_11", carbon_12 = "carbon_12", carbon_13 = "carbon_13", carbon_14 = "carbon_14", carbon_15 = "carbon_15", carbon_16 = "carbon_16", carbon_17 = "carbon_17", carbon_18 = "carbon_18", carbon_19 = "carbon_19", carbon_20 = "carbon_20", carbon_21 = "carbon_21", carbon_22 = "carbon_22", carbon_23 = "carbon_23",
            /*nitrogen*/nitrogen_10 = "nitrogen_10", nitrogen_11 = "nitrogen_11", nitrogen_12 = "nitrogen_12", nitrogen_13 = "nitrogen_13", nitrogen_14 = "nitrogen_14", nitrogen_15 = "nitrogen_15", nitrogen_16 = "nitrogen_16", nitrogen_17 = "nitrogen_17", nitrogen_18 = "nitrogen_18", nitrogen_19 = "nitrogen_19", nitrogen_20 = "nitrogen_20", nitrogen_21 = "nitrogen_21", nitrogen_22 = "nitrogen_22", nitrogen_23 = "nitrogen_23", nitrogen_24 = "nitrogen_24", nitrogen_25 = "nitrogen_25",
            /*oxygen*/oxygen_12 = "oxygen_12", oxygen_13 = "oxygen_13", oxygen_14 = "oxygen_14", oxygen_15 = "oxygen_15", oxygen_16 = "oxygen_16", oxygen_17 = "oxygen_17", oxygen_18 = "oxygen_18", oxygen_19 = "oxygen_19", oxygen_20 = "oxygen_20", oxygen_21 = "oxygen_21", oxygen_22 = "oxygen_22", oxygen_23 = "oxygen_23", oxygen_24 = "oxygen_24", oxygen_25 = "oxygen_25", oxygen_26 = "oxygen_26", oxygen_27 = "oxygen_27", oxygen_28 = "oxygen_28",
            /*fluorine*/fluorine_14 = "fluorine_14", fluorine_15 = "fluorine_15", fluorine_16 = "fluorine_16", fluorine_17 = "fluorine_17", fluorine_18 = "fluorine_18", fluorine_19 = "fluorine_19", fluorine_20 = "fluorine_20", fluorine_21 = "fluorine_21", fluorine_22 = "fluorine_22", fluorine_23 = "fluorine_23", fluorine_24 = "fluorine_24", fluorine_25 = "fluorine_25", fluorine_26 = "fluorine_26", fluorine_27 = "fluorine_27", fluorine_28 = "fluorine_28", fluorine_29 = "fluorine_29", fluorine_30 = "fluorine_30", fluorine_31 = "fluorine_31",
            /*neon*/neon_16 = "neon_16", neon_17 = "neon_17", neon_18 = "neon_18", neon_19 = "neon_19", neon_20 = "neon_20", neon_21 = "neon_21", neon_22 = "neon_22", neon_23 = "neon_23", neon_24 = "neon_24", neon_25 = "neon_25", neon_26 = "neon_26", neon_27 = "neon_27", neon_28 = "neon_28",neon_29 = "neon_29", neon_30 = "neon_30", neon_31 = "neon_31", neon_32 = "neon_32", neon_33 = "neon_33", neon_34 = "neon_34", sodium_18 = "sodium_18", sodium_19 = "sodium_19";
    public 移除物品() {
        mkDirs("config"+ s +"elementera"); mkDirs("config" + s +"elementera" + s + "remove");
        try {
            pr.load(new BufferedInputStream(new FileInputStream("config" + s +"elementera" + s + "remove" + s + "removeItem.rmv")));
        } catch (FileNotFoundException e) {
            putFour(protium, deuterium, tritium, hydrogen_4);
            putFour(hydrogen_5, hydrogen_6, hydrogen_7, helium_3);
            putFour(helium_4, helium_5, helium_6, helium_7);
            putFour(helium_8, helium_9, helium_10, lithium_4);
            putFour(lithium_5, lithium_6, lithium_7, lithium_8);
            putFour(lithium_9, lithium_10, lithium_11, lithium_12);
            putFour(lithium_13, beryllium_5, beryllium_6, beryllium_7);
            putFour(beryllium_8, beryllium_9, beryllium_10, beryllium_11);
            putFour(beryllium_12, beryllium_13, beryllium_14, beryllium_15);
            putFour(beryllium_16, boron_7, boron_8, boron_9);
            putFour(boron_10, boron_11, boron_12, boron_13);
            putFour(boron_14, boron_15, boron_16, boron_17);
            putFour(boron_18, boron_19, boron_20, boron_21);
            putFour(carbon_8, carbon_9, carbon_10, carbon_11);
            putFour(carbon_12, carbon_13, carbon_14, carbon_15);
            putFour(carbon_16, carbon_17, carbon_18, carbon_19);
            putFour(carbon_20, carbon_21, carbon_22, carbon_23);
            putFour(nitrogen_10, nitrogen_11, nitrogen_12, nitrogen_13);
            putFour(nitrogen_14, nitrogen_15, nitrogen_16, nitrogen_17);
            putFour(nitrogen_18, nitrogen_19, nitrogen_20, nitrogen_21);
            putFour(nitrogen_22, nitrogen_23, nitrogen_24, nitrogen_25);
            putFour(oxygen_12, oxygen_13, oxygen_14, oxygen_15);
            putFour(oxygen_16, oxygen_17, oxygen_18, oxygen_19);
            putFour(oxygen_20, oxygen_21, oxygen_22, oxygen_23);
            putFour(oxygen_24, oxygen_25, oxygen_26, oxygen_27);
            putFour(oxygen_28, fluorine_14, fluorine_15, fluorine_16);
            putFour(fluorine_17, fluorine_18, fluorine_19, fluorine_20);
            putFour(fluorine_21, fluorine_22, fluorine_23, fluorine_24);
            putFour(fluorine_25, fluorine_26, fluorine_27, fluorine_28);
            putFour(fluorine_29, fluorine_30, fluorine_31, neon_16);
            putFour(neon_17, neon_18, neon_19, neon_20);
            putFour(neon_21, neon_22, neon_23, neon_24);
            putFour(neon_25, neon_26, neon_27, neon_28);
            putFour(neon_29, neon_30, neon_31, neon_32);
            putFour(neon_33, neon_34, sodium_18, sodium_19);
            putFour("sodium_18", "sodium_19", "sodium_20", "sodium_21");
            putFour("sodium_22", "sodium_23", "sodium_24", "sodium_25");
            putFour("sodium_26", "sodium_27", "sodium_28", "sodium_29");
            putFour("sodium_30", "sodium_31", "sodium_32", "sodium_33");
            putFour("sodium_34", "sodium_35", "sodium_36", "sodium_37");
            putFour("magnesium_19", "magnesium_20", "magnesium_21", "magnesium_22");
            putFour("magnesium_23", "magnesium_24", "magnesium_25", "magnesium_26");
            putFour("magnesium_27", "magnesium_28", "magnesium_29", "magnesium_30");
            putFour("magnesium_31", "magnesium_32", "magnesium_33", "magnesium_34");
            putFour("magnesium_32", "magnesium_33", "magnesium_34", "magnesium_35");
            putFour("magnesium_36", "magnesium_37", "magnesium_38", "magnesium_39");
            putFour("magnesium_40", "aluminum_21", "aluminum_22", "aluminum_23");
            putFour("aluminum_24", "aluminum_25", "aluminum_26", "aluminum_27");
            putFour("aluminum_28", "aluminum_29", "aluminum_30", "aluminum_31");
            putFour("aluminum_32", "aluminum_33", "aluminum_34", "aluminum_35");
            putFour("aluminum_36", "aluminum_37", "aluminum_38", "aluminum_39");
            putFour("aluminum_40", "aluminum_41", "aluminum_42", "aluminum_43");
            try {
                pr.store(new BufferedOutputStream(new FileOutputStream("config" + s +"elementera" + s + "remove" + s + "removeItem.rmv")),
                        "Remove Item Configs File.");
            } catch (IOException f) { f.printStackTrace(); }
        } catch (IOException e) { e.printStackTrace(); }
    }
    public static void putFour(String s1, String s2, String s3, String s4) { putin(s1, s2); putin(s3, s4); }
    public static void putin(String s1, String s2) { if (!s1.equals("null")) pr.put(s1, "true"); if (!s2.equals("null")) pr.put(s2, "true"); }

}
