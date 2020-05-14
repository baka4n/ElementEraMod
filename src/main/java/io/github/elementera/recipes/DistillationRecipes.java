/*package io.github.elementera.recipes;

import io.github.elementera.items.Public;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.elementera.items.Public.MODID;

public class DistillationRecipes extends AbstractCookingRecipe {
    public DistillationRecipes(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(RecipeType.SMELTING, id, group, input, output, experience, cookTime);
    }

    @Environment(EnvType.CLIENT)
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(Blocks.FURNACE);
    }

    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializer.SMELTING;
    }

    RecipeType<SmeltingRecipe> SMELTING = Registry.register(Registry.RECIPE_TYPE, new Identifier(MODID, "distillation"), ));
}*/
