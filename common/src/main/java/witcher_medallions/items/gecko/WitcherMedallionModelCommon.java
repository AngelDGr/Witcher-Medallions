package witcher_medallions.items.gecko;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import witcher_medallions.WitcherMedallions_MainCommon;

public class WitcherMedallionModelCommon<T extends GeoAnimatable> extends GeoModel<T> {
    private final boolean isOff;
    private final String type;
    public WitcherMedallionModelCommon(boolean isOff, String type) {
        this.isOff = isOff;
        this.type=type;
    }
    public ResourceLocation getTexture_ON(){
        return ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "textures/item/"+getType()+"/"+getType()+"_medallion.png");
    }
    public ResourceLocation getNeckTexture_ON(){
        return ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "textures/item/"+getType()+"/"+getType()+"_medallion_neck.png");
    }

    public ResourceLocation getTexture_OFF(){
        return ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "textures/item/"+getType()+"/"+getType()+"_off_medallion.png");
    }
    public ResourceLocation getNeckTexture_OFF(){
        return ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "textures/item/"+getType()+"/"+getType()+"_off_medallion_neck.png");
    }

    public String getType(){
        return this.type;
    }

    @Override
    public final ResourceLocation getTextureResource(T animatable) {
        return isOff? getTexture_OFF(): getTexture_ON();
    }

    @Override
    public ResourceLocation getModelResource(T object) {
        return ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "geo/"+getType()+"_medallion.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "animations/medallion_animation.animation.json");
    }
}
