package witchermedallions.items.gecko.renderer.heads;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import witchermedallions.items.gecko.item.heads.CatHeadItem;
import witchermedallions.items.gecko.models.heads.CatHeadModel;

public class CatHeadRenderer extends GeoItemRenderer<CatHeadItem> {
    public CatHeadRenderer() {super(new CatHeadModel()); }
}
