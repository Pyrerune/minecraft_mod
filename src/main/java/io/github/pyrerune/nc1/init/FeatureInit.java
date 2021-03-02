package io.github.pyrerune.nc1.init;

import io.github.pyrerune.nc1.world.gen.feature.BaseTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class FeatureInit {
    public static final Feature<TreeFeatureConfig> IRON_WOOD_TREE_FEATURE = new BaseTreeFeature(TreeFeatureConfig::deserializeFoliage);

}
