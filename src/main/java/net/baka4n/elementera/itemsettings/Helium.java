package net.baka4n.elementera.itemsettings;

import net.baka4n.elementera.itemgroup.Group;
import net.minecraft.item.Item;

public class Helium extends Item {
    public Helium() {
        super(new Settings()
                .group(Group.Gas)
                .maxCount(16));
    }
}
