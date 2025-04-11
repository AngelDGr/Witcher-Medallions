package witcher_medallions.items.medallions;

import net.minecraft.ChatFormatting;
import net.minecraft.sounds.SoundEvent;
import witcher_medallions.items.WitcherMedallions_Items;
import witcher_medallions.items.gecko.renderer.WitcherMedallionRenderer;

public class WolfMedallionItem extends ActivedMedallionBaseItem {
    public WolfMedallionItem(Properties settings) {
        super(settings);
    }

    @Override
    public SoundEvent getAnimalSound() {
        return WitcherMedallions_Items.WOLF_MEDALLION_SOUND;
    }

    @Override
    public SoundEvent getStrongAnimalSound() {
        return WitcherMedallions_Items.STRONG_WOLF_MEDALLION_SOUND;
    }

    @Override
    protected Object getRenderer() {
        return new WitcherMedallionRenderer("wolf",false);
    }

    @Override
    protected String getTooltip() {
        return "tooltip.witcher_medallions.wolf_medallion_tooltip";
    }

    @Override
    protected ChatFormatting getTooltipColor() {
        return ChatFormatting.DARK_RED;
    }
}