package witchermedallions.items.gecko.renderer.heads;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import witchermedallions.items.gecko.item.heads.BearHeadItem;
import witchermedallions.items.gecko.models.heads.BearHeadModel;

public class BearHeadRenderer extends GeoItemRenderer<BearHeadItem> {
    public BearHeadRenderer() {super(new BearHeadModel()); }
}
