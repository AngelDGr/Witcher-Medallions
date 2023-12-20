package witchermedallions.items.gecko.models.off;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import witchermedallions.items.gecko.item.off.ViperMedallionOffItem;
import witchermedallions.witcherMod;

public class ViperMedallionOffModel extends GeoModel<ViperMedallionOffItem> {

    @Override
    public Identifier getModelResource(ViperMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "geo/viper_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(ViperMedallionOffItem object) {
        return new Identifier(witcherMod.MODID, "textures/item/viper_off_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(ViperMedallionOffItem animatable) {
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }
}
