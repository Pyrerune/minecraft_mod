package io.github.pyrerune.nc1.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import io.github.pyrerune.nc1.blocks.CursedGrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class BaseTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {
    public BaseTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> p_i225796_1_) {
        super(p_i225796_1_);
    }

    @Override
    public boolean place(IWorldGenerationReader generationReader, Random rand, BlockPos positionIn, Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn, TreeFeatureConfig configIn) {

        BlockPos blockpos = new BlockPos(positionIn.getX(), generationReader.getHeight(Heightmap.Type.OCEAN_FLOOR, positionIn).getY(), positionIn.getZ());

        int i = configIn.baseHeight + rand.nextInt(configIn.heightRandA + 1) + rand.nextInt(configIn.heightRandB + 1);
        int j = configIn.trunkHeight >= 0 ? configIn.trunkHeight + rand.nextInt(configIn.trunkHeightRandom + 1) : i - (configIn.foliageHeight + rand.nextInt(configIn.foliageHeightRandom + 1));
        int k = configIn.foliagePlacer.func_225573_a_(rand, j, i, configIn);


            Optional<BlockPos> optional;

        if(blockpos.getY() < generationReader.getMaxHeight() - i - 1) {
            if(generationReader instanceof IBlockReader) {
                if (generationReader.hasBlockState(blockpos.down(), state -> state.getBlock() instanceof CursedGrassBlock)) {
                    optional = Optional.of(blockpos);
                } else {
                    optional = Optional.empty();
                }

            } else {
                optional = Optional.empty();

            }
        } else {
            optional = Optional.empty();
        }
        if (!optional.isPresent()) {
            return false;
        } else {
            BlockPos blockpos1 = optional.get();
            this.setDirtAt(generationReader, blockpos1.down(), blockpos1);
            configIn.foliagePlacer.func_225571_a_(generationReader, rand, configIn, i, j, k, blockpos1, p_225557_5_);
            this.func_227213_a_(generationReader, rand, i, blockpos1, configIn.trunkTopOffset + rand.nextInt(configIn.trunkTopOffsetRandom + 1), p_225557_4_, boundingBoxIn, configIn);
            return true;
        }
    }
}
