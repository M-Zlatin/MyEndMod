package net.badkiddy.myendmod.datagen;

import net.badkiddy.myendmod.block.ModBlocks;
import net.badkiddy.myendmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ENDERITE_BLOCK);
        addDrop(ModBlocks.ENDERITE_ORE, copperLikeOreDrops(ModBlocks.ENDERITE_ORE, ModItems.ENDERITE_DUST));

        addDrop(ModBlocks.ENDERITE_DUST_FENCE_GATE);
        addDrop(ModBlocks.ENDERITE_DUST_FENCE);
        addDrop(ModBlocks.ENDERITE_DUST_WALL);
        addDrop(ModBlocks.ENDERITE_DUST_PRESSURE_PLATE);
        addDrop(ModBlocks.ENDERITE_DUST_STAIRS);
        addDrop(ModBlocks.ENDERITE_DUST_SLAB,slabDrops(ModBlocks.ENDERITE_DUST_SLAB));
        addDrop(ModBlocks.ENDERITE_DUST_BLOCK);
        addDrop(ModBlocks.ENDERITE_DUST_BUTTON);
        addDrop(ModBlocks.ENDERITE_DUST_DOOR ,doorDrops(ModBlocks.ENDERITE_DUST_DOOR));
        addDrop(ModBlocks.ENDERITE_DUST_TRAPDOOR);
    }

    public LootTable.Builder copperLikeOreDrops(Block block, Item item) {
        // Create a LootTable.Builder using LootPool entries
        LootTable.Builder lootTableBuilder = LootTable.builder();

        lootTableBuilder.pool(LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 1)) // Standard single drop (no Silk Touch)
                .with(ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)))));

        // Apply the Fortune bonus to the drops
        lootTableBuilder.apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE));

        return lootTableBuilder;
    }
}
