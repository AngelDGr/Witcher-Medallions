package witcher_medallions.items.gecko;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public abstract class WitcherMedallionRendererCommon<T extends Item & GeoAnimatable> extends GeoItemRenderer<T> {
    private final boolean isOff;
    public WitcherMedallionRendererCommon(boolean isOff, GeoModel<T> model) {
        super(model);
        this.isOff = isOff;
    }

    protected ResourceLocation getNeckTextureLocation(WitcherMedallionModelCommon<?> animatable) {
        return isOff? animatable.getNeckTexture_OFF() : animatable.getNeckTexture_ON();
    }

    //To have two different textures (So it looks different when held and when equipped)
    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack poseStack,
                             MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        this.animatable = (T) stack.getItem();
        this.currentItemStack = stack;
        this.renderPerspective = transformType;
        float partialTick = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);

        if (transformType == ItemDisplayContext.GUI) {
            renderInGui(transformType, poseStack, bufferSource, packedLight, packedOverlay, partialTick);
        }
        else if((transformType == ItemDisplayContext.HEAD || transformType == ItemDisplayContext.FIXED) && model instanceof WitcherMedallionModelCommon<?> witcherMedallionModel) {

            RenderType renderType = getRenderType(this.animatable,

                    //Different texture as a necklace
                    getNeckTextureLocation(witcherMedallionModel),

                    bufferSource, partialTick);
            VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(bufferSource, renderType, false, this.currentItemStack != null && this.currentItemStack.hasFoil());

            defaultRender(poseStack, this.animatable, bufferSource, renderType, buffer,
                    0, partialTick, packedLight);

        } else {
            RenderType renderType = getRenderType(this.animatable, getTextureLocation(this.animatable), bufferSource, partialTick);
            VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(bufferSource, renderType, false, this.currentItemStack != null && this.currentItemStack.hasFoil());

            defaultRender(poseStack, this.animatable, bufferSource, renderType, buffer,
                    0, partialTick, packedLight);
        }
    }
}
