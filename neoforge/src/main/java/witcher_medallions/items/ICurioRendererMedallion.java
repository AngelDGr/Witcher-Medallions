package witcher_medallions.items;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class ICurioRendererMedallion implements ICurioRenderer {
    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack,
                                                                          SlotContext slotReference,
                                                                          PoseStack matrices,
                                                                          RenderLayerParent<T, M> parent,
                                                                          MultiBufferSource vertexConsumers,
                                                                          int light,
                                                                          float limbSwing,
                                                                          float limbSwingAmount,
                                                                          float partialTicks,
                                                                          float ageInTicks,
                                                                          float headYaw,
                                                                          float headPitch) {
//        renderLayerParent.getModel();
        if (parent.getModel() instanceof HumanoidModel<?> playerModel) {
            translateToChest(matrices, playerModel);
//            moveMedallionWhenArmor(playerModel, matrices, "warriors_leather_jacket", 0.04f, 0.035f);
//            moveMedallionWhenArmor(playerModel, matrices, "ravens_armor", 0.025f, 0.025f);
//            moveMedallionWhenArmor(playerModel, matrices, "manticore_armor", 0.05f, 0.025f);

//            Minecraft.getInstance().getItemRenderer()
//                    .renderStatic(stack, ItemDisplayContext.HEAD, light, OverlayTexture.NO_OVERLAY,
//                            matrices, vertexConsumers,null, 0);
            Minecraft.getInstance().getItemRenderer()
                    .renderStatic(stack, ItemDisplayContext.HEAD, light, OverlayTexture.NO_OVERLAY,
                            matrices, vertexConsumers,null, 0);
        }


    }

    static void translateToChest(PoseStack matrices, HumanoidModel<?> model) {
        if (model.crouching && !model.riding && model.swimAmount == 0.0F) {
            matrices.translate(0.0F, 0.2F, 0.0F);
            matrices.mulPose(Axis.XP.rotation(model.body.xRot));
        }
        matrices.mulPose(Axis.YP.rotation(model.body.yRot));
        matrices.translate(0.0F, 0.4F, -0.16F);
    }

    private static void moveMedallionWhenArmor(Player player, PoseStack matrices, String armorID, float ZValue, float YValue) {
        if (BuiltInRegistries.ITEM.getKey(player.getItemBySlot(EquipmentSlot.CHEST).getItem())
                .equals(ResourceLocation.fromNamespaceAndPath("tcots-witcher", armorID))) {
            matrices.translate(0F, -YValue, -ZValue);
        } else {
            matrices.translate(0F, 0F, 0F);
        }
    }
}
