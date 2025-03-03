package witcher_medallions.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import witcher_medallions.WitcherMedallions_Main;

import java.util.List;
import java.util.Optional;

public class MedallionLogicUtil {
    public static boolean detectMobs(World world, PlayerEntity player, boolean strong){
        List<MobEntity> list;

        if(strong){
            list = world.getEntitiesByClass(MobEntity.class, createBoxStrong(player), mob ->
                    conditionsForStrongMobBooleans(mob, player));
        } else {
            list = world.getEntitiesByClass(MobEntity.class, createBox(player), mob ->
                    conditionsForMobBooleans(mob, player));
        }

        return !list.isEmpty();
    }

    private static Box createBoxStrong(PlayerEntity player){
        return new Box(
                //Detection Area
                player.getX()+ WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ(),player.getY()+ WitcherMedallions_Main.CONFIG.StrongpassiveDetectionY(),player.getZ()+ WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ(),
                player.getX()- WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ(),player.getY()- WitcherMedallions_Main.CONFIG.StrongpassiveDetectionY(),player.getZ()- WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ());
    }
    private static Box createBox(PlayerEntity player){
        return new Box(
                //Detection Area
                player.getX()+ WitcherMedallions_Main.CONFIG.passiveDetectionXZ(),player.getY()+ WitcherMedallions_Main.CONFIG.passiveDetectionY(),player.getZ()+ WitcherMedallions_Main.CONFIG.passiveDetectionXZ(),
                player.getX()- WitcherMedallions_Main.CONFIG.passiveDetectionXZ(),player.getY()- WitcherMedallions_Main.CONFIG.passiveDetectionY(),player.getZ()- WitcherMedallions_Main.CONFIG.passiveDetectionXZ());
    }

    private static boolean conditionsForMobBooleans(Entity mob, PlayerEntity player){
        //Set Animation Activator to true
        return mob.isAlive()
                //IS in the MobList list
                && (
                WitcherMedallions_Main.CONFIG.MobList().contains(mob.getType().getTranslationKey())
                        || WitcherMedallions_Main.CONFIG.MobList().contains(Registries.ENTITY_TYPE.getId(mob.getType()).toString())
        )
                //Distance to Player
                && Math.abs(mob.getZ() - player.getZ()) <= WitcherMedallions_Main.CONFIG.passiveDetectionXZ()
                && Math.abs(mob.getX() - player.getX()) <= WitcherMedallions_Main.CONFIG.passiveDetectionXZ()
                && Math.abs(mob.getY() - player.getY()) <= WitcherMedallions_Main.CONFIG.passiveDetectionY();
    }
    private static boolean conditionsForStrongMobBooleans(Entity mob, PlayerEntity player){
        //Set Animation Activator to true
        return mob.isAlive()
                //IS in the StrongMagicSources list
                && (WitcherMedallions_Main.CONFIG.StrongMagicSourcesList().contains(mob.getType().getTranslationKey())
                || WitcherMedallions_Main.CONFIG.StrongMagicSourcesList().contains(Registries.ENTITY_TYPE.getId(mob.getType()).toString()))
                //Distance to Player
                && Math.abs(mob.getZ() - player.getZ()) <= WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ()
                && Math.abs(mob.getX() - player.getX()) <= WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ()
                && Math.abs(mob.getY() - player.getY()) <= WitcherMedallions_Main.CONFIG.StrongpassiveDetectionY();
    }

    public static Optional<BlockPos> detectNearMagicBlock(World world, PlayerEntity player){

        int radius = WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ();
        int height = WitcherMedallions_Main.CONFIG.StrongpassiveDetectionY();

        return BlockPos.findClosest(player.getBlockPos(), radius, height, blockPos -> checkIsMagicBlock(world.getBlockState(blockPos).getBlock()));
    }

    public static boolean checkIsMagicBlock(Block block){
        return WitcherMedallions_Main.CONFIG.StrongMagicSourcesList().contains(block.getTranslationKey())
                || WitcherMedallions_Main.CONFIG.StrongMagicSourcesList().contains(Registries.BLOCK.getId(block).toString());
    }
}
