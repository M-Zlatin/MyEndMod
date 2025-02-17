package net.badkiddy.myendmod.villager;

import com.google.common.collect.ImmutableSet;
import net.badkiddy.myendmod.MyEndMod;
import net.badkiddy.myendmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

    public static final RegistryKey<PointOfInterestType> END_POI_KEY = poiKey("endpoi");
    public static final PointOfInterestType END_POI = registerPoi("endpoi", ModBlocks.ENDERITE_BLOCK);

    public static final VillagerProfession END_TRADER = registerProfession("end_trader", END_POI_KEY);

    private static VillagerProfession registerProfession(String name,RegistryKey<PointOfInterestType>type){
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(MyEndMod.MOD_ID,name),
            new VillagerProfession(name, entry-> entry.matchesKey(type),entry->entry.matchesKey(type),
                ImmutableSet.of(),ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER));
    }

    private static PointOfInterestType registerPoi(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(MyEndMod.MOD_ID, name),1,1,block);
    }


    private static RegistryKey<PointOfInterestType> poiKey(String name){
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(MyEndMod.MOD_ID,name));
    }

    public static void registerVillagers(){
        MyEndMod.LOGGER.info("Registering Villagers" + MyEndMod.MOD_ID);
    }
}
