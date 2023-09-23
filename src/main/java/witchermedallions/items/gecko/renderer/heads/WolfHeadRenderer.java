package witchermedallions.items.gecko.renderer.heads;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import witchermedallions.items.gecko.item.heads.WolfHeadItem;
import witchermedallions.items.gecko.models.heads.WolfHeadModel;

public class WolfHeadRenderer extends GeoItemRenderer<WolfHeadItem> {
    public WolfHeadRenderer() {super(new WolfHeadModel()); }
}
