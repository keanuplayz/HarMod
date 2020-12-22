package net.tgkt.harmod;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class HarRecipe extends AbstractCookingRecipe {
    public HarRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(HarCookingRecipe.HAR_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(Items.BLACKSTONE);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return HarCookingRecipe.HAR_RECIPE_SERIALIZER;
    }
}
