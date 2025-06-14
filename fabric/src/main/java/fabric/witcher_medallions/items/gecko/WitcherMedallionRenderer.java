package fabric.witcher_medallions.items.gecko;

import fabric.witcher_medallions.items.MedallionBaseItem_Fabric;
import witcher_medallions.items.gecko.WitcherMedallionRendererCommon;

public class WitcherMedallionRenderer extends WitcherMedallionRendererCommon<MedallionBaseItem_Fabric> {
    public WitcherMedallionRenderer(String type, boolean isOff) {
        super(isOff,new WitcherMedallionModelBase(isOff, type));
    }
}
