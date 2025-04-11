package witcher_medallions.items.gecko.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import witcher_medallions.items.MedallionBaseItem;
import witcher_medallions.items.gecko.models.WitcherMedallionModelBase;

public class WitcherMedallionRenderer extends GeoItemRenderer<MedallionBaseItem> {
    private final boolean isOff;
    public WitcherMedallionRenderer(String type, boolean isOff) {
        super(new WitcherMedallionModelBase(isOff, type));
        this.isOff = isOff;
    }

    protected ResourceLocation getNeckTextureLocation(WitcherMedallionModelBase animatable) {
        return isOff? animatable.getNeckTexture_OFF() : animatable.getNeckTexture_ON();
    }

    //To have two different textures
    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        this.animatable = (MedallionBaseItem) stack.getItem();
        this.currentItemStack = stack;
        this.renderPerspective = transformType;
        float partialTick = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);

        if (transformType == ItemDisplayContext.GUI) {
            renderInGui(transformType, poseStack, bufferSource, packedLight, packedOverlay, partialTick);
        }
        else if((transformType == ItemDisplayContext.HEAD || transformType == ItemDisplayContext.FIXED) && model instanceof WitcherMedallionModelBase witcherMedallionModel) {

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
