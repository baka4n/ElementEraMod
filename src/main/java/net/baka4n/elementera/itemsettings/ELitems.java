package net.baka4n.elementera.itemsettings;

import net.baka4n.elementera.Elementera;
import net.baka4n.elementera.registryhandler.ItemReg;
import net.minecraft.item.Item;

// TODO: 2020/4/4 添加物品中
// TODO: 2020/4/4 先把物品补全然后再思考其他的
public class ELitems implements ItemReg {
    public static final Protium protium = new Protium();
    public static final Deuterium deuterium = new Deuterium();
    public static final Tritium tritium = new Tritium();
    public static final Helium helium_2 = new Helium();
    public static final Helium helium_3 = new Helium();
    public static final Helium helium = new Helium();
    public static final Helium helium_5 = new Helium();
    public static final Helium helium_6 = new Helium();
    public static final Helium helium_7 = new Helium();
    public static final Helium helium_8 = new Helium();
    public static final Helium helium_9 = new Helium();
    public static final Helium helium_10 = new Helium();
    public static final Lithium lithium_6 = new Lithium();
    public static final Lithium lithium = new Lithium();
    public static final Beryllium beryllium_7 = new Beryllium();
    public static final Beryllium beryllium = new Beryllium();
    public static final Beryllium beryllium_9 = new Beryllium();
    public static final Beryllium beryllium_10 = new Beryllium();
    public static final Boron boron_6 = new Boron();
    public static final Boron boron_7 = new Boron();
    public static final Boron boron_8 = new Boron();
    public static final Boron boron_9 = new Boron();
    public static final Boron boron_10 = new Boron();
    public static final Boron boron_11 = new Boron();
    public static final Boron boron_12 = new Boron();
    public static final Boron boron_13 = new Boron();
    public static final Boron boron_14 = new Boron();
    public static final Boron boron_15 = new Boron();
    public static final Boron boron_16 = new Boron();
    public static final Boron boron_17 = new Boron();
    public static final Boron boron_18 = new Boron();
    public static final Boron boron_19 = new Boron();
    public static final Carbon carbon_8 = new Carbon();
    public static final Carbon carbon_9 = new Carbon();
    public static final Carbon carbon_10 = new Carbon();
    public static final Carbon carbon_11 = new Carbon();
    public static final Carbon carbon = new Carbon();
    public static final Carbon carbon_13 = new Carbon();
    public static final Carbon carbon_14 = new Carbon();
    public static final Carbon carbon_15 = new Carbon();
    public static final Carbon carbon_16 = new Carbon();
    public static final Carbon carbon_17 = new Carbon();
    public static final Carbon carbon_18 = new Carbon();
    public static final Carbon carbon_19 = new Carbon();
    public static final Carbon carbon_20 = new Carbon();
    public static final Carbon carbon_21 = new Carbon();
    public static final Carbon carbon_22 = new Carbon();
    public static final Nitrogen nitrogen_10 = new Nitrogen();
    public static final Nitrogen nitrogen_11 = new Nitrogen();
    public static final Nitrogen nitrogen_25 = new Nitrogen();
    public static final Oxygen oxygen = new Oxygen();

    public ELitems() {
        registerItem("protium", protium);
        registerItem("deuterium", deuterium);
        registerItem("tritium", tritium);
        registerItem("helium_2", helium_2);
        registerItem("helium_3", helium_3);
        registerItem("helium", helium);
        registerItem("helium_5", helium_5);
        registerItem("helium_6", helium_6);
        registerItem("helium_7", helium_7);
        registerItem("helium_8", helium_8);
        registerItem("helium_9", helium_9);
        registerItem("helium_10", helium_10);
        registerItem("lithium_6", lithium_6);
        registerItem("lithium", lithium);
        registerItem("beryllium_7", beryllium_7);
        registerItem("beryllium", beryllium);
        registerItem("beryllium_9", beryllium_9);
        registerItem("beryllium_10", beryllium_10);
        registerItem("Boron_6", boron_6);
        registerItem("boron_7", boron_7);
        registerItem("boron_8", boron_8);
        registerItem("boron_9", boron_9);
        registerItem("boron_10", boron_10);
        registerItem("boron_11", boron_11);
        registerItem("boron_12", boron_12);
        registerItem("boron_13", boron_13);
        registerItem("boron_14", boron_14);
        registerItem("boron_15", boron_15);
        registerItem("boron_16", boron_16);
        registerItem("boron_17", boron_17);
        registerItem("boron_18", boron_18);
        registerItem("boron_19", boron_19);
        registerItem("carbon_8", carbon_8);
        registerItem("carbon_9", carbon_9);
        registerItem("carbon_10", carbon_10);
        registerItem("carbon_11", carbon_11);
        registerItem("carbon", carbon);
        registerItem("carbon_13", carbon_13);
        registerItem("carbon_14", carbon_14);
        registerItem("carbon_15", carbon_15);
        registerItem("carbon_16", carbon_16);
        registerItem("carbon_17", carbon_17);
        registerItem("carbon_18", carbon_18);
        registerItem("carbon_19", carbon_19);
        registerItem("carbon_20", carbon_20);
        registerItem("carbon_21", carbon_21);
        registerItem("carbon_22", carbon_22);
        registerItem("nitrogen_10", nitrogen_10);
        registerItem("nitrogen_11", nitrogen_11);
        registerItem("nitrogen_25", nitrogen_25);
        registerItem("oxygen", oxygen);
    }

    private static void registerItem(String itemName, Item item) {
        ItemReg.registerItem(Elementera.modid, itemName, item);
    }
}
