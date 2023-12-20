package witchermedallions.items.gecko.models.off;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import witchermedallions.items.gecko.item.off.BearMedallionOffItem;
import witchermedallions.witcherMod;

public class BearMedallionOffModel extends GeoModel<BearMedallionOffItem> {

    @Override
    public Identifier getModelResource(BearMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "geo/bear_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(BearMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/bear_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(BearMedallionOffItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
