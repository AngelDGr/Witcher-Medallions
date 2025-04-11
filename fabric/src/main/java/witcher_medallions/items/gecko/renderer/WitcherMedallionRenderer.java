package witcher_medallions.items.gecko.renderer;

import witcher_medallions.items.MedallionBaseItem_Fabric;
import witcher_medallions.items.gecko.WitcherMedallionRendererCommon;
import witcher_medallions.items.gecko.models.WitcherMedallionModelBase;

public class WitcherMedallionRenderer extends WitcherMedallionRendererCommon<MedallionBaseItem_Fabric> {
    public WitcherMedallionRenderer(String type, boolean isOff) {
        super(isOff,new WitcherMedallionModelBase(isOff, type));
    }
}
