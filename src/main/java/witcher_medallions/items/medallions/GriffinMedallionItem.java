package witcher_medallions.items.medallions;

import net.minecraft.ChatFormatting;
import net.minecraft.sounds.SoundEvent;
import witcher_medallions.items.WitcherMedallions_Items;
import witcher_medallions.items.gecko.renderer.WitcherMedallionRenderer;

public class GriffinMedallionItem extends ActivedMedallionBaseItem {
    public GriffinMedallionItem(Properties settings) {
        super(settings);
    }

    @Override
    public SoundEvent getAnimalSound() {
        return WitcherMedallions_Items.GRIFFIN_MEDALLION_SOUND;
    }

    @Override
    public SoundEvent getStrongAnimalSound() {
        return WitcherMedallions_Items.STRONG_GRIFFIN_MEDALLION_SOUND;
    }

    @Override
    protected Object getRenderer() {
        return new WitcherMedallionRenderer("griffin",false);
    }

    @Override
    protected String getTooltip() {
        return "tooltip.witcher-medallions.griffin_medallion_tooltip";
    }

    @Override
    protected ChatFormatting getTooltipColor() {
        return ChatFormatting.YELLOW;
    }
}

