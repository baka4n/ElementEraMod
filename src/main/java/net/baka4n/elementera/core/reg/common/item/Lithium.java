package net.baka4n.elementera.core.reg.common.item;

import net.baka4n.elementera.core.reg.common.item.reg.RegGroup;
import net.minecraft.item.Item;

public class Lithium extends Item {
    public Lithium() {
        super(new Settings()
                .group(RegGroup.Metal)
                .maxCount(16));
    }

}
