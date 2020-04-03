package net.baka4n.elementera.itemsettings;

import net.baka4n.elementera.Elementera;
import net.baka4n.elementera.registryhandler.ItemReg;
import net.minecraft.item.Item;

public class ELitems implements ItemReg {
    public static final Protium protium = new Protium();
    public static final Deuterium deuterium = new Deuterium();
    public static final Oxygen oxygen = new Oxygen();
    public static final Tritium tritium = new Tritium();

    public ELitems() {
        registerItem("protium", protium);
        registerItem("deuterium", deuterium);
        registerItem("oxygen", oxygen);
        registerItem("tritium", tritium);
    }

    private static void registerItem(String itemName, Item item) {
        ItemReg.registerItem(Elementera.modid, itemName, item);
    }
}
