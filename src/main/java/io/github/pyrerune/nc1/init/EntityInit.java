package io.github.pyrerune.nc1.init;

import io.github.pyrerune.nc1.NorseMod;
import io.github.pyrerune.nc1.entities.NCEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, NorseMod.MODID);
    public static final RegistryObject<EntityType<NCEntity>> NC_ENTITY = ENTITY_TYPES.register("nc_entity",
            () -> EntityType.Builder.<NCEntity>create(NCEntity::new, EntityClassification.CREATURE).size(1f, 1f).build(new ResourceLocation(NorseMod.MODID, "nc_entity").toString()));
}
