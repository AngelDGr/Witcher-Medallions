package fabric.witcher_medallions.items.medallions;

import net.minecraft.ChatFormatting;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import fabric.witcher_medallions.items.ActivatedMedallionBaseItem;

/**
 Needs to be a different class, otherwise the SingletonGeoAnimatable.registerSyncedAnimatable() doesn't work
 */
public class BearMedallionItem extends ActivatedMedallionBaseItem {
    public BearMedallionItem() {
        super(new Properties().stacksTo(1), "bear", ChatFormatting.DARK_GREEN);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }
}
