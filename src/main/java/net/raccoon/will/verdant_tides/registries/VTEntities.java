package net.raccoon.will.verdant_tides.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.verdant_tides.VerdantTides;


public class VTEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, VerdantTides.MODID);




    public static void register(IEventBus eventBus) {ENTITY_TYPES.register(eventBus);
    }
}


