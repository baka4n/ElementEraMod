package net.baka4n.elementera.core.reg.common.item;


import net.baka4n.elementera.core.reg.common.item.reg.RegGroup;
import net.minecraft.item.Item;

public class Boron extends Item {
    public Boron() {
        super(new Settings()
                .group(RegGroup.Materials)
                .maxCount(16));
    }
}
