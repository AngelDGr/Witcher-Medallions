package witcher_medallions.items.medallions;

import net.minecraft.ChatFormatting;
import net.minecraft.sounds.SoundEvent;
import witcher_medallions.items.WitcherMedallions_Items;
import witcher_medallions.items.gecko.renderer.WitcherMedallionRenderer;

public class CatMedallionItem extends ActivedMedallionBaseItem {
    public CatMedallionItem(Properties settings) {
        super(settings);
    }

    @Override
    public SoundEvent getAnimalSound() {
        return WitcherMedallions_Items.CAT_MEDALLION_SOUND;
    }

    @Override
    public SoundEvent getStrongAnimalSound() {
        return WitcherMedallions_Items.STRONG_CAT_MEDALLION_SOUND;
    }

    @Override
    protected Object getRenderer() {
        return new WitcherMedallionRenderer("cat",false);
    }

    @Override
    protected String getTooltip() {
        return "tooltip.witcher_medallions.cat_medallion_tooltip";
    }

    @Override
    protected ChatFormatting getTooltipColor() {
        return ChatFormatting.DARK_AQUA;
    }
}
