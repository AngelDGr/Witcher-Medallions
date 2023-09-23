package witchermedallions.items.gecko.models;

import witchermedallions.witcherMod;
import witchermedallions.items.gecko.item.GriffinMedallionItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;


public class GriffinMedallionModel extends AnimatedGeoModel<GriffinMedallionItem> {
 
    @Override
    public Identifier getModelResource(GriffinMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "geo/griffin_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(GriffinMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "textures/item/griffin_medallion.png");
    }

     @Override
    public Identifier getAnimationResource(GriffinMedallionItem animatable) {
        
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }


}