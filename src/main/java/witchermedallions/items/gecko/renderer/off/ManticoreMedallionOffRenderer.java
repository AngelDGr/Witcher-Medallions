package witchermedallions.items.gecko.renderer.off;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import witchermedallions.items.gecko.item.off.ManticoreMedallionOffItem;
import witchermedallions.items.gecko.models.off.ManticoreMedallionOffModel;

public class ManticoreMedallionOffRenderer extends GeoItemRenderer<ManticoreMedallionOffItem> {
    public ManticoreMedallionOffRenderer() {super(new ManticoreMedallionOffModel()); }
}
