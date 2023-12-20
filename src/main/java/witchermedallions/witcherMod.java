package witchermedallions;

import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ModInitializer;

//Minecraft Libraries
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
//import net.minecraft.util.math.Vec3f;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3i;
import org.joml.Vector3f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import software.bernie.geckolib3.GeckoLib;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import witchermedallions.items.ModGroups;
import witchermedallions.items.ModItems;
import witchermedallions.items.gecko.item.WolfMedallionItem;

public class witcherMod implements ModInitializer {
	//Data initializer
	public static final String MODID = "witcher-medallions";
	public static final Logger LOGGER = LoggerFactory.getLogger("witcher-medallions");
	 public static final witchermedallions.WitcherMedallionsConfig CONFIG = witchermedallions.WitcherMedallionsConfig.createAndLoad();
	public static boolean NearMob_Wolf=false;
	public static boolean NearMob_Cat=false;
	public static boolean NearMob_Bear=false;
	public static boolean NearMob_Griffin=false;
	public static boolean NearMob_Viper=false;
	public static boolean NearMob_Manticore=false;
	public static boolean NearMob_AncientWolf=false;

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModGroups.registerGroupItems();

	}

	//DetectsMedallions	
	@SuppressWarnings("OptionalGetWithoutIsPresent")
    public static TrinketComponent getTrinkets(LivingEntity entity) {

        return TrinketsApi.getTrinketComponent(entity).get();
    }

//    public static void registerTrinketsRenderer() {
//        TrinketRendererRegistry.registerRenderer(ModRegistry.MONOCLE_ITEM.get(), (ItemStack itemStack, SlotReference slotReference, EntityModel<? extends LivingEntity> entityModel, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, LivingEntity livingEntity, float v, float v1, float v2, float v3, float v4, float v5) -> {
//            WolfMedallionItem.render(itemStack, poseStack, entityModel, multiBufferSource, i, ModRenderTypes::armorCutoutTranslucentNoCull);
//        });
//    }

	@SuppressWarnings({ "unchecked" })
	public static void medallionTrinket(MatrixStack matrices, EntityModel<? extends LivingEntity> model,
										LivingEntity entity, float headYaw, float headPitch) {

		if (entity.isInSwimmingPose() || entity.isFallFlying()) {
			if(model instanceof PlayerEntityModel)
			{

				PlayerEntityModel<AbstractClientPlayerEntity> ctx = (PlayerEntityModel<AbstractClientPlayerEntity>) model;
				matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(ctx.head.roll)
//						getDegreesQuaternion(ctx.head.roll)
			);
			}

			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(headYaw));
			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-45.0F));
		} else {

			if (entity.isInSneakingPose() && !model.riding) {
				matrices.translate(0F, 0F, 0F);
			}
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(headYaw));
			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(headPitch));
		}
		matrices.translate(0F, 0F, 0F);
	}

	public static boolean hasTrinket(LivingEntity entity, Item trinket) {
		return getTrinkets(entity).isEquipped(trinket);
    }

}