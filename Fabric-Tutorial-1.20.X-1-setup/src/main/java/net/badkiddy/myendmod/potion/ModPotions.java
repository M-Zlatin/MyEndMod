package net.badkiddy.myendmod.potion;


import net.badkiddy.myendmod.MyEndMod;
import net.badkiddy.myendmod.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModPotions {
    public static Potion SLEEP_POTION;

    public static Potion registerPotion(String name) {
        return Registry.register(Registries.POTION, new Identifier(MyEndMod.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.SLEEP, 100, 0)));
    }

    public static void registerPotions() {
        SLEEP_POTION = registerPotion("sleep");
    }
}