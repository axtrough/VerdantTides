package net.raccoon.will.verdant_tides.core.misc;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.verdant_tides.VerdantTides;
import net.raccoon.will.verdant_tides.registries.VTItems;

import java.util.function.Supplier;

public class VTCreativeTab {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VerdantTides.MODID);

    public static final Supplier<CreativeModeTab> VERDANT_TIDES_TAB = CREATIVE_MODE_TAB.register("verdanttides_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(VTItems.LITTLEFRIEND.get()))
                    .title(Component.translatable("creativetab.verdanttides.verdanttides_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(VTItems.AQUA_BRACELET);
                        output.accept(VTItems.LITTLEFRIEND);




                    }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
