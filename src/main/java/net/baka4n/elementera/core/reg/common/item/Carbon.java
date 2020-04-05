package net.baka4n.elementera.core.reg.common.item;

import net.baka4n.elementera.core.reg.common.item.reg.RegGroup;
import net.minecraft.item.Item;

public class Carbon extends Item {
    public Carbon() {
        super(new Settings()
                .group(RegGroup.Materials)
                .maxCount(16));
    }
}
