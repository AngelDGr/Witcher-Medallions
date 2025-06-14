package neoforge.witcher_medallions.items.gecko;

import neoforge.witcher_medallions.items.MedallionBaseItem_NeoForge;
import witcher_medallions.items.gecko.WitcherMedallionRendererCommon;

public class WitcherMedallionRenderer extends WitcherMedallionRendererCommon<MedallionBaseItem_NeoForge> {
    public WitcherMedallionRenderer(String type, boolean isOff) {
        super(isOff,new WitcherMedallionModelBase(isOff, type));
    }
}
