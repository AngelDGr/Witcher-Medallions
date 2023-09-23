package witchermedallions.items.gecko.models;

import witchermedallions.witcherMod;
import witchermedallions.items.gecko.item.BearMedallionItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BearMedallionModel extends AnimatedGeoModel<BearMedallionItem>{

    @Override
    public Identifier getModelResource(BearMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "geo/bear_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(BearMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "textures/item/bear_medallion.png");
    }

    @Override
    public Identifier getAnimationResource(BearMedallionItem animatable) {
        
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }


}
