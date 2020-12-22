package net.tgkt.harmod;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;

public class HarFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public HarFurnaceBlockEntity() {
        super(HarCookingRecipe.HAR_FURNACE_BLOCK_ENTITY, HarCookingRecipe.HAR_RECIPE_TYPE);
    }

    @Override
    public Text getContainerName() {
        return Text.of("har furnace");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new HarFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
