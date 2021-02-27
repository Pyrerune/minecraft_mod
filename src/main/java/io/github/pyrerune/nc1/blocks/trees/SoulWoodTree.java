package io.github.pyrerune.nc1.blocks.trees;

import com.mojang.datafixers.Dynamic;
import io.github.pyrerune.nc1.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.BigTree;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;
import sun.security.krb5.Config;

import javax.annotation.Nullable;
import java.util.Random;

public class SoulWoodTree extends Tree {


    public static final TreeFeatureConfig SOULWOOD_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.SOULWOOD_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.SOULWOOD_LEAVES.get().getDefaultState()),
    new BlobFoliagePlacer(3,0))).baseHeight(10).heightRandA(3).foliageHeight(3).ignoreVines().setSapling((IPlantable) BlockInit.SOULWOOD_SAPLING.get()).build();


    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(SOULWOOD_CONFIG);
    }

}
