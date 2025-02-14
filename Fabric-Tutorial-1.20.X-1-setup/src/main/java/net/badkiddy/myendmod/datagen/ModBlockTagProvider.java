package net.badkiddy.myendmod.datagen;

import net.badkiddy.myendmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ENDERITE_BLOCK)
                .add(ModBlocks.ENDERITE_ORE);


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ENDERITE_BLOCK)
                .add(ModBlocks.ENDERITE_ORE);


        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.ENDERITE_DUST_FENCE);


        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ENDERITE_DUST_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ENDERITE_DUST_WALL);

    }
}