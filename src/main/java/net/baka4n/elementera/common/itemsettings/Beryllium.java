package net.baka4n.elementera.common.itemsettings;

import net.baka4n.elementera.itemgroup.Group;
import net.minecraft.item.Item;

public class Beryllium extends Item {
    public Beryllium() {
        super(new Settings()
                .group(Group.Metal)
                .maxCount(16));
    }

}
