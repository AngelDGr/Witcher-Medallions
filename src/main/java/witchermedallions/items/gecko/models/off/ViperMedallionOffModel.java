package witchermedallions.items.gecko.models.off;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import witchermedallions.items.gecko.item.off.ViperMedallionOffItem;
import witchermedallions.items.gecko.item.off.WolfMedallionOffItem;
import witchermedallions.witcherMod;

public class ViperMedallionOffModel extends AnimatedGeoModel<ViperMedallionOffItem> {

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
