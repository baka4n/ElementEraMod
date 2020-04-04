package net.baka4n.elementera.common.itemsettings;

import net.baka4n.elementera.itemgroup.Group;
import net.minecraft.item.Item;

public class Lithium extends Item {
    public Lithium() {
        super(new Settings()
                .group(Group.Metal)
                .maxCount(16));
    }

}
