package witchermedallions.items.gecko.renderer.heads;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import witchermedallions.items.gecko.item.heads.GriffinHeadItem;
import witchermedallions.items.gecko.models.heads.GriffinHeadModel;

public class GriffinHeadRenderer extends GeoItemRenderer<GriffinHeadItem> {
    public GriffinHeadRenderer() {super(new GriffinHeadModel()); }
}
