package fabric.witcher_medallions.items.medallions;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import fabric.witcher_medallions.items.ActivatedMedallionBaseItem;

/**
 Needs to be a different class, otherwise the SingletonGeoAnimatable.registerSyncedAnimatable() doesn't work
 */
public class CatMedallionItem extends ActivatedMedallionBaseItem {
    public CatMedallionItem() {
        super(new Item.Properties().stacksTo(1), "cat", ChatFormatting.DARK_AQUA);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }
}
