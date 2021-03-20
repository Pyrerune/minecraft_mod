package io.github.pyrerune.nc1.entities;

import io.github.pyrerune.nc1.init.EntityInit;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class NCEntity extends AnimalEntity {
    public NCEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        NCEntity entity = new NCEntity(EntityInit.NC_ENTITY.get(), this.world);
        entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING,
                (ILivingEntityData) null, (CompoundNBT) null);
        entity.setGlowing(true);
        return entity;
    }

}
