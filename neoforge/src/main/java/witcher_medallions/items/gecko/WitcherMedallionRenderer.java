package witcher_medallions.items.gecko;

import witcher_medallions.items.MedallionBaseItem_NeoForge;

public class WitcherMedallionRenderer extends WitcherMedallionRendererCommon<MedallionBaseItem_NeoForge> {
    public WitcherMedallionRenderer(String type, boolean isOff) {
        super(isOff,new WitcherMedallionModelBase(isOff, type));
    }
}
