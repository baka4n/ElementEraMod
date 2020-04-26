package io.github.elementera.items;


import net.minecraft.item.Item;

import static io.github.elementera.items.Public.*;

public class Protium extends Item {
    public Protium() { super(new Item.Settings().group(GAS).maxCount(16)); }
}class Deuterium extends Item {
    public Deuterium() { super(new Settings().group(GAS).maxCount(16)); }
}class Tritium extends Item {
    public Tritium() { super(new Settings().group(GAS).maxCount(16)); }
}