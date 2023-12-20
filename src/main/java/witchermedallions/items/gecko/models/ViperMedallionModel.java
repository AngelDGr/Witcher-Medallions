package witchermedallions.items.gecko.models;

import witchermedallions.witcherMod;
import witchermedallions.items.gecko.item.ViperMedallionItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;


public class ViperMedallionModel extends GeoModel<ViperMedallionItem> {
 
    @Override
    public Identifier getModelResource(ViperMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "geo/viper_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(ViperMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "textures/item/viper_medallion.png");
    }

     @Override
    public Identifier getAnimationResource(ViperMedallionItem animatable) {
        
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }


}