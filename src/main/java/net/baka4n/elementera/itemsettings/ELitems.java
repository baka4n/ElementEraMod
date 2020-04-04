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
        registerItem("oxygen", oxygen);
    }

    private static void registerItem(String itemName, Item item) {
        ItemReg.registerItem(Elementera.modid, itemName, item);
    }
}
