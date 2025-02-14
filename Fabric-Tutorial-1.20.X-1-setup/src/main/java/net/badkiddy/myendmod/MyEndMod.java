package net.badkiddy.myendmod;


import net.badkiddy.myendmod.block.ModBlocks;
import net.badkiddy.myendmod.effect.ModEffects;
import net.badkiddy.myendmod.item.ModItemGroups;
import net.badkiddy.myendmod.item.ModItems;
import net.badkiddy.myendmod.potion.ModPotions;
import net.badkiddy.myendmod.util.ModLootTableModifiers;
import net.badkiddy.myendmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyEndMod implements ModInitializer {
	public static final String MOD_ID = "myendmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();

		ModEffects.registerEffects();
		ModPotions.registerPotions();

		ModLootTableModifiers.modifyLootTables();

	}
}