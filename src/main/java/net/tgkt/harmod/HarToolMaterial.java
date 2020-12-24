package net.tgkt.harmod;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class HarToolMaterial implements ToolMaterial {


    public static final HarToolMaterial INSTANCE = new HarToolMaterial();
    @Override
    public int getDurability() {
        return 2048;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 13.0F;
    }

    @Override
    public float getAttackDamage() {
        return 2;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.AIR);
    }
}
