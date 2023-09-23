package witchermedallions.items.gecko.models.heads;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import witchermedallions.items.gecko.item.heads.CatHeadItem;
import witchermedallions.witcherMod;

public class CatHeadModel extends AnimatedGeoModel<CatHeadItem> {

    @Override
    public Identifier getModelResource(CatHeadItem object) {
        return new Identifier(witcherMod.MODID, "geo/cat_head_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(CatHeadItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/cat_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(CatHeadItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
