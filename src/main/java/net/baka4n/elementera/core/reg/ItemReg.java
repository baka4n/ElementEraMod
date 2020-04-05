package net.baka4n.elementera.core.reg;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface ItemReg {
    static void regItem(String modid, String itemN, Item item) {
        Registry.register(Registry.ITEM, new Identifier(modid, itemN), item);
    }
}
