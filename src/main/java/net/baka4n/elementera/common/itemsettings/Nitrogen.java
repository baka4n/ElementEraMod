package net.baka4n.elementera.common.itemsettings;

import net.baka4n.elementera.itemgroup.Group;
import net.minecraft.item.Item;

public class Nitrogen extends Item {
    public Nitrogen() {
        super(new Settings()
                .group(Group.Gas)
                .maxCount(16));
    }
}
