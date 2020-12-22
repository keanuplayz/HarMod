package net.tgkt.harmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HarCookingRecipe implements ModInitializer {
    public static final Block HAR_FURNACE_BLOCK;
    public static final BlockEntityType HAR_FURNACE_BLOCK_ENTITY;
    public static final RecipeType<HarRecipe> HAR_RECIPE_TYPE;
    public static final RecipeSerializer<HarRecipe> HAR_RECIPE_SERIALIZER;
    public static final ScreenHandlerType<HarFurnaceScreenHandler> HAR_FURNACE_SCREEN_HANDLER;

    static {
        // Block
        HAR_FURNACE_BLOCK = Registry.register(Registry.BLOCK, new Identifier("harmod", "har_furnace"), new HarFurnace(FabricBlockSettings.of(Material.METAL)));
        // BlockItem
        Registry.register(Registry.ITEM, new Identifier("harmod", "har_furnace"), new BlockItem(HAR_FURNACE_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS)));
        // BlockEntity
        HAR_FURNACE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("harmod", "har_furnace"), BlockEntityType.Builder.create(HarFurnaceBlockEntity::new, HAR_FURNACE_BLOCK).build(null));
        // RecipeType
        HAR_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, new Identifier("harmod", "har_furnace"), new RecipeType<HarRecipe>() {
            @Override
            public String toString() { return "har_furnace"; }
        });
        HAR_RECIPE_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier("harmod", "har_furnace"), new CookingRecipeSerializer(HarRecipe::new, 200));
        HAR_FURNACE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("harmod", "har_furnace"), HarFurnaceScreenHandler::new);
    }

    @Override
    public void onInitialize() {
    }
}
