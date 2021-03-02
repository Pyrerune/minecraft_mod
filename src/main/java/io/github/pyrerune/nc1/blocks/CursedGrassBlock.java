package io.github.pyrerune.nc1.blocks;

import io.github.pyrerune.nc1.NorseMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.ResourceLocation;

public class CursedGrassBlock extends Block {

    public CursedGrassBlock() {
        super(Block.Properties.create(Material.ORGANIC, MaterialColor.DIRT).hardnessAndResistance(2.0F, 1200.0F));

    }

}
