package io.github.pyrerune.nc1.models;

import com.google.common.collect.ImmutableList;
import io.github.pyrerune.nc1.entities.NCEntity;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.ModelRenderer;

public class NCEntityModel extends SegmentedModel<NCEntity> {

    private final ModelRenderer body;

    public NCEntityModel() {
        this.body = new ModelRenderer(this, 0, 0);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.body);
    }

    @Override
    public void setRotationAngles(NCEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
}
