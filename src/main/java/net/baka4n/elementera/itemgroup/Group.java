package net.baka4n.elementera.itemgroup;

import net.baka4n.elementera.common.itemsettings.ELitems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static net.baka4n.elementera.Elementera.modid;

public class Group {
    public static final ItemGroup Materials = FabricItemGroupBuilder.create(
            new Identifier(modid, "materials"))
            .icon(() -> new ItemStack(ELitems.protium)).build();

    public static final ItemGroup Metal = FabricItemGroupBuilder.create(
            new Identifier(modid, "metal"))
            .icon(() -> new ItemStack(ELitems.lithium_6)).build();

    public static final ItemGroup Gas = FabricItemGroupBuilder.create(
            new Identifier(modid, "gas"))
            .icon(() -> new ItemStack(ELitems.protium)).build();
}
