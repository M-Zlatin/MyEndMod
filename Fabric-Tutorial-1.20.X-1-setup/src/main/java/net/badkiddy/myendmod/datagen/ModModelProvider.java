package net.badkiddy.myendmod.datagen;

import net.badkiddy.myendmod.block.ModBlocks;
import net.badkiddy.myendmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDERITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDERITE_ORE);
        BlockStateModelGenerator.BlockTexturePool enderitePool= blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ENDERITE_DUST_BLOCK);

        enderitePool.stairs(ModBlocks.ENDERITE_DUST_STAIRS);
        enderitePool.slab(ModBlocks.ENDERITE_DUST_SLAB);
        enderitePool.pressurePlate(ModBlocks.ENDERITE_DUST_PRESSURE_PLATE);
        enderitePool.fenceGate(ModBlocks.ENDERITE_DUST_FENCE_GATE);
        enderitePool.button(ModBlocks.ENDERITE_DUST_BUTTON);
        enderitePool.wall(ModBlocks.ENDERITE_DUST_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.ENDERITE_DUST_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ENDERITE_DUST_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ENDERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERITE_UPGRADE_TOOL,Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERITE_DUST,Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_BOOTS));

    }
}