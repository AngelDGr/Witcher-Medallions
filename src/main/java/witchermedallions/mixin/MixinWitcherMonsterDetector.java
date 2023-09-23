package witchermedallions.mixin;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import witchermedallions.witcherMod;
import witchermedallions.items.ModItems;

@Mixin(ClientPlayerEntity.class)
public abstract class MixinWitcherMonsterDetector extends AbstractClientPlayerEntity  {
    public MixinWitcherMonsterDetector(ClientWorld world, GameProfile profile, PlayerPublicKey publicKey) {
        super(world, profile, publicKey);
    }

    @Inject(method = "tickMovement()V", at = @At("HEAD"))
    public void tickMovement(CallbackInfo ci) {
        detectNearbyMobs_Wolf(this.world, this);
        detectNearbyMobs_Cat(this.world, this);
        detectNearbyMobs_Bear(this.world, this);
        detectNearbyMobs_Griffin(this.world, this);
        detectNearbyMobs_Viper(this.world, this);
        detectNearbyMobs_Manticore(this.world, this);
        detectNearbyMobs_AncientWolf(this.world, this);
        }
    private static boolean detectTrinket(PlayerEntity player, Item medallion){
            return
                player.isAlive()
                //Inventory
                &&  queryPlayerInventory(player, new ItemStack(medallion))
                //Equipped
                ||  (witcherMod.hasTrinket(player, medallion));
    }
    private static boolean queryPlayerInventory(PlayerEntity player, ItemStack item) {
        PlayerInventory playerInventory = player.getInventory();
        return playerInventory.contains(item);
    }
    private static Box createBox(PlayerEntity player){
        return new Box(
                //Detection Area
                player.getX()+witcherMod.CONFIG.passiveDetectionXZ(),player.getY()+witcherMod.CONFIG.passiveDetectionY(),player.getZ()+witcherMod.CONFIG.passiveDetectionXZ(),
                player.getX()-witcherMod.CONFIG.passiveDetectionXZ(),player.getY()-witcherMod.CONFIG.passiveDetectionY(),player.getZ()-witcherMod.CONFIG.passiveDetectionXZ());
    }

    private static boolean conditionsForBooleans(Entity mob, PlayerEntity player){
        return
                mob.isAlive()
                //Specifies mobs
                && witcherMod.CONFIG.MobList().contains(mob.getType().getTranslationKey())
                //Distance to Player
                && mob.distanceTo(player) <= witcherMod.CONFIG.passiveDetectionXZ();
    }

    //Methods for Medallions
    private static void detectNearbyMobs_Wolf(World world, PlayerEntity player) {
        if (detectTrinket(player, ModItems.Witcher_WolfMedallion))
        {//Make EntityList
            List<MobEntity> list = world.getEntitiesByClass(MobEntity.class,
                            createBox(player),
                            (T) -> true);
            //Detect
            if (!list.isEmpty()) {
                list.forEach(
                        (mob) -> witcherMod.NearMob_Wolf = conditionsForBooleans(mob,player)

                );
            }
            else {witcherMod.NearMob_Wolf = false;}
        }
        else {witcherMod.NearMob_Wolf = false;}
    }
    private static void detectNearbyMobs_Cat(World world, PlayerEntity player) {
        if (detectTrinket(player, ModItems.Witcher_CatMedallion))
        {//Make EntityList
            List<MobEntity> list = world.getEntitiesByClass(MobEntity.class,
                    createBox(player),
                    (T) -> true);
            //Detect
            if (!list.isEmpty()) {
                list.forEach(
                        (mob) -> witcherMod.NearMob_Cat = conditionsForBooleans(mob,player)
                );
            }
            else {witcherMod.NearMob_Cat = false;}
        }
        else {witcherMod.NearMob_Cat = false;}
    }
    private static void detectNearbyMobs_Bear(World world, PlayerEntity player) {
        if (detectTrinket(player, ModItems.Witcher_BearMedallion))
        {//Make EntityList
            List<MobEntity> list = world.getEntitiesByClass(MobEntity.class,
                    createBox(player),
                    (T) -> true);
            //Detect
            if (!list.isEmpty()) {
                list.forEach(
                        (mob) -> witcherMod.NearMob_Bear = conditionsForBooleans(mob,player)
                );
            }
            else {witcherMod.NearMob_Bear = false;}
        }
        else {witcherMod.NearMob_Bear = false;}
    }
    private static void detectNearbyMobs_Griffin(World world, PlayerEntity player) {
        if (detectTrinket(player, ModItems.Witcher_GriffinMedallion))
        {//Make EntityList
            List<MobEntity> list = world.getEntitiesByClass(MobEntity.class,
                    createBox(player),
                    (T) -> true);
            //Detect
            if (!list.isEmpty()) {
                list.forEach(
                        (mob) -> witcherMod.NearMob_Griffin = conditionsForBooleans(mob,player)
                );
            }
            else {witcherMod.NearMob_Griffin = false;}
        }
        else {witcherMod.NearMob_Griffin = false;}
    }
    private static void detectNearbyMobs_Viper(World world, PlayerEntity player) {
        if (detectTrinket(player, ModItems.Witcher_ViperMedallion))
        {//Make EntityList
            List<MobEntity> list = world.getEntitiesByClass(MobEntity.class,
                    createBox(player),
                    (T) -> true);
            //Detect
            if (!list.isEmpty()) {
                list.forEach(
                        (mob) -> witcherMod.NearMob_Viper = conditionsForBooleans(mob,player)
                );
            }
            else {witcherMod.NearMob_Viper = false;}
        }
        else {witcherMod.NearMob_Viper = false;}
    }
    private static void detectNearbyMobs_Manticore(World world, PlayerEntity player) {
        if (detectTrinket(player, ModItems.Witcher_ManticoreMedallion))
        {//Make EntityList
            List<MobEntity> list = world.getEntitiesByClass(MobEntity.class,
                    createBox(player),
                    (T) -> true);
            //Detect
            if (!list.isEmpty()) {
                list.forEach(
                        (mob) -> witcherMod.NearMob_Manticore = conditionsForBooleans(mob,player)
                );
            }
            else {witcherMod.NearMob_Manticore = false;}
        }
        else {witcherMod.NearMob_Manticore = false;}
    }
    private static void detectNearbyMobs_AncientWolf(World world, PlayerEntity player) {
        if (detectTrinket(player, ModItems.Witcher_AncientWolfMedallion))
        {//Make EntityList
            List<MobEntity> list = world.getEntitiesByClass(MobEntity.class,
                    createBox(player),
                    (T) -> true);
            //Detect
            if (!list.isEmpty()) {
                list.forEach(
                        (mob) -> witcherMod.NearMob_AncientWolf = conditionsForBooleans(mob,player)
                );
            }
            else {witcherMod.NearMob_AncientWolf = false;}
        }
        else {witcherMod.NearMob_AncientWolf = false;}
    }
}
