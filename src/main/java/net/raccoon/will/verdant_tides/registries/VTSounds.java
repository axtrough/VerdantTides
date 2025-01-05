package net.raccoon.will.verdant_tides.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.verdant_tides.VerdantTides;

public class VTSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, VerdantTides.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> BRACELET_EQUIP = registerSoundEvents("bracelet_equip");


    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () ->
                SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(VerdantTides.MODID, name)));
    }

    public static void register(IEventBus eventBus) {SOUND_EVENTS.register(eventBus);
    }
}
