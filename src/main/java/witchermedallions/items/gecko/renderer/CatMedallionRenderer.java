package witchermedallions.items.gecko.renderer;

import witchermedallions.items.gecko.item.CatMedallionItem;
import witchermedallions.items.gecko.models.CatMedallionModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class CatMedallionRenderer extends GeoItemRenderer<CatMedallionItem>{
    
    	public CatMedallionRenderer() {
    		super(new CatMedallionModel());
    	}

}