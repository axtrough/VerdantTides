package net.raccoon.will.verdant_tides.common.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.raccoon.will.verdant_tides.registries.VTSounds;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class AquaBracelet extends Item implements ICurioItem {
    public AquaBracelet(Properties properties) {
        super(new Properties().stacksTo(1));
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        Player player = (Player) slotContext.entity();
        Level level = player.level();
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                VTSounds.BRACELET_EQUIP, SoundSource.PLAYERS,
                1F, 1F);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
    Player player = (Player) slotContext.entity();
        CompoundTag data = player.getPersistentData();

        boolean hasDashed = data.getBoolean("HasDashed");
        boolean isNowInWater = player.isInWater();

        if (player.isSwimming() && isNowInWater) {
            Vec3 lookie = player.getLookAngle();
            Vec3 addSwimSpeed = lookie.scale(0.03);
            addSwimSpeed = new Vec3(addSwimSpeed.x, addSwimSpeed.y, addSwimSpeed.z);

            player.addDeltaMovement(addSwimSpeed);

        }
        else if (!isNowInWater && !hasDashed) {
            double dashStrength = 0.75;
            Vec3 lookDirection = player.getLookAngle();
            Vec3 dashVelocity = lookDirection.scale(dashStrength);
            dashVelocity = new Vec3(dashVelocity.x * 1.1, dashVelocity.y, dashVelocity.z * 1.1);

            player.addDeltaMovement(dashVelocity);
            data.putBoolean("HasDashed", true);

        }

        if (isNowInWater) {
            data.putBoolean("HasDashed", false);
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0, false, false));
        }
        else {
            player.removeEffectNoUpdate(MobEffects.WATER_BREATHING);
            ICurioItem.super.curioTick(slotContext, stack);
        }
    }
}


























