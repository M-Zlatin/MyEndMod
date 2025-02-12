package net.badkiddy.myendmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class SleepEffect extends StatusEffect {
    public SleepEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {
            World world = entity.getWorld();

            if (world instanceof ServerWorld serverWorld && serverWorld.isNight()) {
                serverWorld.setTimeOfDay(0); // Instantly set time to morning
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration == 1; // Apply only once
    }
}
