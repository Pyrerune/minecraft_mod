package io.github.pyrerune.nc1.init;

import io.github.pyrerune.nc1.NorseMod;
import io.github.pyrerune.nc1.blocks.CursedGrassBlock;
import io.github.pyrerune.nc1.blocks.trees.NCSaplingBlock;
import io.github.pyrerune.nc1.blocks.trees.IronWoodTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, NorseMod.MODID);
    public static final RegistryObject<Block> CURSED_GRASS = BLOCKS.register("cursed_grass", CursedGrassBlock::new);
    public static final RegistryObject<Block> CURSED_DIRT = BLOCKS.register("cursed_dirt", () -> new Block(Block.Properties.create(Material.ORGANIC, MaterialColor.DIRT).hardnessAndResistance(2.0F, 1200.0F)));
    public static final RegistryObject<Block> IRON_WOOD_PLANKS = BLOCKS.register("iron_wood_planks", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(20.0F, 1200.0F)));
    public static final RegistryObject<Block> IRON_WOOD_LOG = BLOCKS.register("iron_wood_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(60.0F, 1200.0F).harvestLevel(3).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> IRON_WOOD_LEAVES = BLOCKS.register("iron_wood_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> IRON_WOOD_SAPLING = BLOCKS.register("iron_wood_sapling", () -> new NCSaplingBlock(IronWoodTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
}
