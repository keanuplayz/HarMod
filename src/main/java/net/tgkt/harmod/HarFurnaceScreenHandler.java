package net.tgkt.harmod;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class HarFurnaceScreenHandler extends AbstractFurnaceScreenHandler {
    public HarFurnaceScreenHandler(int i, PlayerInventory playerInventory) {
        super(HarCookingRecipe.HAR_FURNACE_SCREEN_HANDLER, HarCookingRecipe.HAR_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory);
    }

    public HarFurnaceScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(HarCookingRecipe.HAR_FURNACE_SCREEN_HANDLER, HarCookingRecipe.HAR_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}
