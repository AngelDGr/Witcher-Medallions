package witcher_medallions.items.medallions;

import net.minecraft.ChatFormatting;
import witcher_medallions.items.gecko.renderer.WitcherMedallionRenderer;

public class AncientWolfMedallionItem extends ActivedMedallionBaseItem {
    public AncientWolfMedallionItem(Properties settings) {
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
    protected ChatFormatting getTooltipColor() {
        return ChatFormatting.DARK_GRAY;
    }



}