package witcher_medallions.items.gecko;

import witcher_medallions.items.MedallionBaseItem_Fabric;

public class WitcherMedallionRenderer extends WitcherMedallionRendererCommon<MedallionBaseItem_Fabric> {
    public WitcherMedallionRenderer(String type, boolean isOff) {
        super(isOff,new WitcherMedallionModelBase(isOff, type));
    }
}
