package witchermedallions.items.gecko.renderer.heads;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import witchermedallions.items.gecko.item.heads.ManticoreHeadItem;
import witchermedallions.items.gecko.models.heads.ManticoreHeadModel;

public class ManticoreHeadRenderer extends GeoItemRenderer<ManticoreHeadItem> {
    public ManticoreHeadRenderer() {super(new ManticoreHeadModel()); }
}
