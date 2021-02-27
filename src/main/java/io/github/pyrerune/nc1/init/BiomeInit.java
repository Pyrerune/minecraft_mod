package io.github.pyrerune.nc1.init;

import io.github.pyrerune.nc1.NorseMod;
import io.github.pyrerune.nc1.world.biomes.SoulWoodHillBiome;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, NorseMod.MODID);
    public static final RegistryObject<Biome> SOUL_WOOD_HILL = BIOMES.register("soul_wood_hill", () ->
            new SoulWoodHillBiome(new Biome.Builder().precipitation(Biome.RainType.NONE).scale(0.8F).temperature(0f)
                            .waterColor(13158600).waterFogColor(9803670).surfaceBuilder(SurfaceBuilder.DEFAULT,
                                    new SurfaceBuilderConfig(Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState(),
                                            Blocks.COARSE_DIRT.getDefaultState())).category(Biome.Category.PLAINS)
                            .downfall(0f).depth(0.13f).parent(null)));
    public static void registerBiomes() {
        registerBiome(SOUL_WOOD_HILL.get(), Type.PLAINS, Type.OVERWORLD);
    }
    private static void registerBiome(Biome biome, Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));

    }
}
