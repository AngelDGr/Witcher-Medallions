package fabric.witcher_medallions.items;

import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.animatable.GeoItem;

public abstract class MedallionBaseItem_Fabric extends TrinketItem implements GeoItem, TrinketRenderer {
    public MedallionBaseItem_Fabric(Item.Properties settings) {
        super(settings);
    }
}
