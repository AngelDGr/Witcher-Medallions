package witchermedallions.items.gecko.models.off;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import witchermedallions.items.gecko.item.off.GriffinMedallionOffItem;
import witchermedallions.witcherMod;

public class GriffinMedallionOffModel extends AnimatedGeoModel<GriffinMedallionOffItem> {

    @Override
    public Identifier getModelResource(GriffinMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "geo/griffin_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(GriffinMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/griffin_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(GriffinMedallionOffItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
