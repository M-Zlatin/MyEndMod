package net.badkiddy.myendmod.datagen;

import net.badkiddy.myendmod.block.ModBlocks;
import net.badkiddy.myendmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // 🔷 Recipe 1: 9 Enderite → 1 Enderite Block
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERITE_BLOCK, 1)
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .input('E', ModItems.ENDERITE)
                .criterion(hasItem(ModItems.ENDERITE), conditionsFromItem(ModItems.ENDERITE))
                .offerTo(exporter, new Identifier("myendmod", "enderite_block_from_enderite"));

        // 🔷 Recipe 2: Enderite Upgrade Tool + Diamond + End Stone → 8 Upgrade Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENDERITE_UPGRADE_TOOL, 8)
                .pattern("WEW")
                .pattern("WSW")
                .pattern("WEW")
                .input('W', Items.DIAMOND)
                .input('E', ModItems.ENDERITE_UPGRADE_TOOL)
                .input('S', Items.END_STONE)
                .criterion(hasItem(ModItems.ENDERITE_UPGRADE_TOOL), conditionsFromItem(ModItems.ENDERITE_UPGRADE_TOOL))
                .offerTo(exporter, new Identifier("myendmod", "upgrade_tool_crafting_8"));

        // 🔷 Recipe 3: 8 Enderite Dust + 3 End Stone → 1 Enderite
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENDERITE, 1)
                .pattern("WWW")
                .pattern("WWS")
                .pattern("SSS")
                .input('W', ModItems.ENDERITE_DUST)
                .input('S', Items.END_STONE)
                .criterion(hasItem(ModItems.ENDERITE_DUST), conditionsFromItem(ModItems.ENDERITE_DUST))
                .offerTo(exporter, new Identifier("myendmod", "enderite_from_enderite_dust_and_end_stone"));


        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ENDERITE_UPGRADE_TOOL), // Slot 1: Enderite Upgrade Tool
                        Ingredient.ofItems(Items.NETHERITE_HELMET), // Slot 2: Netherite Helmet
                        Ingredient.ofItems(ModItems.ENDERITE), // Slot 3: Enderite
                        RecipeCategory.BUILDING_BLOCKS, // Category
                        ModItems.ENDERITE_HELMET // Result item - Enderite Helmet
                ).criterion(hasItem(ModItems.ENDERITE_UPGRADE_TOOL), conditionsFromItem(ModItems.ENDERITE_UPGRADE_TOOL))
                .criterion(hasItem(Items.NETHERITE_HELMET), conditionsFromItem(Items.NETHERITE_HELMET))
                .criterion(hasItem(ModItems.ENDERITE), conditionsFromItem(ModItems.ENDERITE))
                .offerTo(exporter, new Identifier("myendmod", "netherite_to_enderite_helmet"));

        // 🔷 Smithing Recipe: Upgrade Netherite Chestplate to Enderite Chestplate
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ENDERITE_UPGRADE_TOOL), // Slot 1: Enderite Upgrade Tool
                        Ingredient.ofItems(Items.NETHERITE_CHESTPLATE), // Slot 2: Netherite Chestplate
                        Ingredient.ofItems(ModItems.ENDERITE), // Slot 3: Enderite
                        RecipeCategory.BUILDING_BLOCKS,
                        ModItems.ENDERITE_CHESTPLATE
                ).criterion(hasItem(ModItems.ENDERITE_UPGRADE_TOOL), conditionsFromItem(ModItems.ENDERITE_UPGRADE_TOOL))
                .criterion(hasItem(Items.NETHERITE_CHESTPLATE), conditionsFromItem(Items.NETHERITE_CHESTPLATE))
                .criterion(hasItem(ModItems.ENDERITE), conditionsFromItem(ModItems.ENDERITE))
                .offerTo(exporter, new Identifier("myendmod", "netherite_to_enderite_chestplate"));

        // 🔷 Smithing Recipe: Upgrade Netherite Leggings to Enderite Leggings
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ENDERITE_UPGRADE_TOOL), // Slot 1: Enderite Upgrade Tool
                        Ingredient.ofItems(Items.NETHERITE_LEGGINGS), // Slot 2: Netherite Leggings
                        Ingredient.ofItems(ModItems.ENDERITE), // Slot 3: Enderite
                        RecipeCategory.BUILDING_BLOCKS,
                        ModItems.ENDERITE_LEGGINGS
                ).criterion(hasItem(ModItems.ENDERITE_UPGRADE_TOOL), conditionsFromItem(ModItems.ENDERITE_UPGRADE_TOOL))
                .criterion(hasItem(Items.NETHERITE_LEGGINGS), conditionsFromItem(Items.NETHERITE_LEGGINGS))
                .criterion(hasItem(ModItems.ENDERITE), conditionsFromItem(ModItems.ENDERITE))
                .offerTo(exporter, new Identifier("myendmod", "netherite_to_enderite_leggings"));

        // 🔷 Smithing Recipe: Upgrade Netherite Boots to Enderite Boots
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ENDERITE_UPGRADE_TOOL), // Slot 1: Enderite Upgrade Tool
                        Ingredient.ofItems(Items.NETHERITE_BOOTS), // Slot 2: Netherite Boots
                        Ingredient.ofItems(ModItems.ENDERITE), // Slot 3: Enderite
                        RecipeCategory.BUILDING_BLOCKS,
                        ModItems.ENDERITE_BOOTS
                ).criterion(hasItem(ModItems.ENDERITE_UPGRADE_TOOL), conditionsFromItem(ModItems.ENDERITE_UPGRADE_TOOL))
                .criterion(hasItem(Items.NETHERITE_BOOTS), conditionsFromItem(Items.NETHERITE_BOOTS))
                .criterion(hasItem(ModItems.ENDERITE), conditionsFromItem(ModItems.ENDERITE))
                .offerTo(exporter, new Identifier("myendmod", "netherite_to_enderite_boots"));
    }
}