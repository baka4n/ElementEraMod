package io.github.elementera.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import static io.github.elementera.items.Public.GAS;

public class F14 extends Item {
    public static final ItemGroup g = GAS;
    public F14() { super(new Settings().group(g).maxCount(16)); }
}

