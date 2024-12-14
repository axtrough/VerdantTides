package net.raccoon.will.verdant_tides.core.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.raccoon.will.verdant_tides.VerdantTides;

public class VTBlockStateProv extends BlockStateProvider {
    public VTBlockStateProv(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VerdantTides.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() { //BlockStates


    }

    //SPACING

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
