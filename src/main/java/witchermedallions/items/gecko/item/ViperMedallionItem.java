package witchermedallions.items.gecko.item;

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
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;

import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.InstancedAnimationFactory;
import witchermedallions.witcherMod;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class ViperMedallionItem extends TrinketItem implements IAnimatable, TrinketRenderer {
    public AnimationFactory factory = new InstancedAnimationFactory(this);
	
	public ViperMedallionItem(Settings settings) {
		super(settings);
		
	}

    @SuppressWarnings("all")
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(witcherMod.NearMob_Viper){
            event.getController().setAnimation(new AnimationBuilder().loop("medallion_animation"));
            return PlayState.CONTINUE;
        }

        if (witcherMod.NearMob_Viper==false){
            event.getController().setAnimation(new AnimationBuilder().loop("idle"));
            return PlayState.CONTINUE;
        }

        return PlayState.CONTINUE;
	}

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

	// AnimationData
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

	@Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        // ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        witcherMod.medallionTrinket(matrices,contextModel,entity,headYaw,headPitch);
    }

     @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.witcher-medallions.vipermedalliontp").formatted(Formatting.GREEN));
        super.appendTooltip(stack, world, tooltip, context);
    }
}