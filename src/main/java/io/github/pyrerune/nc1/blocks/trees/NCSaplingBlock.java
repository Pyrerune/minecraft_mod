package io.github.pyrerune.nc1.blocks.trees;

import io.github.pyrerune.nc1.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.Random;
import java.util.function.Supplier;

public class NCSaplingBlock extends BushBlock implements IGrowable {
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0d, 0.0d, 2.0d, 14.0d, 12.0d, 14.0d);
    private final Supplier<Tree> tree;
    public NCSaplingBlock(Supplier<Tree> treeIn, Properties properties) {
        super(properties);
        this.tree = treeIn;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos blockPos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        super.tick(state, world, pos, rand);
        if (!world.isAreaLoaded(pos, 1)) {
            return;
        }
        if (world.getLight(pos.up()) >= 9 && rand.nextInt(7) == 0) {
            this.grow(world, pos, state, rand);
        }
    }


    public void grow(ServerWorld worldIn, BlockPos pos, BlockState state, Random rand) {
        if (state.get(STAGE) == 0) {
            worldIn.setBlockState(pos, state.cycle(STAGE), 4);
        } else {
            if (ForgeEventFactory.saplingGrowTree(worldIn, rand, pos)) return;
            this.tree.get().place(worldIn, worldIn.getChunkProvider().getChunkGenerator(), pos, state, rand);
        }
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double)worldIn.rand.nextFloat() < 0.45d;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.grow(worldIn, pos, state, rand);
    }
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == BlockInit.CURSED_GRASS.get() || block == BlockInit.CURSED_DIRT.get();
    }
}