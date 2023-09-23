package witchermedallions.items.gecko.models.heads;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import witchermedallions.items.gecko.item.heads.ManticoreHeadItem;
import witchermedallions.witcherMod;

public class ManticoreHeadModel extends AnimatedGeoModel<ManticoreHeadItem> {

    @Override
    public Identifier getModelResource(ManticoreHeadItem object) {
        return new Identifier(witcherMod.MODID, "geo/manticore_head_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(ManticoreHeadItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/manticore_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(ManticoreHeadItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
