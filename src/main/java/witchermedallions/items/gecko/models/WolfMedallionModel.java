package witchermedallions.items.gecko.models;

import witchermedallions.witcherMod;
import witchermedallions.items.gecko.item.WolfMedallionItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class WolfMedallionModel extends GeoModel<WolfMedallionItem> {

    @Override
    public Identifier getModelResource(WolfMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "geo/wolf_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "textures/item/wolf_medallion.png");
    }

     @Override
    public Identifier getAnimationResource(WolfMedallionItem animatable) {
        
        return new Identifier(witcherMod.MODID, "animations/medallion_animation.animation.json");
    }

}