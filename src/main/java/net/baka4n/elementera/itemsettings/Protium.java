package net.baka4n.elementera.itemsettings;

import net.baka4n.elementera.itemgroup.Gas;
import net.minecraft.item.Item;

public class Protium extends Item {
    public Protium() {
        super(new Settings()
                .group(Gas.Gas)
                .maxCount(16));
    }

}
