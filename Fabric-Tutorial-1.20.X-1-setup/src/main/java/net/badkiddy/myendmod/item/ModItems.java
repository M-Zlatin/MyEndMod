package net.badkiddy.myendmod.item;

import net.badkiddy.myendmod.MyEndMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ENDERITE = registerItem("enderite", new Item(new FabricItemSettings()));

    private static void addItemsToIngriedensTabItemGrop(FabricItemGroupEntries entries) {
        entries.add(ENDERITE);
    }



    private static Item registerItem(String name,Item item){
        return Registry.register(Registries.ITEM, new Identifier(MyEndMod.MOD_ID,name),item);
    }

    public static void registerModItems(){
        MyEndMod.LOGGER.info("Registering Mod Items for " + MyEndMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngriedensTabItemGrop);
    }
}
