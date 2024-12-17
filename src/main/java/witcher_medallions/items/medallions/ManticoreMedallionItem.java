package witcher_medallions.items.medallions;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Formatting;
import witcher_medallions.items.WitcherMedallions_Items;
import witcher_medallions.items.gecko.renderer.WitcherMedallionRenderer;

public class ManticoreMedallionItem extends ActivedMedallionBaseItem {
    public ManticoreMedallionItem(Settings settings) {
        super(settings);
    }

    @Override
    public SoundEvent getAnimalSound() {
        return WitcherMedallions_Items.MANTICORE_MEDALLION_SOUND;
    }

    @Override
    public SoundEvent getStrongAnimalSound() {
        return WitcherMedallions_Items.STRONG_MANTICORE_MEDALLION_SOUND;
    }

    @Override
    protected Object getRenderer() {
        return new WitcherMedallionRenderer("manticore",false);
    }

    @Override
    protected String getTooltip() {
        return "tooltip.witcher-medallions.manticore_medallion_tooltip";
    }

    @Override
    protected Formatting getTooltipColor() {
        return Formatting.DARK_PURPLE;
    }
}

