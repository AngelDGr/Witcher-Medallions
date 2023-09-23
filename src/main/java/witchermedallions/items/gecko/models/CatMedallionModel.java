package witchermedallions.items.gecko.models;

import witchermedallions.witcherMod;
import witchermedallions.items.gecko.item.CatMedallionItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;


public class CatMedallionModel extends AnimatedGeoModel<CatMedallionItem> {
 
    @Override
    public Identifier getModelResource(CatMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "geo/cat_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(CatMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "textures/item/cat_medallion.png");
    }

     @Override
    public Identifier getAnimationResource(CatMedallionItem animatable) {
        
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }


}
