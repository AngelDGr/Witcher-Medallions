package witchermedallions.items.gecko.renderer.off;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import witchermedallions.items.gecko.item.off.BearMedallionOffItem;
import witchermedallions.items.gecko.models.off.BearMedallionOffModel;

public class BearMedallionOffRenderer extends GeoItemRenderer<BearMedallionOffItem> {
    public BearMedallionOffRenderer() {super(new BearMedallionOffModel()); }
}
