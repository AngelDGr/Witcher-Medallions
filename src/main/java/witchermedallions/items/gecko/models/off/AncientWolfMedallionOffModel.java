package witchermedallions.items.gecko.models.off;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import witchermedallions.items.gecko.item.off.AncientWolfMedallionOffItem;
import witchermedallions.witcherMod;

public class AncientWolfMedallionOffModel extends GeoModel<AncientWolfMedallionOffItem> {

    @Override
    public Identifier getModelResource(AncientWolfMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "geo/ancient_wolf_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(AncientWolfMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/ancient_wolf_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(AncientWolfMedallionOffItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
