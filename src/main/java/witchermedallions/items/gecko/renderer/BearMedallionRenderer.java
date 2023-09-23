package witchermedallions.items.gecko.renderer;

import witchermedallions.items.gecko.item.BearMedallionItem;
import witchermedallions.items.gecko.models.BearMedallionModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class BearMedallionRenderer extends GeoItemRenderer<BearMedallionItem> {
    	
		public BearMedallionRenderer() {
    		super(new BearMedallionModel());
    	}
		
}