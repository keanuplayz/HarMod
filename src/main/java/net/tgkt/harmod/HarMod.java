package net.tgkt.harmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HarMod implements ModInitializer {

    public static final Block HARORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("harmod", "harore"), HARORE);
        Registry.register(Registry.ITEM, new Identifier("harmod", "harore"), new BlockItem(HARORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

    }
}
