package witcher_medallions.mixin;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import witcher_medallions.util.MedallionLogicUtil;
import witcher_medallions.WitcherMedallions_MainFabric;
import witcher_medallions.injection.PlayerGetNearMagicInjection;
import witcher_medallions.items.ActivatedMedallionBaseItem;

import java.util.List;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

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
        if(TrinketsApi.getTrinketComponent(this).isPresent()){

            //Get all the medallions equipped
            List<Tuple<SlotReference, ItemStack>> equippedMedallions =
                    TrinketsApi.getTrinketComponent(this).get().getEquipped(stack -> stack.getItem() instanceof ActivatedMedallionBaseItem);

            //Get the first medallion equipped if it has any, otherwise it's an empty stack
            medallionStackInTrinketSlot = equippedMedallions.stream().findFirst().isPresent()? equippedMedallions.stream().findFirst().get().getB(): ItemStack.EMPTY;
        }

        //If the player has any medallion in the inventory or as Trinket, starts all the logic
        if (this.inventory.hasAnyMatching(stack -> stack.getItem() instanceof ActivatedMedallionBaseItem) || !medallionStackInTrinketSlot.isEmpty()) {
            //Block detection
            if(WitcherMedallions_MainFabric.CONFIG.StrongDetectionForBlocks()){
                searchNearMagicBlocks(THIS);
                hasMagicBlockNear=optionalBlockPos.isPresent();
            } else {
                hasMagicBlockNear=false;
            }

            //Mob detection
             hasMobNear=MedallionLogicUtil.detectMobs(this.level(), THIS, false);
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
                        || Math.abs(optionalBlockPos.get().getZ() - player.getZ()) > WitcherMedallions_MainFabric.CONFIG.StrongpassiveDetectionXZ()
                        || Math.abs(optionalBlockPos.get().getX() - player.getX()) > WitcherMedallions_MainFabric.CONFIG.StrongpassiveDetectionXZ()
                        || Math.abs(optionalBlockPos.get().getY() - player.getY()) > WitcherMedallions_MainFabric.CONFIG.StrongpassiveDetectionY())
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
