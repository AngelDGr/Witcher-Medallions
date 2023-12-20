package witchermedallions.items.gecko.renderer;

import witchermedallions.items.gecko.item.WolfMedallionItem;
import witchermedallions.items.gecko.models.WolfMedallionModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class WolfMedallionRenderer extends GeoItemRenderer<WolfMedallionItem> {
    	
		public WolfMedallionRenderer() {
    		super(new WolfMedallionModel());
    	}
		
}