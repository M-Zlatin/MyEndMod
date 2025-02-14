package net.badkiddy.myendmod.util;

import net.badkiddy.myendmod.block.ModBlocks;
import net.badkiddy.myendmod.item.ModItems;
import net.badkiddy.myendmod.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.village.TradeOffer;

public class ModCustomTrades {

    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.END_TRADER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.ENDERITE, 32),
                    new ItemStack(ModBlocks.ENDERITE_ORE, 2),
                    6, 12, 0.075f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.END_TRADER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.ENDERITE_BOOTS, 1),
                    new ItemStack(ModItems.ENDERITE_LEGGINGS, 1),
                    2, 12, 0.075f
            ));
        });
    }

    static {
        registerCustomTrades();
    }
}
