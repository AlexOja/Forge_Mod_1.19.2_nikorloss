package net.nikorloss.tutorialmod.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nikorloss.tutorialmod.TutorialMod;
import net.nikorloss.tutorialmod.fluid.ModFluids;
import net.nikorloss.tutorialmod.item.ModItems;

import java.util.function.Supplier;

/**
 * Some block models provided by _fungus.
 *
 * @author _fungus (<a href="https://www.planetminecraft.com/member/_fungus/">Planet Minecraft _fungus's account</a>)
 *
 */

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> CHISELED_DEEPSLATE_WARDEN = registerBlock("chiseled_deepslate_warden",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_PILLAR = registerBlock("deepslate_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_PILLAR_CAPITAL = registerBlock("deepslate_pillar_capital",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_SQUARE_TILES = registerBlock("deepslate_square_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_SQUARE_TILES_STAIRS = registerBlock("deepslate_square_tiles_stairs",
            () -> new StairBlock(ModBlocks.DEEPSLATE_SQUARE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_SQUARE_TILES_SLAB = registerBlock("deepslate_square_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_DIAGONAL_BRICKS = registerBlock("deepslate_diagonal_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_PILLAR_WALL = registerBlock("deepslate_pillar_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SCULKED_COBBLED_DEEPSLATE = registerBlock("sculked_cobbled_deepslate",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops().lightLevel((p_152651_) -> { return 10; })), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SCULKED_DEEPSLATE = registerBlock("sculked_deepslate",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops().lightLevel((p_152651_) -> { return 10; })), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<LiquidBlock> SCULK_WATER_BLOCK = BLOCKS.register("sculk_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_SCULK_WATER, BlockBehaviour.Properties.copy(Blocks.WATER).lightLevel((p_152651_) -> { return 12; })));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
