package witchermedallions.items.gecko.models.off;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import witchermedallions.items.gecko.item.off.WolfMedallionOffItem;
import witchermedallions.witcherMod;

public class WolfMedallionOffModel extends GeoModel<WolfMedallionOffItem> {

    @Override
    public Identifier getModelResource(WolfMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "geo/wolf_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/wolf_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(WolfMedallionOffItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
