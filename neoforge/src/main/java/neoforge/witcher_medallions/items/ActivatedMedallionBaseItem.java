package neoforge.witcher_medallions.items;

import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.fml.ModList;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import witcher_medallions.WitcherMedallions_Main;
import neoforge.witcher_medallions.items.gecko.WitcherMedallionRenderer;
import witcher_medallions.items.ActivatedMedallionCommonItem;
import witcher_medallions.registry.WitcherMedallions_Items;
import witcher_medallions.utils.MiscUtil;

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

    //Medallions with soul bound
    @SuppressWarnings("all")
    @Override
    public ICurio.DropRule getDropRule(SlotContext slotContext, DamageSource source, int lootingLevel,
                                        boolean recentlyHit, ItemStack stack) {
        if(WitcherMedallions_Main.CONFIG.medallionsHaveSoulbound())
        {return ICurio.DropRule.ALWAYS_KEEP;}
        else
        {return ICurio.DropRule.DEFAULT;}
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity.level().isClientSide){
            return;
        }
        if(entity instanceof Player player){
            if(player.witcherMedallionsMod$getHasStrongMagicNear()){
                this.triggerAnim(entity, stack, "strong");
            }
            else if(player.witcherMedallionsMod$getHasMagicMobNear()){
                this.triggerAnim(entity, stack, "swing");
            } else {
                this.triggerAnim(entity, stack, "idle");
            }
        } else {
            this.triggerAnim(entity, stack, "idle");
        }
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        inventoryTick(stack, slotContext.entity().level(), slotContext.entity(), slotContext.index(), true);
    }

    //Attributes
    private final ResourceLocation WITCHER_TOXICITY = ResourceLocation.fromNamespaceAndPath("tcots_witcher","generic.witcher_toxicity");

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        var modifiers = super.getAttributeModifiers(slotContext, id, stack);

        if(ModList.get().getModContainerById("tcots_witcher").isPresent()){
            //Manticore
            //+10 Max Toxicity
            if(stack.is(WitcherMedallions_Items.Witcher_ManticoreMedallion())){
                MiscUtil.addAdditionAttributeTrinket(modifiers, WITCHER_TOXICITY, "manticore-toxicity", 10);
            }
        }

        return modifiers;
    }
}
