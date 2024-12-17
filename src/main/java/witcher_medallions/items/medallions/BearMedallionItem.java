package witcher_medallions.items.medallions;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Formatting;
import witcher_medallions.items.WitcherMedallions_Items;
import witcher_medallions.items.gecko.renderer.WitcherMedallionRenderer;

public class BearMedallionItem extends ActivedMedallionBaseItem {
    public BearMedallionItem(Settings settings) {
        super(settings);
    }

    @Override
    public SoundEvent getAnimalSound() {
        return WitcherMedallions_Items.BEAR_MEDALLION_SOUND;
    }

    @Override
    public SoundEvent getStrongAnimalSound() {
        return WitcherMedallions_Items.STRONG_BEAR_MEDALLION_SOUND;
    }

    @Override
    protected Object getRenderer() {
        return new WitcherMedallionRenderer("bear",false);
    }

    @Override
    protected String getTooltip() {
        return "tooltip.witcher-medallions.bear_medallion_tooltip";
    }

    @Override
    protected Formatting getTooltipColor() {
        return Formatting.DARK_GREEN;
    }
}
