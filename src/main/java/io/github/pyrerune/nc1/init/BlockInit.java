package io.github.pyrerune.nc1.init;

import io.github.pyrerune.nc1.NorseMod;
import io.github.pyrerune.nc1.blocks.trees.NCSaplingBlock;
import io.github.pyrerune.nc1.blocks.trees.SoulWoodTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, NorseMod.MODID);
    public static final RegistryObject<Block> SOULWOOD_PLANKS = BLOCKS.register("soul_wood_planks", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(20.0F, 1200.0F)));
    public static final RegistryObject<Block> SOULWOOD_LOG = BLOCKS.register("soul_wood_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(60.0F, 1200.0F).harvestLevel(3).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> SOULWOOD_LEAVES = BLOCKS.register("soul_wood_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> SOULWOOD_SAPLING = BLOCKS.register("soul_wood_sapling", () -> new NCSaplingBlock(() -> new SoulWoodTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
}
