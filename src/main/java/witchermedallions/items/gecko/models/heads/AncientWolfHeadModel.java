package witchermedallions.items.gecko.models.heads;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import witchermedallions.items.gecko.item.heads.AncientWolfHeadItem;
import witchermedallions.witcherMod;

public class AncientWolfHeadModel extends AnimatedGeoModel<AncientWolfHeadItem> {

    @Override
    public Identifier getModelResource(AncientWolfHeadItem object) {
        return new Identifier(witcherMod.MODID, "geo/ancient_wolf_coin_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(AncientWolfHeadItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/ancient_wolf_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(AncientWolfHeadItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
