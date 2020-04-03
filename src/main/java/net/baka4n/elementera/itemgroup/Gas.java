package net.baka4n.elementera.itemgroup;

import net.baka4n.elementera.Elementera;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static net.baka4n.elementera.Elementera.modid;

public class Gas {
    public static final ItemGroup Gas = FabricItemGroupBuilder.create(
            new Identifier(modid, "gas"))
            .icon(() -> new ItemStack(Elementera.protium)).build();
}
