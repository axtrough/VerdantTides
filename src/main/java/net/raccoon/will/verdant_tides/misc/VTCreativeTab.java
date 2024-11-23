package net.raccoon.will.verdant_tides.misc;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.verdant_tides.VerdantTides;
import net.raccoon.will.verdant_tides.registry.VTItemRegistry;

import java.util.function.Supplier;

public class VTCreativeTab {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VerdantTides.MODID);

    public static final Supplier<CreativeModeTab> VERDANT_TIDES_TAB = CREATIVE_MODE_TAB.register("verdanttides_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(VTItemRegistry.SWORD_OF_HALDOR.get()))
                    .title(Component.translatable("creativetab.verdanttides.verdanttides_tab"))
                    .displayItems((parameters, output) -> {

                        output.accept(VTItemRegistry.SWORD_OF_HALDOR);




                    }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
