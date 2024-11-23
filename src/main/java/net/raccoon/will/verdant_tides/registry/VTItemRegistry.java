package net.raccoon.will.verdant_tides.registry;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.verdant_tides.VerdantTides;
import static net.minecraft.world.item.Tiers.DIAMOND;


public class VTItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VerdantTides.MODID);


        public static final DeferredItem<SwordItem> SWORD_OF_HALDOR = ITEMS.register("sword_of_haldor",
                () -> new SwordItem(DIAMOND, new Item.Properties()
                        .attributes(SwordItem.createAttributes(DIAMOND, 7, -3f))
                        .stacksTo(1)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
