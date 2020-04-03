package net.baka4n.elementera.registryhandler;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface ItemReg {
    static void registerItem(String modid, String itemName, Item item) {
        Registry.register(Registry.ITEM, new Identifier(modid, itemName), item);
    }
}
