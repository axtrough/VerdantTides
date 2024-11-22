package net.raccoon.will.verdant_tides.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.verdant_tides.VerdantTides;

public class VTBlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VerdantTides.MODID);






    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
