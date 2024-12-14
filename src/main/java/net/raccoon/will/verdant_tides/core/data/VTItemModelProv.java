package net.raccoon.will.verdant_tides.core.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.raccoon.will.verdant_tides.VerdantTides;

public class VTItemModelProv extends ItemModelProvider {
    public VTItemModelProv(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VerdantTides.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() { //ItemModels

    }



    //SPACING

    public ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath(),
                ResourceLocation.fromNamespaceAndPath("verdanttides", "block/"));
    }

    public ItemModelBuilder complexItem(Item item) {
        return withExistingParent(BuiltInRegistries.ITEM.getKey(item).getPath(),
                ResourceLocation.fromNamespaceAndPath("verdanttides", "block/"));
    }
}
