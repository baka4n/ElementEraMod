package net.baka4n.elementera.itemsettings;

import net.baka4n.elementera.itemgroup.Group;
import net.minecraft.item.Item;

public class Boron extends Item {
    public Boron() {
        super(new Item.Settings()
                .group(Group.Materials)
                .maxCount(16));
    }
}
