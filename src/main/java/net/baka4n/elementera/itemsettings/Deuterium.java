package net.baka4n.elementera.itemsettings;

import net.baka4n.elementera.itemgroup.Gas;
import net.minecraft.item.Item;

public class Deuterium extends Item {
    public Deuterium() {
        super(new Settings()
                .group(Gas.Gas)
                .maxCount(16));
    }

}
