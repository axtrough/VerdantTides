package net.raccoon.will.verdant_tides.common.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class AquaBracelet extends Item implements ICurioItem {
    public AquaBracelet(Properties properties) {
        super(new Properties().stacksTo(1));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        Player player = (Player) slotContext.entity();
        CompoundTag data = player.getPersistentData();

        boolean isNowInWater = player.isEyeInFluidType(Fluids.WATER.getFluidType());
        boolean hasDashed = data.getBoolean("HasDashed");
        boolean isCrouching = player.isCrouching();
        boolean isSwimming = player.isSwimming();

        if (isNowInWater) {
            Vec3 movement = isSwimming ? player.getLookAngle().scale(0.03) : player.getKnownMovement().scale(0.15);
            player.addDeltaMovement(movement);
        } else if (!isNowInWater && !hasDashed && !isCrouching) {
            double dashStrength = 0.8;
            Vec3 lookDirection = player.getLookAngle();
            Vec3 dashVelocity = lookDirection.scale(dashStrength).multiply(1.1, 1.0, 1.1);
            player.addDeltaMovement(dashVelocity);
            data.putBoolean("HasDashed", true);
        } if (isNowInWater && hasDashed) {
            data.putBoolean("HasDashed", false);
        }

        if (isNowInWater) {
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0, false, false));
        } else {
            player.removeEffectNoUpdate(MobEffects.WATER_BREATHING);
        }

        ICurioItem.super.curioTick(slotContext, stack);
    }
}




























