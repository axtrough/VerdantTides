package net.raccoon.will.verdant_tides;


import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.raccoon.will.verdant_tides.client.CuriosLayerDefinitions;
import net.raccoon.will.verdant_tides.client.model.AquaBraceletModel;
import net.raccoon.will.verdant_tides.client.renderer.AquaBraceletRenderer;
import net.raccoon.will.verdant_tides.core.misc.VTCreativeTab;
import net.raccoon.will.verdant_tides.registries.VTBlockRegistry;
import net.raccoon.will.verdant_tides.registries.VTItemRegistry;
import net.raccoon.will.verdant_tides.registries.VTSounds;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod(VerdantTides.MODID)
public class VerdantTides {
    public static final String MODID = "verdanttides";
    private static final Logger LOGGER = LogUtils.getLogger();


    public VerdantTides(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::setup);

        NeoForge.EVENT_BUS.register(this);

        VTSounds.register(modEventBus);
        VTCreativeTab.register(modEventBus);
        VTItemRegistry.register(modEventBus);
        VTBlockRegistry.register(modEventBus);


        modEventBus.addListener(this::addCreative);
    }

    public void setup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            CuriosRendererRegistry.register((VTItemRegistry.AQUA_BRACELET.get()), AquaBraceletRenderer::new);

        }

        @SubscribeEvent
        private static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(CuriosLayerDefinitions.AQUA_BRACELET, AquaBraceletModel::createLayer);

        }
    }
}
