package witcher_medallions.items.medallions;

import net.minecraft.ChatFormatting;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import witcher_medallions.items.ActivatedMedallionBaseItem;

/**
 Needs to be a different class, otherwise the SingletonGeoAnimatable.registerSyncedAnimatable() doesn't work
 */
public class AncientWolfMedallionItem extends ActivatedMedallionBaseItem {
    public AncientWolfMedallionItem() {
        super(new Properties().stacksTo(1), "ancient_wolf", ChatFormatting.DARK_GRAY);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }
}
