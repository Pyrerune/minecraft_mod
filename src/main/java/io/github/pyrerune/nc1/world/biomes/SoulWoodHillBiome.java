package io.github.pyrerune.nc1.world.biomes;

import io.github.pyrerune.nc1.blocks.trees.SoulWoodTree;
import io.github.pyrerune.nc1.init.BiomeInit;
import io.github.pyrerune.nc1.init.FeatureInit;
import io.github.pyrerune.nc1.world.gen.feature.BaseTreeFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class SoulWoodHillBiome extends Biome {

    public SoulWoodHillBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FeatureInit.SOUL_WOOD_TREE_FEATURE.withConfiguration(SoulWoodTree.SOULWOOD_CONFIG));
    }

}
