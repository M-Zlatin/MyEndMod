package net.badkiddy.myendmod.block;

import net.badkiddy.myendmod.MyEndMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block ENDERITE_ORE = registerBlock("enderite_block_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block ENDERITE_DUST_BLOCK = registerBlock("enderite_dust_block",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.NETHERITE)));

    public static final Block ENDERITE_DUST_STAIRS = registerBlock("enderite_dust_stairs",
            new StairsBlock(ModBlocks.ENDERITE_DUST_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ENDERITE_DUST_SLAB = registerBlock("enderite_dust_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block ENDERITE_DUST_BUTTON = registerBlock("enderite_dust_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON, 10, true));
    public static final Block ENDERITE_DUST_PRESSURE_PLATE = registerBlock("enderite_dust_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));

    public static final Block ENDERITE_DUST_FENCE = registerBlock("enderite_dust_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ENDERITE_DUST_FENCE_GATE = registerBlock("enderite_dust_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.ACACIA));
    public static final Block ENDERITE_DUST_WALL = registerBlock("enderite_dust_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block ENDERITE_DUST_DOOR = registerBlock("enderite_dust_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(), BlockSetType.IRON));
    public static final Block ENDERITE_DUST_TRAPDOOR = registerBlock("enderite_dust_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(), BlockSetType.IRON));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MyEndMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MyEndMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        MyEndMod.LOGGER.info("Registering ModBlocks for " + MyEndMod.MOD_ID);
    }
}