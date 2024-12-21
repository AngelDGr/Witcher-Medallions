package witcher_medallions.mixin;

import com.mojang.authlib.GameProfile;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.items.medallions.ActivedMedallionBaseItem;

import java.util.List;
import java.util.Optional;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayerEntity.class)
public abstract class MixinWitcherMedallionsSoundsTrigger extends AbstractClientPlayerEntity  {
    public MixinWitcherMedallionsSoundsTrigger(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }
    @Unique
    private static boolean cooldownSound = false;
    @Unique
    private static int ticksSound = 0;
    @Inject(method = "tickMovement()V", at = @At("HEAD"))
    public void tickMovement(CallbackInfo ci) {

        if(WitcherMedallions_Main.CONFIG.medallionSounds()){
            boolean soundTriggered=false;


            if(!cooldownSound && !MinecraftClient.getInstance().isPaused()) {
                //Makes sound when trinket equipped
                //Checks if it has any Trinket equipped
                if(TrinketsApi.getTrinketComponent(this).isPresent()){

                    //Get all the medallions equipped
                    List<Pair<SlotReference, ItemStack>> equippedMedallions =
                            TrinketsApi.getTrinketComponent(this).get().getEquipped(stack -> stack.getItem() instanceof ActivedMedallionBaseItem);

                    //Get the first medallion equipped if it has any, otherwise it's an empty stack
                    ItemStack medallionStack = equippedMedallions.stream().findFirst().isPresent()? equippedMedallions.stream().findFirst().get().getRight(): ItemStack.EMPTY;

                    //Check if the medallion has sounds and any monster is nearby
                    if((this.witcherMedallionsMod$getHasStrongMagicNear() || this.witcherMedallionsMod$getHasMagicMobNear())
                                    //Detects if it has sounds
                                    && this.getStackIsMedallionWithSounds(medallionStack)
                                    //The player exists
                                    && MinecraftClient.getInstance().player!=null){

                        MinecraftClient.getInstance().player.playSoundToPlayer(
                                this.witcherMedallionsMod$getHasStrongMagicNear()?
                                        ((ActivedMedallionBaseItem)(medallionStack.getItem())).getStrongAnimalSound():
                                        ((ActivedMedallionBaseItem)(medallionStack.getItem())).getAnimalSound(), SoundCategory.PLAYERS, 1, 1);

                        soundTriggered=true;
                    }
                }

                //If none medallion equipped triggered the sound already, search in the inventory and offhand
                if(!soundTriggered && (this.getInventory().main.stream().anyMatch(this::getStackIsMedallionWithSounds) || this.getInventory().offHand.stream().anyMatch(this::getStackIsMedallionWithSounds))){

                    Optional<ItemStack> medallionStackOffhand = this.getInventory().offHand.stream().filter(this::getStackIsMedallionWithSounds).findFirst();
                    Optional<ItemStack> medallionStack = this.getInventory().main.stream().filter(this::getStackIsMedallionWithSounds).findFirst();

                    //If detect something magic nearby, it sounds
                    if(this.witcherMedallionsMod$getHasMagicMobNear() || this.witcherMedallionsMod$getHasStrongMagicNear()){

                        if(medallionStackOffhand.isPresent() && medallionStackOffhand.get().getItem() instanceof ActivedMedallionBaseItem medallion && MinecraftClient.getInstance().player!=null){

                            MinecraftClient.getInstance().player.playSoundToPlayer(
                                    this.witcherMedallionsMod$getHasStrongMagicNear()?
                                            medallion.getStrongAnimalSound():
                                            medallion.getAnimalSound(), SoundCategory.PLAYERS, 1, 1);

                        } else if (medallionStack.isPresent() && medallionStack.get().getItem() instanceof ActivedMedallionBaseItem medallion && MinecraftClient.getInstance().player!=null) {

                            MinecraftClient.getInstance().player.playSoundToPlayer(
                                    this.witcherMedallionsMod$getHasStrongMagicNear()?
                                            medallion.getStrongAnimalSound():
                                            medallion.getAnimalSound(), SoundCategory.PLAYERS, 1, 1);
                        }
                    }
                }

                //Time cooldown last
                ticksSound=200;
                cooldownSound = true;
            } else {
                if (--ticksSound==0) {
                    cooldownSound =false;
                }
            }

        } else {
            if (--ticksSound>=0){
                if (ticksSound==0){
                    cooldownSound =false;
                }
            }
        }
    }

    @Unique
    private boolean getStackIsMedallionWithSounds(ItemStack stack){
        return stack.getItem() instanceof ActivedMedallionBaseItem medallion && medallion.getAnimalSound()!=null && medallion.getStrongAnimalSound()!=null;
    }
}
