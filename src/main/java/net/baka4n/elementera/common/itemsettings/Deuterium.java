package net.baka4n.elementera.common.itemsettings;

import net.baka4n.elementera.itemgroup.Group;
import net.minecraft.item.Item;

public class Deuterium extends Item {
    public Deuterium() {
        super(new Settings()
                .group(Group.Gas)
                .maxCount(16));
    }

}
