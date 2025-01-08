package net.raccoon.will.verdant_tides.common.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Pose;
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
        boolean hasDashed = data.getBoolean("hasDashed");
        boolean isSwimming = player.isSwimming();

        boolean isNowInWater = player.isInWaterOrBubble();
        if (isNowInWater) {
            Vec3 movement = isSwimming ? player.getLookAngle().scale(0.03) : player.getKnownMovement().scale(0.15);
            player.addDeltaMovement(movement);
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0, false, false));
        } else {
            player.removeEffectNoUpdate(MobEffects.WATER_BREATHING);
        }

        if (!isNowInWater && !hasDashed) {
            double dashStrength = 0.75;
            Vec3 lookDirection = player.getLookAngle();
            Vec3 dashVelocity = lookDirection.scale(dashStrength).multiply(1.2, 1.2, 1.2);
            player.addDeltaMovement(dashVelocity);
            player.setForcedPose(Pose.FALL_FLYING);
            player.getDeltaMovement().multiply(0.5, 0.5, 0.5);
            data.putBoolean("hasDashed", true);
        }

        if (hasDashed && isNowInWater) {
            data.putBoolean("hasDashed", false);
        } else if (hasDashed && player.onGround())
            player.setForcedPose(null);

        ICurioItem.super.curioTick(slotContext, stack);
    }
}