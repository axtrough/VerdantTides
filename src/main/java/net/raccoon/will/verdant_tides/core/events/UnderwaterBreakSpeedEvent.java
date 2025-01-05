package net.raccoon.will.verdant_tides.core.events;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.raccoon.will.verdant_tides.VerdantTides;
import net.raccoon.will.verdant_tides.registries.VTItems;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.List;


@EventBusSubscriber(modid = VerdantTides.MODID, value = Dist.CLIENT)
public class UnderwaterBreakSpeedEvent {

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        Item itemToCheck = VTItems.AQUA_BRACELET.get();

        if (player.isUnderWater() && isWearingCurio(player, itemToCheck)) {
            float originalSpeed = event.getOriginalSpeed();
            event.setNewSpeed(originalSpeed * 5);
        }
    }

    private static void checkCurioItem(Player player, Item item) {
        List<SlotResult> results = CuriosApi.getCuriosHelper().findCurios(player, VTItems.AQUA_BRACELET.get());
    }

    private static boolean isWearingCurio(Player player, Item item) {
        List<SlotResult> results = CuriosApi.getCuriosHelper().findCurios(player, item);
        return !results.isEmpty();
    }
}
