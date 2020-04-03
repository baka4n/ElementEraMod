package net.baka4n.elementera.itemsettings;

import net.baka4n.elementera.Elementera;
import net.baka4n.elementera.registryhandler.ItemReg;
import net.minecraft.item.Item;

public class ELitems implements ItemReg {
    public static final Protium protium = new Protium();
    public static final Deuterium deuterium = new Deuterium();
    public static final Oxygen oxygen = new Oxygen();

    public ELitems() {
        registeriTEM("protium", protium);
        registeriTEM("deuterium", deuterium);
        registeriTEM("oxygen", oxygen);
    }

    private static void registeriTEM(String itemName, Item item) {
        ItemReg.registerItem(Elementera.modid, itemName, item);
    }
}
