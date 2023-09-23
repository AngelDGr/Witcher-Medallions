package witchermedallions.items.gecko.renderer;

import witchermedallions.items.gecko.item.ViperMedallionItem;
import witchermedallions.items.gecko.models.ViperMedallionModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class ViperMedallionRenderer extends GeoItemRenderer<ViperMedallionItem> {
    	
		public ViperMedallionRenderer() {
    		super(new ViperMedallionModel());
    	}
		
}