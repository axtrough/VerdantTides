package net.raccoon.will.verdant_tides.common.item;



import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.raccoon.will.verdant_tides.registries.VTSounds;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;


public class AquaBracelet extends Item implements ICurioItem {
    private boolean jumping;

    public AquaBracelet(Properties properties) {
        super(new Properties().stacksTo(1));
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        Player player = (Player) slotContext.entity();
        Level level = player.level();

        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                VTSounds.BRACELET_EQUIP, SoundSource.PLAYERS,
                1F, 0.9F);
    }


    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
            Player player = (Player) slotContext.entity();
            CompoundTag data = player.getPersistentData();
            boolean hasDashed = data.getBoolean("HasDashed");

        boolean isNowInWater = player.isInWater();

        boolean isInWater = player.isEyeInFluidType(Fluids.WATER.getFluidType());

        if (player.isSwimming() && isInWater) {
            Vec3 lookie = player.getLookAngle();
            Vec3 addSwimSpeed = lookie.scale(0.03);
            addSwimSpeed = new Vec3(addSwimSpeed.x, addSwimSpeed.y, addSwimSpeed.z);
            player.addDeltaMovement(addSwimSpeed);


        } else if (!isInWater && !isNowInWater && !hasDashed) {
            double dashStrength = 0.32;
            Vec3 lookDirection = player.getLookAngle();
            Vec3 dashVelocity = lookDirection.scale(dashStrength);
            dashVelocity = new Vec3(dashVelocity.x, dashVelocity.y, dashVelocity.z);
            player.addDeltaMovement(dashVelocity);
            data.putBoolean("HasDashed", true);


            double adjustedHorizontalSpeed = 1.65;
            Vec3 currentVelocity = player.getDeltaMovement();
            player.setDeltaMovement(
                    currentVelocity.x * adjustedHorizontalSpeed,
                currentVelocity.y * adjustedHorizontalSpeed,
            currentVelocity.z * adjustedHorizontalSpeed);
        }
        if (isNowInWater && isInWater) {
            data.putBoolean("HasDashed", false);

        }

        if (player.isInWater()) {
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,
                    300, 0, false, false));

        } else if (!player.isInWater()) {
            player.removeEffect(MobEffects.WATER_BREATHING);

            ICurioItem.super.curioTick(slotContext, stack);
        }
    }
}
























