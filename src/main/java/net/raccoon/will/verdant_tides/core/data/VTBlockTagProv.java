package net.raccoon.will.verdant_tides.core.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.raccoon.will.verdant_tides.VerdantTides;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class VTBlockTagProv extends BlockTagsProvider {
    public VTBlockTagProv(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VerdantTides.MODID, existingFileHelper);
    }

    //SPACING

    @Override
    protected void addTags(HolderLookup.Provider provider) { //BlockTags



    }
}
