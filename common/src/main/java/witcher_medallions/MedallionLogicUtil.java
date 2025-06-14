package witcher_medallions;

import java.util.List;
import java.util.Optional;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;

public class MedallionLogicUtil {

    public static boolean detectMobs(Level world, Player player, boolean strong){
        List<Mob> list;

        if(strong){
            list = world.getEntitiesOfClass(Mob.class, createBoxStrong(player), mob ->
                    conditionsForStrongMobBooleans(mob, player));
        } else {
            list = world.getEntitiesOfClass(Mob.class, createBox(player), mob ->
                    conditionsForMobBooleans(mob, player));
        }

        return !list.isEmpty();
    }

    private static AABB createBoxStrong(Player player){
        return new AABB(
                //Detection Area
                player.getX()+ WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ(),player.getY()+ WitcherMedallions_Main.CONFIG.StrongpassiveDetectionY(),player.getZ()+ WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ(),
                player.getX()- WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ(),player.getY()- WitcherMedallions_Main.CONFIG.StrongpassiveDetectionY(),player.getZ()- WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ());
    }
    private static AABB createBox(Player player){
        return new AABB(
                //Detection Area
                player.getX()+ WitcherMedallions_Main.CONFIG.passiveDetectionXZ(),player.getY()+ WitcherMedallions_Main.CONFIG.passiveDetectionY(),player.getZ()+ WitcherMedallions_Main.CONFIG.passiveDetectionXZ(),
                player.getX()- WitcherMedallions_Main.CONFIG.passiveDetectionXZ(),player.getY()- WitcherMedallions_Main.CONFIG.passiveDetectionY(),player.getZ()- WitcherMedallions_Main.CONFIG.passiveDetectionXZ());
    }

    private static boolean conditionsForMobBooleans(Entity mob, Player player){
        //Set Animation Activator to true
        return mob.isAlive()
                //IS in the MobList list
                && (
                WitcherMedallions_Main.CONFIG.MobList().contains(mob.getType().getDescriptionId())
                        || WitcherMedallions_Main.CONFIG.MobList().contains(BuiltInRegistries.ENTITY_TYPE.getKey(mob.getType()).toString())
        )
                //Distance to Player
                && Math.abs(mob.getZ() - player.getZ()) <= WitcherMedallions_Main.CONFIG.passiveDetectionXZ()
                && Math.abs(mob.getX() - player.getX()) <= WitcherMedallions_Main.CONFIG.passiveDetectionXZ()
                && Math.abs(mob.getY() - player.getY()) <= WitcherMedallions_Main.CONFIG.passiveDetectionY();
    }
    private static boolean conditionsForStrongMobBooleans(Entity mob, Player player){
        //Set Animation Activator to true
        return mob.isAlive()
                //IS in the StrongMagicSources list
                && (WitcherMedallions_Main.CONFIG.StrongMagicSourcesList().contains(mob.getType().getDescriptionId())
                || WitcherMedallions_Main.CONFIG.StrongMagicSourcesList().contains(BuiltInRegistries.ENTITY_TYPE.getKey(mob.getType()).toString()))
                //Distance to Player
                && Math.abs(mob.getZ() - player.getZ()) <= WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ()
                && Math.abs(mob.getX() - player.getX()) <= WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ()
                && Math.abs(mob.getY() - player.getY()) <= WitcherMedallions_Main.CONFIG.StrongpassiveDetectionY();
    }

    public static Optional<BlockPos> detectNearMagicBlock(Level world, Player player){

        int radius = WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ();
        int height = WitcherMedallions_Main.CONFIG.StrongpassiveDetectionY();

        return BlockPos.findClosestMatch(player.blockPosition(), radius, height, blockPos -> checkIsMagicBlock(world.getBlockState(blockPos).getBlock()));
    }

    public static boolean checkIsMagicBlock(Block block){
        return WitcherMedallions_Main.CONFIG.StrongMagicSourcesList().contains(block.getDescriptionId())
                || WitcherMedallions_Main.CONFIG.StrongMagicSourcesList().contains(BuiltInRegistries.BLOCK.getKey(block).toString());
    }
}
