package witchermedallions.items.gecko.models.off;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import witchermedallions.items.gecko.item.off.CatMedallionOffItem;
import witchermedallions.witcherMod;

public class CatMedallionOffModel extends GeoModel<CatMedallionOffItem> {

    @Override
    public Identifier getModelResource(CatMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "geo/cat_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(CatMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/cat_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(CatMedallionOffItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
