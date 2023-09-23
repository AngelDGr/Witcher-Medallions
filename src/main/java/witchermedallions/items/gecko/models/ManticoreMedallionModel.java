package witchermedallions.items.gecko.models;

import witchermedallions.witcherMod;
import witchermedallions.items.gecko.item.ManticoreMedallionItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;


public class ManticoreMedallionModel extends AnimatedGeoModel<ManticoreMedallionItem> {
 
    @Override
    public Identifier getModelResource(ManticoreMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "geo/manticore_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(ManticoreMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "textures/item/manticore_medallion.png");
    }

     @Override
    public Identifier getAnimationResource(ManticoreMedallionItem animatable) {
        
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }


}
