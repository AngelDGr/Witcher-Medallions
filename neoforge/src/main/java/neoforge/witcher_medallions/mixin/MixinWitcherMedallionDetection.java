package neoforge.witcher_medallions.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.injection.PlayerGetNearMagicInjection;
import neoforge.witcher_medallions.items.ActivatedMedallionBaseItem;
import neoforge.witcher_medallions.util.MedallionLogicUtil;

import java.util.Map;
import java.util.Optional;

@Mixin(Player.class)
public abstract class MixinWitcherMedallionDetection extends LivingEntity implements PlayerGetNearMagicInjection {
    protected MixinWitcherMedallionDetection(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Shadow @Final
    Inventory inventory;
    @Unique
    Player THIS = (Player) (Object) this;

    @Inject(method = "aiStep", at = @At("HEAD"))
    private void injectMedallionBlockDetection(CallbackInfo ci){
        ItemStack medallionStackInTrinketSlot = ItemStack.EMPTY;

        //Checks if it has any Trinket equipped
        if(CuriosApi.getCuriosInventory(this).isPresent()){
            //Get all the medallions equipped
            Map<String, ICurioStacksHandler> equippedMedallions =
                    CuriosApi.getCuriosInventory(this).get().getCurios();

            for(int i=0; i< equippedMedallions.get("necklace").getSlots();i++){
                ItemStack medallion=equippedMedallions.get("necklace").getStacks().getStackInSlot(i);
                //Get the first medallion equipped if it has any, otherwise it's an empty stack
                if(medallion.getItem() instanceof ActivatedMedallionBaseItem){
                    medallionStackInTrinketSlot = medallion;
                    break;
                } else {
                    medallionStackInTrinketSlot = ItemStack.EMPTY;
                }
            }
        }

        //If the player has any medallion in the inventory or as Trinket, starts all the logic
        if (this.inventory.hasAnyMatching(stack -> stack.getItem() instanceof ActivatedMedallionBaseItem) || !medallionStackInTrinketSlot.isEmpty()) {
            //Block detection
            if(WitcherMedallions_Main.CONFIG.StrongDetectionForBlocks()){
                searchNearMagicBlocks(THIS);
                hasMagicBlockNear=optionalBlockPos.isPresent();
            } else {
                hasMagicBlockNear=false;
            }

            //Mob detection
             hasMobNear= MedallionLogicUtil.detectMobs(this.level(), THIS, false);
             hasStrongMobNear=MedallionLogicUtil.detectMobs(this.level(), THIS, true);
        }
    }

    @SuppressWarnings("all")
    @Unique
    private Optional<BlockPos> optionalBlockPos = Optional.empty();

    @Unique
    private void searchNearMagicBlocks(Player player){
        //Checks every 2.5s
        if(optionalBlockPos.isEmpty() && player.tickCount%50==0){
            optionalBlockPos = MedallionLogicUtil.detectNearMagicBlock(player.level(), player);
        } else if(
                optionalBlockPos.isPresent()
                        && (
                        !MedallionLogicUtil.checkIsMagicBlock(player.level().getBlockState(optionalBlockPos.get()).getBlock())
                        || Math.abs(optionalBlockPos.get().getZ() - player.getZ()) > WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ()
                        || Math.abs(optionalBlockPos.get().getX() - player.getX()) > WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ()
                        || Math.abs(optionalBlockPos.get().getY() - player.getY()) > WitcherMedallions_Main.CONFIG.StrongpassiveDetectionY())
        )
        {
            optionalBlockPos=Optional.empty();
        }
    }

    @Unique
    private boolean hasMobNear;
    @Unique
    private boolean hasMagicBlockNear;
    @Unique
    private boolean hasStrongMobNear;

    @Override
    public boolean witcherMedallionsMod$getHasMagicMobNear() {
        return hasMobNear;
    }

    @Override
    public boolean witcherMedallionsMod$getHasStrongMagicNear() {
        return hasMagicBlockNear || hasStrongMobNear;
    }
}
