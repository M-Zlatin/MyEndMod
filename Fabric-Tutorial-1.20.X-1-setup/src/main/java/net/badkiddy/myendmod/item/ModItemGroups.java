package net.badkiddy.myendmod.item;

import net.badkiddy.myendmod.MyEndMod;
import net.badkiddy.myendmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ENDERITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MyEndMod.MOD_ID, "enderite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.enderite"))
                    .icon(() -> new ItemStack(ModItems.ENDERITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ENDERITE);
                        entries.add(ModBlocks.ENDERITE_BLOCK);
                        entries.add(ModBlocks.ENDERITE_ORE);
                        entries.add(ModItems.ENDERITE_UPGRADE_TOOL);
                        entries.add(ModItems.ENDERITE_DUST);
                        entries.add(ModBlocks.ENDERITE_DUST_BLOCK);

                        entries.add(ModBlocks.ENDERITE_DUST_DOOR);
                        entries.add(ModBlocks.ENDERITE_DUST_FENCE);
                        entries.add(ModBlocks.ENDERITE_DUST_FENCE_GATE);
                        entries.add(ModBlocks.ENDERITE_DUST_WALL);
                        entries.add(ModBlocks.ENDERITE_DUST_TRAPDOOR);
                        entries.add(ModBlocks.ENDERITE_DUST_BUTTON);
                        entries.add(ModBlocks.ENDERITE_DUST_PRESSURE_PLATE);
                        entries.add(ModBlocks.ENDERITE_DUST_SLAB);
                        entries.add(ModBlocks.ENDERITE_DUST_STAIRS);


                        entries.add(ModItems.ENDERITE_HELMET);
                        entries.add(ModItems.ENDERITE_CHESTPLATE);
                        entries.add(ModItems.ENDERITE_LEGGINGS);
                        entries.add(ModItems.ENDERITE_BOOTS);


                    }).build());


    public static void registerItemGroups() {
        MyEndMod.LOGGER.info("Registering Item Groups for " + MyEndMod.MOD_ID);
    }
}