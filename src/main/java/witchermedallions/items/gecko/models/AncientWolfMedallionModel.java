package witchermedallions.items.gecko.models;

import witchermedallions.witcherMod;
import witchermedallions.items.gecko.item.AncientWolfMedallionItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AncientWolfMedallionModel extends AnimatedGeoModel<AncientWolfMedallionItem> {

    @Override
    public Identifier getModelResource(AncientWolfMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "geo/ancient_wolf_medallion.geo.json");
    }

    @Override
    public Identifier getTextureResource(AncientWolfMedallionItem object) {
        
        return new Identifier(witcherMod.MODID, "textures/item/ancient_wolf_medallion.png");
    }

     @Override
    public Identifier getAnimationResource(AncientWolfMedallionItem animatable) {
        
        return new Identifier(witcherMod.MODID, "animations/medallion_animation_ancientwolf.animation.json");
    }

}