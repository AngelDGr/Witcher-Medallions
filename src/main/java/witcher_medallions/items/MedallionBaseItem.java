package witcher_medallions.items;

import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import software.bernie.geckolib.animatable.GeoItem;

public abstract class MedallionBaseItem extends TrinketItem implements GeoItem, TrinketRenderer {
    public MedallionBaseItem(Settings settings) {
        super(settings);
    }
}
