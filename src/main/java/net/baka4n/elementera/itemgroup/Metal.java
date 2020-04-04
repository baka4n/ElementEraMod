package net.baka4n.elementera.itemgroup;

import net.baka4n.elementera.itemsettings.ELitems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static net.baka4n.elementera.Elementera.modid;

public class Metal {
    public static final ItemGroup Metal = FabricItemGroupBuilder.create(
            new Identifier(modid, "metal"))
            .icon(() -> new ItemStack(ELitems.lithium_6)).build();
}
