package net.raccoon.will.verdant_tides.registries;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.verdant_tides.VerdantTides;
import net.raccoon.will.verdant_tides.common.item.AquaBracelet;
import net.raccoon.will.verdant_tides.common.item.ItemLittleFriend;

import static net.minecraft.world.item.Tiers.DIAMOND;


public class VTItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VerdantTides.MODID);

    public static final DeferredItem<SwordItem> LITTLEFRIEND = ITEMS.register("littlefriend",
                () -> new ItemLittleFriend(DIAMOND, new Item.Properties().attributes(SwordItem.createAttributes(DIAMOND, 6, -3f)).stacksTo(1)));


    public static final DeferredItem<Item> AQUA_BRACELET = ITEMS.register("aqua_bracelet", () -> new AquaBracelet(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
