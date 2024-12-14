package net.raccoon.will.verdant_tides.common.item;


import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.raccoon.will.verdant_tides.registries.VTSounds;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.Objects;

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
                1.0F, 1.0F);        //this actually made me so mad. dont know how but i somehow flew around and around on how to do this...
                                                    //also it works perfectly as intended :333333
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (!(slotContext.entity() instanceof Player player)) return;


        if (!player.level().isClientSide()) {
            boolean hasAquaAbility =
                    !Objects.equals(player.getEffect(MobEffects.WATER_BREATHING), null) &&
                            !Objects.equals(player.getEffect(MobEffects.DOLPHINS_GRACE), null);

            if (!hasAquaAbility && player.isInWater()) {
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 300, 0, false, false));

                if (!player.isInWater()) {
                    player.removeEffect(MobEffects.WATER_BREATHING);
                    player.removeEffect(MobEffects.DOLPHINS_GRACE);
                }
            }
        }


        ICurioItem.super.curioTick(slotContext, stack);

    }
}



