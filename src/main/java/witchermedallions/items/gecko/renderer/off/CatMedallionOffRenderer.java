package witchermedallions.items.gecko.renderer.off;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import witchermedallions.items.gecko.item.off.CatMedallionOffItem;
import witchermedallions.items.gecko.models.off.CatMedallionOffModel;

public class CatMedallionOffRenderer extends GeoItemRenderer<CatMedallionOffItem> {
    public CatMedallionOffRenderer() {super(new CatMedallionOffModel()); }
}
