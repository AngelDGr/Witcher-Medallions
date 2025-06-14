package fabric.witcher_medallions.items.medallions;

import net.minecraft.ChatFormatting;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import fabric.witcher_medallions.items.ActivatedMedallionBaseItem;

/**
 Needs to be a different class, otherwise the SingletonGeoAnimatable.registerSyncedAnimatable() doesn't work
 */
public class ViperMedallionItem extends ActivatedMedallionBaseItem {
    public ViperMedallionItem() {
        super(new Properties().stacksTo(1), "viper", ChatFormatting.GREEN);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }
}
