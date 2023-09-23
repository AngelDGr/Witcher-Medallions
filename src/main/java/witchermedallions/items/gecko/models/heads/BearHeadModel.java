package witchermedallions.items.gecko.models.heads;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import witchermedallions.items.gecko.item.heads.BearHeadItem;
import witchermedallions.witcherMod;

public class BearHeadModel extends AnimatedGeoModel<BearHeadItem> {

    @Override
    public Identifier getModelResource(BearHeadItem object) {
        return new Identifier(witcherMod.MODID, "geo/bear_head_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(BearHeadItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/bear_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(BearHeadItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
