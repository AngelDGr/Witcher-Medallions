package witchermedallions.items.gecko.models.heads;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import witchermedallions.items.gecko.item.heads.WolfHeadItem;
import witchermedallions.witcherMod;

public class WolfHeadModel extends AnimatedGeoModel<WolfHeadItem> {

    @Override
    public Identifier getModelResource(WolfHeadItem object) {
        return new Identifier(witcherMod.MODID, "geo/wolf_head_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfHeadItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/wolf_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(WolfHeadItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
