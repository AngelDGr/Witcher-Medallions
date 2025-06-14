package neoforge.witcher_medallions.items.medallions;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import neoforge.witcher_medallions.items.ActivatedMedallionBaseItem;

/**
 Needs to be a different class, otherwise the SingletonGeoAnimatable.registerSyncedAnimatable() doesn't work
 */
public class WolfMedallionItem extends ActivatedMedallionBaseItem {
    public WolfMedallionItem() {
        super(new Item.Properties().stacksTo(1), "wolf", ChatFormatting.DARK_RED);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }
}
