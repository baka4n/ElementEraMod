package net.baka4n.elementera.common.itemsettings;

import net.baka4n.elementera.itemgroup.Group;
import net.minecraft.item.Item;

public class Protium extends Item {
    public Protium() {
        super(new Settings()
                .group(Group.Gas)
                .maxCount(16));
    }

}
