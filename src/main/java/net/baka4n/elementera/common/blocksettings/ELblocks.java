package net.baka4n.elementera.common.blocksettings;

import net.baka4n.elementera.Elementera;
import net.baka4n.elementera.registryhandler.BlockReg;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class ELblocks implements BlockReg {


    public ELblocks() {
        // TODO: 2020/4/4 一种注册方式
        /*
        registerBlock("name",
                "itemname",
                new Item.Settings()
                .group(Group.groupname)
                .maxCount(n)
                .build());
         */
    }

    public static void registerBlock(String blockName, String blockItemName, Block block, BlockItem blockItem) {
        BlockReg.registerBlock(Elementera.modid, blockName, blockItemName, block, blockItem);
    }
}
