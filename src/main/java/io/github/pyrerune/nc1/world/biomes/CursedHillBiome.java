package io.github.pyrerune.nc1.world.biomes;

import io.github.pyrerune.nc1.blocks.trees.IronWoodTree;
import io.github.pyrerune.nc1.init.FeatureInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;

public class CursedHillBiome extends Biome {

    public CursedHillBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FeatureInit.IRON_WOOD_TREE_FEATURE.withConfiguration(IronWoodTree.IRON_WOOD_CONFIG));
    }

}
