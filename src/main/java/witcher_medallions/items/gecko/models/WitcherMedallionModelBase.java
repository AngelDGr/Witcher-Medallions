package witcher_medallions.items.gecko.models;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.items.MedallionBaseItem;

public class WitcherMedallionModelBase extends GeoModel<MedallionBaseItem> {
    private final boolean isOff;
    private final String type;
    public WitcherMedallionModelBase(boolean isOff, String type) {
        this.isOff = isOff;
        this.type=type;
    }

    public Identifier getTexture_ON(){
        return Identifier.of(WitcherMedallions_Main.MOD_ID, "textures/item/"+getType()+"/"+getType()+"_medallion.png");
    }
    public Identifier getNeckTexture_ON(){
        return Identifier.of(WitcherMedallions_Main.MOD_ID, "textures/item/"+getType()+"/"+getType()+"_medallion_neck.png");
    }

    public Identifier getTexture_OFF(){
        return Identifier.of(WitcherMedallions_Main.MOD_ID, "textures/item/"+getType()+"/"+getType()+"_off_medallion.png");
    }
    public Identifier getNeckTexture_OFF(){
        return Identifier.of(WitcherMedallions_Main.MOD_ID, "textures/item/"+getType()+"/"+getType()+"_off_medallion_neck.png");
    }

    public String getType(){
        return this.type;
    }

    @Override
    public final Identifier getTextureResource(MedallionBaseItem animatable) {
        return isOff? getTexture_OFF(): getTexture_ON();
    }

    @Override
    public Identifier getModelResource(MedallionBaseItem object) {
        return Identifier.of(WitcherMedallions_Main.MOD_ID, "geo/"+getType()+"_medallion.geo.json");
    }

    @Override
    public Identifier getAnimationResource(MedallionBaseItem animatable) {
        return Identifier.of(WitcherMedallions_Main.MOD_ID, "animations/medallion_animation.animation.json");
    }
}
