package witchermedallions.items.gecko.item;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import dev.emi.trinkets.api.TrinketEnums;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import org.jetbrains.annotations.Nullable;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

import net.minecraft.entity.LivingEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

import witchermedallions.items.ModItems;
import witchermedallions.items.gecko.renderer.BearMedallionRenderer;
import witchermedallions.witcherMod;

public class BearMedallionItem extends TrinketItem implements GeoItem, TrinketRenderer {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    public BearMedallionItem(Settings settings) {
        super(settings);
    }

    //Geckolib4
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private final BearMedallionRenderer renderer = new BearMedallionRenderer();

            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                return this.renderer;
            }
        });
    }
    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<BearMedallionItem> tAnimationState) {
        return ModItems.AnimationDetection(tAnimationState, witcherMod.NearStrongMagic_Bear, witcherMod.NearMob_Bear);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    //Trinkets
	@Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        // ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        witcherMod.medallionTrinket(matrices,contextModel,entity,headYaw,headPitch);
    }

     @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.witcher-medallions.bearmedalliontp").formatted(Formatting.DARK_GREEN));
        super.appendTooltip(stack, world, tooltip, context);
    }
    @Override
    public TrinketEnums.DropRule getDropRule(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(witcherMod.CONFIG.medallionsHaveSoulbound())
        {return TrinketEnums.DropRule.KEEP;}
        else
        {return TrinketEnums.DropRule.DEFAULT;}
    }
}
