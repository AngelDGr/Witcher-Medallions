package witcher_medallions.mixin;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import witcher_medallions.MedallionLogicUtil;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.injected.PlayerEntityMixinMedallions;
import witcher_medallions.items.medallions.ActivedMedallionBaseItem;

import java.util.List;
import java.util.Optional;

@Mixin(PlayerEntity.class)
public abstract class MixinWitcherMedallionDetection extends LivingEntity implements PlayerEntityMixinMedallions {
    protected MixinWitcherMedallionDetection(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
    @Shadow @Final private PlayerInventory inventory;

    @Unique
    PlayerEntity THIS = (PlayerEntity) (Object) this;

    @Inject(method = "tickMovement()V", at = @At("HEAD"))
    private void injectMedallionBlockDetection(CallbackInfo ci){
        ItemStack medallionStackInTrinketSlot = ItemStack.EMPTY;

        //Checks if it has any Trinket equipped
        if(TrinketsApi.getTrinketComponent(this).isPresent()){

            //Get all the medallions equipped
            List<Pair<SlotReference, ItemStack>> equippedMedallions =
                    TrinketsApi.getTrinketComponent(this).get().getEquipped(stack -> stack.getItem() instanceof ActivedMedallionBaseItem);

            //Get the first medallion equipped if it has any, otherwise it's an empty stack
            medallionStackInTrinketSlot = equippedMedallions.stream().findFirst().isPresent()? equippedMedallions.stream().findFirst().get().getRight(): ItemStack.EMPTY;

        }

        //If the player has any medallion in the inventory or as Trinket, starts all the logic
        if (this.inventory.containsAny(stack -> stack.getItem() instanceof ActivedMedallionBaseItem) || !medallionStackInTrinketSlot.isEmpty()) {
            //Block detection
            if(WitcherMedallions_Main.CONFIG.StrongDetectionForBlocks()){
                searchNearMagicBlocks(THIS);
                hasMagicBlockNear=optionalBlockPos.isPresent();
            } else {
                hasMagicBlockNear=false;
            }

            //Mob detection
             hasMobNear=MedallionLogicUtil.detectMobs(this.getWorld(), THIS, false);
             hasStrongMobNear=MedallionLogicUtil.detectMobs(this.getWorld(), THIS, true);
        }
    }

    @Unique
    private Optional<BlockPos> optionalBlockPos = Optional.empty();

    @Unique
    private void searchNearMagicBlocks(PlayerEntity player){
        //Checks every 2.5s
        if(optionalBlockPos.isEmpty() && player.age%50==0){
            optionalBlockPos = MedallionLogicUtil.detectNearMagicBlock(player.getWorld(), player);
        } else if(
                optionalBlockPos.isPresent()
                        && (
                        !MedallionLogicUtil.checkIsMagicBlock(player.getWorld().getBlockState(optionalBlockPos.get()).getBlock())
                        || Math.abs(optionalBlockPos.get().getZ() - player.getZ()) > WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ()
                        || Math.abs(optionalBlockPos.get().getX() - player.getX()) > WitcherMedallions_Main.CONFIG.StrongpassiveDetectionXZ()
                        || Math.abs(optionalBlockPos.get().getY() - player.getY()) > WitcherMedallions_Main.CONFIG.StrongpassiveDetectionY())
        ){
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
