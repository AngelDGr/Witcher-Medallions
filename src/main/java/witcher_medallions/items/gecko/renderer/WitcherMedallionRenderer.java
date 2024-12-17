package witcher_medallions.items.gecko.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import witcher_medallions.items.MedallionBaseItem;
import witcher_medallions.items.gecko.models.WitcherMedallionModelBase;

public class WitcherMedallionRenderer extends GeoItemRenderer<MedallionBaseItem> {
    private final boolean isOff;
    public WitcherMedallionRenderer(String type, boolean isOff) {
        super(new WitcherMedallionModelBase(isOff, type));
        this.isOff = isOff;
    }

    protected Identifier getNeckTextureLocation(WitcherMedallionModelBase animatable) {
        return isOff? animatable.getNeckTexture_OFF() : animatable.getNeckTexture_ON();
    }

    //To have two different textures
    @Override
    public void render(ItemStack stack, ModelTransformationMode transformType, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, int packedOverlay) {
        this.animatable = (MedallionBaseItem) stack.getItem();
        this.currentItemStack = stack;
        this.renderPerspective = transformType;

        if (transformType == ModelTransformationMode.GUI) {
            renderInGui(transformType, poseStack, bufferSource, packedLight, packedOverlay);
        }
        else if((transformType == ModelTransformationMode.HEAD || transformType == ModelTransformationMode.FIXED) && model instanceof WitcherMedallionModelBase witcherMedallionModel) {

            RenderLayer renderType = getRenderType(this.animatable,

                    //Different texture as a necklace
                    getNeckTextureLocation(witcherMedallionModel),

                    bufferSource, MinecraftClient.getInstance().getTickDelta());
            VertexConsumer buffer = ItemRenderer.getDirectItemGlintConsumer(bufferSource, renderType, false, this.currentItemStack != null && this.currentItemStack.hasGlint());

            defaultRender(poseStack, this.animatable, bufferSource, renderType, buffer,
                    0, MinecraftClient.getInstance().getTickDelta(), packedLight);

        } else {
            RenderLayer renderType = getRenderType(this.animatable, getTextureLocation(this.animatable), bufferSource, MinecraftClient.getInstance().getTickDelta());
            VertexConsumer buffer = ItemRenderer.getDirectItemGlintConsumer(bufferSource, renderType, false, this.currentItemStack != null && this.currentItemStack.hasGlint());

            defaultRender(poseStack, this.animatable, bufferSource, renderType, buffer,
                    0, MinecraftClient.getInstance().getTickDelta(), packedLight);
        }
    }
}
