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

import java.util.Objects;

public class AquaBracelet extends Item implements ICurioItem {
    private boolean jumping;

    public AquaBracelet(Properties properties) {
        super(new Properties().stacksTo(1));
    }

    public void travel(Vec3 travelVector, Player player) {
        if (player.isEffectiveAi() && player.isInWater()) {
            player.moveRelative(player.getSpeed(), travelVector);
            player.move(MoverType.SELF, player.getDeltaMovement());
            player.setDeltaMovement(player.getDeltaMovement().scale(0.9));

        }
    }


    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        Player player = (Player) slotContext.entity();
        Level level = player.level();

        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                VTSounds.BRACELET_EQUIP, SoundSource.PLAYERS,
                1.0F, 1.0F);
        //this actually made me so mad. dont know how but i somehow flew around and around on how to do this...
        // also it works perfectly as intended :333333
    }


    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        Player player = (Player) slotContext.entity();
        CompoundTag data = player.getPersistentData();
        double dashStrength = 0.32;
        boolean isNowInWater = player.isInWater();
        boolean hasDashed = data.getBoolean("HasDashed");
        boolean isInWater = player.isEyeInFluidType(Fluids.WATER.getFluidType());
        boolean hasAquaAbility = !Objects.equals(player.getEffect(MobEffects.WATER_BREATHING), null) &&
                !Objects.equals(player.getEffect(MobEffects.DOLPHINS_GRACE), null);

        if (!isInWater && isNowInWater && !hasDashed) {

            Vec3 lookDirection = player.getLookAngle();
            Vec3 dashVelocity = lookDirection.scale(dashStrength);
            dashVelocity = new Vec3(dashVelocity.x, dashVelocity.y, dashVelocity.z);
            player.addDeltaMovement(dashVelocity);
            data.putBoolean("HasDashed", true);
            //this is needs fixing because when you swim at the water surface, you get an extra speed boost.


            Vec3 currentVelocity = player.getDeltaMovement();
            double adjustedHorizontalSpeed = 1.5;
            player.setDeltaMovement(
                    currentVelocity.x * adjustedHorizontalSpeed,
                    currentVelocity.y * adjustedHorizontalSpeed,
                    currentVelocity.z * adjustedHorizontalSpeed);
        }
        if (isNowInWater && isInWater) {
            data.putBoolean("HasDashed", false);
        }


        if (!hasAquaAbility && player.isInWater()) {
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 300, 0, false, false));


        } else if (!player.isInWater()) {
            player.removeEffect(MobEffects.WATER_BREATHING);
            player.removeEffect(MobEffects.DOLPHINS_GRACE);


            ICurioItem.super.curioTick(slotContext, stack);
        }
    }
}

























