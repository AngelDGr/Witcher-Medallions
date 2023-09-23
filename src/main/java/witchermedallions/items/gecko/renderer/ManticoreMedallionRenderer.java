package witchermedallions.items.gecko.renderer;

import witchermedallions.items.gecko.item.ManticoreMedallionItem;
import witchermedallions.items.gecko.models.ManticoreMedallionModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class ManticoreMedallionRenderer extends GeoItemRenderer<ManticoreMedallionItem> {
    	
		public ManticoreMedallionRenderer() {
    		super(new ManticoreMedallionModel());
    	}
		
}