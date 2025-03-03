package witcher_medallions.items;

import dev.emi.trinkets.api.SlotReference;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import witcher_medallions.items.gecko.renderer.WitcherMedallionRenderer;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MedallionOffBaseItem extends MedallionBaseItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    private final Object renderer;

    public MedallionOffBaseItem(Settings settings, int index) {
        super(settings);
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER){
            this.renderer=null;
        } else {
            this.renderer = switch (index) {
                case 0 -> new WitcherMedallionRenderer("wolf", true);
                case 1 -> new WitcherMedallionRenderer("cat", true);
                case 2 -> new WitcherMedallionRenderer("bear", true);
                case 3 -> new WitcherMedallionRenderer("griffin", true);
                case 4 -> new WitcherMedallionRenderer("viper", true);
                case 5 -> new WitcherMedallionRenderer("manticore", true);
                case 6 -> new WitcherMedallionRenderer("ancient_wolf", true);
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
        }
    }

    private Object getRenderer(){
        return this.renderer;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state -> PlayState.CONTINUE));
    }

    //Trinkets
    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                return (BuiltinModelItemRenderer) getRenderer();
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.witcher-medallions.off_1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.witcher-medallions.off_2").formatted(Formatting.GRAY));
    }
}
