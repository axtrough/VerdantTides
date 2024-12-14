package net.raccoon.will.verdant_tides.core.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.raccoon.will.verdant_tides.VerdantTides;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class VTItemTagProv extends ItemTagsProvider {

    public VTItemTagProv(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                      CompletableFuture<TagLookup<Item>> parentProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, parentProvider, blockTags, VerdantTides.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) { //ItemTags



    }
}

