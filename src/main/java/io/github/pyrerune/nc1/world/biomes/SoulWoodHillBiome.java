package io.github.pyrerune.nc1.world.biomes;

import io.github.pyrerune.nc1.blocks.trees.SoulWoodTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class SoulWoodHillBiome extends Biome {

    public SoulWoodHillBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(SoulWoodTree.SOULWOOD_CONFIG).withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(0.01f, 0, 0, 1))));

    }

}
