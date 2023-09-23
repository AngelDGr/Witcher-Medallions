package witchermedallions.items.gecko.renderer;

import witchermedallions.items.gecko.item.WolfMedallionItem;
import witchermedallions.items.gecko.models.WolfMedallionModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class WolfMedallionRenderer extends GeoItemRenderer<WolfMedallionItem> {
    	
		public WolfMedallionRenderer() {
    		super(new WolfMedallionModel());
    	}
		
}