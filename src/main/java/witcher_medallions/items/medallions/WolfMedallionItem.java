package witcher_medallions.items.medallions;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Formatting;
import witcher_medallions.items.WitcherMedallions_Items;
import witcher_medallions.items.gecko.renderer.WitcherMedallionRenderer;

public class WolfMedallionItem extends ActivedMedallionBaseItem {
    public WolfMedallionItem(Settings settings) {
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
        return "tooltip.witcher-medallions.wolf_medallion_tooltip";
    }

    @Override
    protected Formatting getTooltipColor() {
        return Formatting.DARK_RED;
    }
}