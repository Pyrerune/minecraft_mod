package io.github.pyrerune.nc1.blocks.trees;

import io.github.pyrerune.nc1.init.BlockInit;
import io.github.pyrerune.nc1.init.FeatureInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

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
        return FeatureInit.SOUL_WOOD_TREE_FEATURE.withConfiguration(SoulWoodTree.SOULWOOD_CONFIG);
    }

}
