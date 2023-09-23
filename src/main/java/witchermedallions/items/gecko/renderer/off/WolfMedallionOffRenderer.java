package witchermedallions.items.gecko.renderer.off;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import witchermedallions.items.gecko.item.off.WolfMedallionOffItem;
import witchermedallions.items.gecko.models.off.WolfMedallionOffModel;

public class WolfMedallionOffRenderer extends GeoItemRenderer<WolfMedallionOffItem> {
    public WolfMedallionOffRenderer() {super(new WolfMedallionOffModel()); }
}
