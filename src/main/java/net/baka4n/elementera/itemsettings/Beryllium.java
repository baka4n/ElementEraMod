package net.baka4n.elementera.itemsettings;

import net.baka4n.elementera.itemgroup.Metal;
import net.minecraft.item.Item;

public class Beryllium extends Item {
    public Beryllium() {
        super(new Settings()
                .group(Metal.Metal)
                .maxCount(16));
    }

}
