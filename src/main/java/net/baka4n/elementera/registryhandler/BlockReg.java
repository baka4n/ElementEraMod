package net.baka4n.elementera.registryhandler;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface BlockReg {
    // TODO: 2020/4/4 注册方块
    static void registerBlock(String modid,String blockName, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(modid, blockName), block);
    }
    // TODO: 2020/4/4 注册方块和物品
    static void  registerBlock(String modid, String blockName, String blockItemName, Block block, BlockItem blockItem) {
        Registry.register(Registry.BLOCK, new Identifier(modid, blockName), block);
        Registry.register(Registry.ITEM, new Identifier(modid, blockItemName), blockItem);
    }
    // TODO: 2020/4/4 增加两种注册方式
}
