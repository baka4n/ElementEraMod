package net.baka4n.elementera.itemsettings;

import net.baka4n.elementera.itemgroup.Metal;
import net.minecraft.item.Item;

public class Lithium extends Item {
    public Lithium() {
        super(new Settings()
                .group(Metal.Metal)
                .maxCount(16));
    }

}
