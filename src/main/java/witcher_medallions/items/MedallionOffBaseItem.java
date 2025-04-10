package witcher_medallions.items;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.emi.trinkets.api.SlotReference;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import witcher_medallions.items.gecko.renderer.WitcherMedallionRenderer;

import java.util.List;
import java.util.function.Consumer;

public class MedallionOffBaseItem extends MedallionBaseItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final Object renderer;

    public MedallionOffBaseItem(Properties settings, int index) {
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
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, PoseStack matrices, MultiBufferSource vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {

            @Override
            public @Nullable BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                return (BlockEntityWithoutLevelRenderer) getRenderer();
            }
        });
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, List<Component> tooltip, @NotNull TooltipFlag type) {
        tooltip.add(Component.translatable("tooltip.witcher-medallions.off_1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("tooltip.witcher-medallions.off_2").withStyle(ChatFormatting.GRAY));
    }
}
