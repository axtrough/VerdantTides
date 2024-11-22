package net.raccoon.will.verdant_tides.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.verdant_tides.VerdantTides;

public class VTItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VerdantTides.MODID);






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
