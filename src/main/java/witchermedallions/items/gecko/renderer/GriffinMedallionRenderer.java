package witchermedallions.items.gecko.renderer;

import witchermedallions.items.gecko.item.GriffinMedallionItem;
import witchermedallions.items.gecko.models.GriffinMedallionModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GriffinMedallionRenderer extends GeoItemRenderer<GriffinMedallionItem> {
    	
		public GriffinMedallionRenderer() {
    		super(new GriffinMedallionModel());
    	}
		
}