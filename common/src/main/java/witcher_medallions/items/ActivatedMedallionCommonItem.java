package witcher_medallions.items;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import witcher_medallions.Constants;

import java.util.function.Consumer;

public interface ActivatedMedallionCommonItem extends GeoItem {

    String getId();

    SoundEvent getAnimalSound();

    SoundEvent getStrongAnimalSound();

    Object getRenderer();

    @Override
    default void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            @Override
            public @Nullable BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                return (BlockEntityWithoutLevelRenderer)getRenderer();
            }
        });
    }

    //Medallion Animation Stuff
    @Override
    default void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "mainController",
                5,
                state -> PlayState.STOP)
                .triggerableAnim("swing", Constants.SWING_ANIMATION)
                .triggerableAnim("strong", Constants.STRONG_ANIMATION)
                .triggerableAnim("idle", Constants.IDLE));
    }

    default void triggerAnim(Entity entity, ItemStack stack, String animName){
        this.triggerAnim(entity, GeoItem.getOrAssignId(stack, (ServerLevel) entity.level()), "mainController", animName);
    }
}
