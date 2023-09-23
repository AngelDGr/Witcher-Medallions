package witchermedallions.items.gecko.models.heads;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import witchermedallions.items.gecko.item.heads.GriffinHeadItem;
import witchermedallions.witcherMod;

public class GriffinHeadModel extends AnimatedGeoModel<GriffinHeadItem> {

    @Override
    public Identifier getModelResource(GriffinHeadItem object) {
        return new Identifier(witcherMod.MODID, "geo/griffin_head_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(GriffinHeadItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/griffin_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(GriffinHeadItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
