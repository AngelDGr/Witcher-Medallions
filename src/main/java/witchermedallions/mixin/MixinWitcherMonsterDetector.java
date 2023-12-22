package witchermedallions.mixin;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

import net.minecraft.util.math.BlockPos;


import witchermedallions.witcherMod;
import witchermedallions.items.ModItems;

@Mixin(ClientPlayerEntity.class)
public abstract class MixinWitcherMonsterDetector extends AbstractClientPlayerEntity  {
    @Shadow private boolean healthInitialized;

    public MixinWitcherMonsterDetector(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }
    @Unique
    private static boolean cooldownBlock = false;
    @Unique
    private static int ticks = 0;
    @Inject(method = "tickMovement()V", at = @At("HEAD"))
    public void tickMovement(CallbackInfo ci) {
        //Wolf Medallion
        boolean[] resultMobs_Wolf = detectNearbyMobs(this.getWorld(), this, ModItems.Witcher_WolfMedallion, witcherMod.NearMob_Wolf, witcherMod.NearStrongMagic_Wolf);
        witcherMod.NearMob_Wolf = resultMobs_Wolf[0];
        witcherMod.NearStrongMagic_Wolf = resultMobs_Wolf[1];
        //Cat Medallion
        boolean[] resultMobs_Cat = detectNearbyMobs(this.getWorld(), this, ModItems.Witcher_CatMedallion, witcherMod.NearMob_Cat, witcherMod.NearStrongMagic_Cat);
        witcherMod.NearMob_Cat = resultMobs_Cat[0];
        witcherMod.NearStrongMagic_Cat = resultMobs_Cat[1];
        // Bear Medallion
        boolean[] resultMobs_Bear = detectNearbyMobs(this.getWorld(), this, ModItems.Witcher_BearMedallion, witcherMod.NearMob_Bear, witcherMod.NearStrongMagic_Bear);
        witcherMod.NearMob_Bear = resultMobs_Bear[0];
        witcherMod.NearStrongMagic_Bear = resultMobs_Bear[1];
        // Griffin Medallion
        boolean[] resultMobs_Griffin = detectNearbyMobs(this.getWorld(), this, ModItems.Witcher_GriffinMedallion, witcherMod.NearMob_Griffin, witcherMod.NearStrongMagic_Griffin);
        witcherMod.NearMob_Griffin = resultMobs_Griffin[0];
        witcherMod.NearStrongMagic_Griffin = resultMobs_Griffin[1];
        // Viper Medallion
        boolean[] resultMobs_Viper = detectNearbyMobs(this.getWorld(), this, ModItems.Witcher_ViperMedallion, witcherMod.NearMob_Viper, witcherMod.NearStrongMagic_Viper);
        witcherMod.NearMob_Viper = resultMobs_Viper[0];
        witcherMod.NearStrongMagic_Viper = resultMobs_Viper[1];
        // Manticore Medallion
        boolean[] resultMobs_Manticore = detectNearbyMobs(this.getWorld(), this, ModItems.Witcher_ManticoreMedallion, witcherMod.NearMob_Manticore, witcherMod.NearStrongMagic_Manticore);
        witcherMod.NearMob_Manticore = resultMobs_Manticore[0];
        witcherMod.NearStrongMagic_Manticore = resultMobs_Manticore[1];
        // Ancient Wolf Medallion
        boolean[] resultMobs_AncientWolf = detectNearbyMobs(this.getWorld(), this, ModItems.Witcher_AncientWolfMedallion, witcherMod.NearMob_AncientWolf, witcherMod.NearStrongMagic_AncientWolf);
        witcherMod.NearMob_AncientWolf = resultMobs_AncientWolf[0];
        witcherMod.NearStrongMagic_AncientWolf = resultMobs_AncientWolf[1];

        //Blocks detection
        if(witcherMod.CONFIG.StrongDetectionForBlocks() && !witcherMod.cooldownBlocks){
            //Wolf
            boolean[] resultMagic_Wolf = detectNearbyMagicBlocks(this.getWorld(), this, ModItems.Witcher_WolfMedallion, witcherMod.NearMob_Wolf, witcherMod.NearStrongMagic_Wolf, witcherMod.cooldownBlocks);
            witcherMod.NearMob_Wolf = resultMagic_Wolf[0];
            witcherMod.NearStrongMagic_Wolf = resultMagic_Wolf[1];
            witcherMod.cooldownBlocks=resultMagic_Wolf[2];
            //In case the player has some other medallion
            if(witcherMod.NearStrongMagic_Wolf){
                if(detectTrinket(this,ModItems.Witcher_CatMedallion)){witcherMod.NearStrongMagic_Cat=true;}
                if(detectTrinket(this,ModItems.Witcher_BearMedallion)){witcherMod.NearStrongMagic_Bear=true;}
                if(detectTrinket(this,ModItems.Witcher_GriffinMedallion)){witcherMod.NearStrongMagic_Griffin=true;}
                if(detectTrinket(this,ModItems.Witcher_ViperMedallion)) {witcherMod.NearStrongMagic_Viper = true;}
                if(detectTrinket(this,ModItems.Witcher_ManticoreMedallion)){witcherMod.NearStrongMagic_Manticore=true;}
                if(detectTrinket(this,ModItems.Witcher_AncientWolfMedallion)){witcherMod.NearStrongMagic_AncientWolf=true;}
            }
            else {
                if(witcherMod.NearStrongMagic_Cat){witcherMod.NearStrongMagic_Cat=false;}
                if(witcherMod.NearStrongMagic_Bear){witcherMod.NearStrongMagic_Bear=false;}
                if(witcherMod.NearStrongMagic_Griffin){witcherMod.NearStrongMagic_Griffin=false;}
                if(witcherMod.NearStrongMagic_Viper){witcherMod.NearStrongMagic_Viper=false;}
                if(witcherMod.NearStrongMagic_Manticore){witcherMod.NearStrongMagic_Manticore=false;}
                if(witcherMod.NearStrongMagic_AncientWolf){witcherMod.NearStrongMagic_AncientWolf=false;}
            }
            //Cat
            boolean[] resultMagic_Cat = detectNearbyMagicBlocks(this.getWorld(), this, ModItems.Witcher_CatMedallion, witcherMod.NearMob_Cat, witcherMod.NearStrongMagic_Cat, witcherMod.cooldownBlocks);
            witcherMod.NearMob_Cat = resultMagic_Cat[0];
            witcherMod.NearStrongMagic_Cat = resultMagic_Cat[1];
            witcherMod.cooldownBlocks=resultMagic_Cat[2];
            //In case the player has some other medallion
            if(!detectTrinket(this,ModItems.Witcher_WolfMedallion)){
                if(witcherMod.NearStrongMagic_Cat){
                    if(detectTrinket(this,ModItems.Witcher_BearMedallion)){witcherMod.NearStrongMagic_Bear=true;}
                    if(detectTrinket(this,ModItems.Witcher_GriffinMedallion)){witcherMod.NearStrongMagic_Griffin=true;}
                    if(detectTrinket(this,ModItems.Witcher_ViperMedallion)) {witcherMod.NearStrongMagic_Viper = true;}
                    if(detectTrinket(this,ModItems.Witcher_ManticoreMedallion)){witcherMod.NearStrongMagic_Manticore=true;}
                    if(detectTrinket(this,ModItems.Witcher_AncientWolfMedallion)){witcherMod.NearStrongMagic_AncientWolf=true;}
                }
                else {
                    if(witcherMod.NearStrongMagic_Bear){witcherMod.NearStrongMagic_Bear=false;}
                    if(witcherMod.NearStrongMagic_Griffin){witcherMod.NearStrongMagic_Griffin=false;}
                    if(witcherMod.NearStrongMagic_Viper){witcherMod.NearStrongMagic_Viper=false;}
                    if(witcherMod.NearStrongMagic_Manticore){witcherMod.NearStrongMagic_Manticore=false;}
                    if(witcherMod.NearStrongMagic_AncientWolf){witcherMod.NearStrongMagic_AncientWolf=false;}
                }
            }
            //Bear
            boolean[] resultMagic_Bear = detectNearbyMagicBlocks(this.getWorld(), this, ModItems.Witcher_BearMedallion, witcherMod.NearMob_Bear, witcherMod.NearStrongMagic_Bear, witcherMod.cooldownBlocks);
            witcherMod.NearMob_Bear = resultMagic_Bear[0];
            witcherMod.NearStrongMagic_Bear = resultMagic_Bear[1];
            witcherMod.cooldownBlocks=resultMagic_Bear[2];
            //In case the player has some other medallion
            if(!detectTrinket(this,ModItems.Witcher_CatMedallion)){
                if(witcherMod.NearStrongMagic_Bear){
                    if(detectTrinket(this,ModItems.Witcher_GriffinMedallion)){witcherMod.NearStrongMagic_Griffin=true;}
                    if(detectTrinket(this,ModItems.Witcher_ViperMedallion)) {witcherMod.NearStrongMagic_Viper = true;}
                    if(detectTrinket(this,ModItems.Witcher_ManticoreMedallion)){witcherMod.NearStrongMagic_Manticore=true;}
                    if(detectTrinket(this,ModItems.Witcher_AncientWolfMedallion)){witcherMod.NearStrongMagic_AncientWolf=true;}
                }
                else {
                    if(witcherMod.NearStrongMagic_Griffin){witcherMod.NearStrongMagic_Griffin=false;}
                    if(witcherMod.NearStrongMagic_Viper){witcherMod.NearStrongMagic_Viper=false;}
                    if(witcherMod.NearStrongMagic_Manticore){witcherMod.NearStrongMagic_Manticore=false;}
                    if(witcherMod.NearStrongMagic_AncientWolf){witcherMod.NearStrongMagic_AncientWolf=false;}
                }
            }

            //Griffin
            boolean[] resultMagic_Griffin = detectNearbyMagicBlocks(this.getWorld(), this, ModItems.Witcher_GriffinMedallion, witcherMod.NearMob_Griffin, witcherMod.NearStrongMagic_Griffin, witcherMod.cooldownBlocks);
            witcherMod.NearMob_Griffin = resultMagic_Griffin[0];
            witcherMod.NearStrongMagic_Griffin = resultMagic_Griffin[1];
            witcherMod.cooldownBlocks=resultMagic_Griffin[2];
            //In case the player has some other medallion
            if(!detectTrinket(this,ModItems.Witcher_BearMedallion)){
                if(witcherMod.NearStrongMagic_Griffin){
                    if(detectTrinket(this,ModItems.Witcher_ViperMedallion)) {witcherMod.NearStrongMagic_Viper = true;}
                    if(detectTrinket(this,ModItems.Witcher_ManticoreMedallion)){witcherMod.NearStrongMagic_Manticore=true;}
                    if(detectTrinket(this,ModItems.Witcher_AncientWolfMedallion)){witcherMod.NearStrongMagic_AncientWolf=true;}
                }
                else {
                    if(witcherMod.NearStrongMagic_Viper){witcherMod.NearStrongMagic_Viper=false;}
                    if(witcherMod.NearStrongMagic_Manticore){witcherMod.NearStrongMagic_Manticore=false;}
                    if(witcherMod.NearStrongMagic_AncientWolf){witcherMod.NearStrongMagic_AncientWolf=false;}
                }
            }
            //Viper
            boolean[] resultMagic_Viper = detectNearbyMagicBlocks(this.getWorld(), this, ModItems.Witcher_ViperMedallion, witcherMod.NearMob_Viper, witcherMod.NearStrongMagic_Viper, witcherMod.cooldownBlocks);
            witcherMod.NearMob_Viper = resultMagic_Viper[0];
            witcherMod.NearStrongMagic_Viper = resultMagic_Viper[1];
            witcherMod.cooldownBlocks=resultMagic_Viper[2];
            //In case the player has some other medallion
            if(!detectTrinket(this,ModItems.Witcher_GriffinMedallion)){
                if(witcherMod.NearStrongMagic_Viper){
                    if(detectTrinket(this,ModItems.Witcher_ManticoreMedallion)){witcherMod.NearStrongMagic_Manticore=true;}
                    if(detectTrinket(this,ModItems.Witcher_AncientWolfMedallion)){witcherMod.NearStrongMagic_AncientWolf=true;}
                }
                else {
                    if(witcherMod.NearStrongMagic_Manticore){witcherMod.NearStrongMagic_Manticore=false;}
                    if(witcherMod.NearStrongMagic_AncientWolf){witcherMod.NearStrongMagic_AncientWolf=false;}
                }
            }
            //Manticore
            boolean[] resultMagic_Manticore = detectNearbyMagicBlocks(this.getWorld(), this, ModItems.Witcher_ManticoreMedallion, witcherMod.NearMob_Manticore, witcherMod.NearStrongMagic_Manticore, witcherMod.cooldownBlocks);
            witcherMod.NearMob_Manticore = resultMagic_Manticore[0];
            witcherMod.NearStrongMagic_Manticore = resultMagic_Manticore[1];
            witcherMod.cooldownBlocks=resultMagic_Manticore[2];
            //In case the player has some other medallion
            if(!detectTrinket(this,ModItems.Witcher_ViperMedallion)){
                if(witcherMod.NearStrongMagic_Manticore){
                    if(detectTrinket(this,ModItems.Witcher_AncientWolfMedallion)){witcherMod.NearStrongMagic_AncientWolf=true;}
                }
                else {
                    if(witcherMod.NearStrongMagic_AncientWolf){witcherMod.NearStrongMagic_AncientWolf=false;}
                }
            }
            //AncientWolf
            boolean[] resultMagic_AncientWolf = detectNearbyMagicBlocks(this.getWorld(), this, ModItems.Witcher_AncientWolfMedallion, witcherMod.NearMob_AncientWolf, witcherMod.NearStrongMagic_AncientWolf, witcherMod.cooldownBlocks);
            witcherMod.NearMob_AncientWolf = resultMagic_AncientWolf[0];
            witcherMod.NearStrongMagic_AncientWolf = resultMagic_AncientWolf[1];
            witcherMod.cooldownBlocks=resultMagic_AncientWolf[2];
        }
        else{
            //Only if the Block Detection it's off
            if(!witcherMod.CONFIG.StrongDetectionForBlocks()){
                if(witcherMod.NearStrongMagic_Wolf && !witcherMod.NearStrongMob){
                    witcherMod.NearStrongMagic_Wolf=false;
                }

                if(witcherMod.NearStrongMagic_Cat && !witcherMod.NearStrongMob){
                    witcherMod.NearStrongMagic_Cat=false;
                }

                if(witcherMod.NearStrongMagic_Bear && !witcherMod.NearStrongMob){
                    witcherMod.NearStrongMagic_Bear=false;
                }

                if(witcherMod.NearStrongMagic_Griffin && !witcherMod.NearStrongMob){
                    witcherMod.NearStrongMagic_Griffin=false;
                }

                if(witcherMod.NearStrongMagic_Viper && !witcherMod.NearStrongMob){
                    witcherMod.NearStrongMagic_Viper=false;
                }

                if(witcherMod.NearStrongMagic_Manticore && !witcherMod.NearStrongMob){
                    witcherMod.NearStrongMagic_Manticore=false;
                }

                witcherMod.NearMagicBlock=false;
                if(witcherMod.NearStrongMagic_AncientWolf && !witcherMod.NearStrongMob){
                    witcherMod.NearStrongMagic_AncientWolf=false;
                }
            }

            --ticks;
            if (ticks == 0) {
                witcherMod.cooldownBlocks = false;
          }
           }
        }
    @Unique
    private static boolean detectTrinket(PlayerEntity player, Item medallion){
            return
                player.isAlive()
                //Inventory
                &&  queryPlayerInventory(player, new ItemStack(medallion))
                //OR Equipped
                ||  (witcherMod.hasTrinketEquipped(player, medallion));
    }
    @Unique
    private static boolean queryPlayerInventory(PlayerEntity player, ItemStack item) {
        PlayerInventory playerInventory = player.getInventory();
        return playerInventory.contains(item);
    }
    @Unique
    private static Box createBox(PlayerEntity player){
        return new Box(
                //Detection Area
                player.getX()+witcherMod.CONFIG.StrongpassiveDetectionXZ(),player.getY()+witcherMod.CONFIG.StrongpassiveDetectionY(),player.getZ()+witcherMod.CONFIG.StrongpassiveDetectionXZ(),
                player.getX()-witcherMod.CONFIG.StrongpassiveDetectionXZ(),player.getY()-witcherMod.CONFIG.StrongpassiveDetectionY(),player.getZ()-witcherMod.CONFIG.StrongpassiveDetectionXZ());
    }

    @Unique
    private static boolean conditionsForStrongMobBooleans(Entity mob, PlayerEntity player){
        //Set Animation Activator to true
        return mob.isAlive()
                //IS in the StrongMagicSources list
                && witcherMod.CONFIG.StrongMagicSourcesList().contains(mob.getType().getTranslationKey())
                //Distance to Player
                && Math.abs(mob.getZ() - player.getZ()) <= witcherMod.CONFIG.StrongpassiveDetectionXZ()
                && Math.abs(mob.getX() - player.getX()) <= witcherMod.CONFIG.StrongpassiveDetectionXZ()
                && Math.abs(mob.getY() - player.getY()) <= witcherMod.CONFIG.StrongpassiveDetectionY();
    }

    @Unique
    private static boolean conditionsForMobBooleans(Entity mob, PlayerEntity player){
        //Set Animation Activator to true
        return mob.isAlive()
                //IS in the StrongMagicSources list
                && witcherMod.CONFIG.MobList().contains(mob.getType().getTranslationKey())
                //Distance to Player
                && Math.abs(mob.getZ() - player.getZ()) <= witcherMod.CONFIG.passiveDetectionXZ()
                && Math.abs(mob.getX() - player.getX()) <= witcherMod.CONFIG.passiveDetectionXZ()
                && Math.abs(mob.getY() - player.getY()) <= witcherMod.CONFIG.passiveDetectionY();
    }

    @Unique
    private static boolean[] detectNearbyMagicBlocks(World world, PlayerEntity player, Item medallion, boolean NearMob, boolean NearStrongMagic, boolean cooldown) {
        int radius = witcherMod.CONFIG.StrongpassiveDetectionXZ();
        int height = witcherMod.CONFIG.StrongpassiveDetectionY();

            //There's no cooldown and the player has the medallion
            if (!cooldown &&
                    detectTrinket(player, medallion)
            ) {
                //Make a new list
                List<BlockState> list = new ArrayList<>();

                //Iterates around the player, add to the list each BlockState
                BlockPos.iterateOutwards(
                        player.getBlockPos(), radius, height, radius).forEach(
                        blockPosI -> list.add(world.getBlockState(blockPosI))
                );
                //If the list isn't empty and some blocks are in the StrongMagicSource list
                if (
                        !list.isEmpty() &&
                                list.stream().anyMatch(
                                        (blockS) -> witcherMod.CONFIG.StrongMagicSourcesList().contains(blockS.getBlock().getTranslationKey()))
                ) {
                    //Deactivates the normal mob detection
                    NearMob = false;
                    //Set NearMagicBlock to true
                    witcherMod.NearMagicBlock = true;
                    //Set Animation Activator to true
                    NearStrongMagic = true;
                    //Set a cooldown for performance
                    ticks = 30;
                    cooldown = true;
                }
                //No magic block nearby or the list it's empty
                else {
                    //Set the Magic Block to false because there's not any
                    if (witcherMod.NearMagicBlock){
                        witcherMod.NearMagicBlock = false;}
                    //Set the Animation activator to false if isn't any Strong Mob nearby
                    if (witcherMod.NearStrongMagic_Wolf && !witcherMod.NearStrongMob) {witcherMod.NearStrongMagic_Wolf = false;}
                    //Set a cooldown for performance
                    ticks = 30;
                    cooldown = true;
                }
            }
            //The Cooldown it is active, so starts the counter
            else {
                --ticks;
                if (ticks == 0) {
                    cooldown = false;
                }

            }

        //Reassign the booleans
        return new boolean[]{NearMob, NearStrongMagic, cooldown};
    }

    @Unique
    private static boolean[] detectNearbyMobs(World world, PlayerEntity player, Item medallion, boolean NearMob, boolean NearStrongMagic) {

        //If the player has the medallion
        if (detectTrinket(player, medallion)) {
            List<MobEntity> list = world.getEntitiesByClass(MobEntity.class, createBox(player), (T) -> true);

            //There's some mob
            if (!list.isEmpty()) {
                if (list.stream().anyMatch((mob) -> conditionsForStrongMobBooleans(mob, player))) {
                    witcherMod.NearStrongMob = true;
                    NearMob = false;
                    NearStrongMagic = true;
                } else {
                    witcherMod.NearStrongMob = false;
                    //If isn't Strong mob, tries to detect normal mob
                    if (list.stream().anyMatch((mob) -> conditionsForMobBooleans(mob, player))){
                        NearMob = true;
                    }
                    else{
                        if(NearMob){NearMob = false;}
                    }
                    if (NearStrongMagic && !witcherMod.NearMagicBlock) {
                        NearStrongMagic = false;
                    }
                }
            }
            //There's not any mob nearby, so everything to false
            else {
                NearMob = false;
                witcherMod.NearStrongMob = false;
                //Deactivate only if there's none magic block nearby
                if (!witcherMod.NearMagicBlock && NearStrongMagic) {
                    NearStrongMagic = false;
                }
            }
        }

        //The  player doesn't even have the medallion
        else {
            NearMob = false;
            witcherMod.NearStrongMob = false;
            NearStrongMagic = false;
        }

        return new boolean[]{NearMob, NearStrongMagic};
    }

}
