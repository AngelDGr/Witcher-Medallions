package witcher_medallions.items.medallions;

import net.minecraft.util.Formatting;
import witcher_medallions.items.gecko.renderer.WitcherMedallionRenderer;

public class AncientWolfMedallionItem extends ActivedMedallionBaseItem {
    public AncientWolfMedallionItem(Settings settings) {
        super(settings);
    }

    @Override
    protected Object getRenderer() {
        return new WitcherMedallionRenderer("ancient_wolf",false);
    }

    @Override
    protected String getTooltip() {
        return "tooltip.witcher-medallions.ancient_wolf_medallion_tooltip";
    }

    @Override
    protected Formatting getTooltipColor() {
        return Formatting.DARK_GRAY;
    }
}