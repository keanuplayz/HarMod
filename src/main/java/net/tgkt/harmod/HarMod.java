package net.tgkt.harmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class HarMod implements ModInitializer {
    // Item definitions
    public static final Item HARIUM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));

    // Tool definitions
    public static ToolItem HAR_PICKAXE = new HarPickaxeItem(HarToolMaterial.INSTANCE, 2, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem HAR_AXE = new HarAxeItem(HarToolMaterial.INSTANCE, 9, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem HAR_SWORD = new HarSwordItem(HarToolMaterial.INSTANCE, 8, -1.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem HAR_HOE = new HarSwordItem(HarToolMaterial.INSTANCE, 1, -1.5F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem HAR_SHOVEL = new HarSwordItem(HarToolMaterial.INSTANCE, 1, -1.5F, new Item.Settings().group(ItemGroup.TOOLS));


    // Block definitions
    public static final Block HARORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));

    private static ConfiguredFeature<?, ?> HARORE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, // Target
                    HARORE.getDefaultState(), // BlockState
                    9)) // Vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0, // bottom offset
                    0, // min y level
                    64 // max y level
                    )))
            .spreadHorizontally()
            .repeat(20); // number of veins per chunk

    @Override
    public void onInitialize() {
        // Add blocks and items to Registry
        Registry.register(Registry.ITEM, new Identifier("harmod", "harium"), HARIUM);
        Registry.register(Registry.BLOCK, new Identifier("harmod", "harore"), HARORE);
        Registry.register(Registry.ITEM, new Identifier("harmod", "har_pickaxe"), HAR_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("harmod", "harore"), new BlockItem(HARORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("harmod", "har_axe"), HAR_AXE);
        Registry.register(Registry.ITEM, new Identifier("harmod", "har_sword"), HAR_SWORD);
        Registry.register(Registry.ITEM, new Identifier("harmod", "har_hoe"), HAR_HOE);
        Registry.register(Registry.ITEM, new Identifier("harmod", "har_shovel"), HAR_SHOVEL);

        // Add ore to Registry and add the generation config to the biome generator
        RegistryKey<ConfiguredFeature<?, ?>> harOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("harmod", "harore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, harOreOverworld.getValue(), HARORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, harOreOverworld);
    }
}
