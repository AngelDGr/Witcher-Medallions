package witcher_medallions.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import witcher_medallions.items.gecko.WitcherMedallionRenderer;

import java.util.List;

public class ActivatedMedallionBaseItem extends MedallionBaseItem_NeoForge implements ActivatedMedallionCommonItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final String id;
    private final ChatFormatting tooltipColor;
    public ActivatedMedallionBaseItem(Properties settings, String id, ChatFormatting tooltipColor) {
        super(settings);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
        this.id=id;
        this.tooltipColor=tooltipColor;
    }
    public Object getRenderer(){
        return new WitcherMedallionRenderer(this.id,false);
    }

    @Override
    public String getId() {
        return id;
    }

    protected String getTooltip(){
        return "tooltip.witcher_medallions."+this.id+"_medallion_tooltip";
    }

    protected ChatFormatting getTooltipColor(){
        return this.tooltipColor;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, List<Component> tooltip, @NotNull TooltipFlag type) {
        tooltip.add(Component.translatable(getTooltip()+"_1").withStyle(getTooltipColor()));
        tooltip.add(Component.translatable(getTooltip()+"_2").withStyle(getTooltipColor()));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    //TODO: Add OwO config
    @Override
    public @NotNull ICurio.DropRule getDropRule(SlotContext slotContext, DamageSource source, boolean recentlyHit, ItemStack stack) {
        return super.getDropRule(slotContext, source, recentlyHit, stack);
    }
}
