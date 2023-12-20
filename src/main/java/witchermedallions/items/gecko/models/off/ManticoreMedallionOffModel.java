package witchermedallions.items.gecko.models.off;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import witchermedallions.items.gecko.item.off.ManticoreMedallionOffItem;
import witchermedallions.witcherMod;

public class ManticoreMedallionOffModel extends GeoModel<ManticoreMedallionOffItem> {

    @Override
    public Identifier getModelResource(ManticoreMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "geo/manticore_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(ManticoreMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/manticore_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(ManticoreMedallionOffItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
