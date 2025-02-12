package net.badkiddy.myendmod.effect;

import net.badkiddy.myendmod.MyEndMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;  // Use Registries here
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect SLEEP;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(MyEndMod.MOD_ID, name),  // Use Registries.STATUS_EFFECT
                new SleepEffect(StatusEffectCategory.NEUTRAL,3124117));
    }

    public static void registerEffects() {
        SLEEP = registerStatusEffect("sleep");
    }
}
