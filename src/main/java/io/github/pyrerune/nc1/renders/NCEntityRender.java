package io.github.pyrerune.nc1.renders;

import io.github.pyrerune.nc1.NorseMod;
import io.github.pyrerune.nc1.entities.NCEntity;
import io.github.pyrerune.nc1.models.NCEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.util.ResourceLocation;

public class NCEntityRender extends MobRenderer<NCEntity, NCEntityModel> {
    //TODO create texture
    protected static final ResourceLocation TEXTURE = new ResourceLocation(NorseMod.MODID, "textures/entity/nc_entity.png");
    public NCEntityRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new NCEntityModel(), 1f);
    }
    @Override
    public ResourceLocation getEntityTexture(NCEntity entity) {
        return TEXTURE;
    }
}
