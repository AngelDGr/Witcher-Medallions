package witcher_medallions.items.medallions;

import net.minecraft.ChatFormatting;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;

/**
 Needs to be a different class, otherwise the SingletonGeoAnimatable.registerSyncedAnimatable() doesn't work
 */
public class GriffinMedallionItem extends ActivatedMedallionBaseItem{
    public GriffinMedallionItem() {
        super(new Properties().stacksTo(1), "griffin", ChatFormatting.YELLOW);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }
}
