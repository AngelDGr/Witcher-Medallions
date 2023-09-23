package witchermedallions.items.gecko.renderer;

import witchermedallions.items.gecko.item.CatMedallionItem;
import witchermedallions.items.gecko.models.CatMedallionModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class CatMedallionRenderer extends GeoItemRenderer<CatMedallionItem>{
    
    	public CatMedallionRenderer() {
    		super(new CatMedallionModel());
    	}

}