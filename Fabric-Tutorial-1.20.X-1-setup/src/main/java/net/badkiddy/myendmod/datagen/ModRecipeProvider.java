package net.badkiddy.myendmod.datagen;

import net.badkiddy.myendmod.block.ModBlocks;
import net.badkiddy.myendmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
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
    }
}
