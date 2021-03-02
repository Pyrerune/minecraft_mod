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

public class IronWoodTree extends Tree {


    public static final TreeFeatureConfig IRON_WOOD_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.IRON_WOOD_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.IRON_WOOD_LEAVES.get().getDefaultState()),
    new BlobFoliagePlacer(3,0))).baseHeight(10).heightRandA(3).foliageHeight(3).ignoreVines().setSapling((IPlantable) BlockInit.IRON_WOOD_SAPLING.get()).build();


    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return FeatureInit.IRON_WOOD_TREE_FEATURE.withConfiguration(IronWoodTree.IRON_WOOD_CONFIG);
    }

}
