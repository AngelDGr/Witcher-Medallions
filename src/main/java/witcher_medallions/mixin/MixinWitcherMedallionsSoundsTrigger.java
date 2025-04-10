package witcher_medallions.mixin;

import com.mojang.authlib.GameProfile;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.ItemStack;
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
@Mixin(LocalPlayer.class)
public abstract class MixinWitcherMedallionsSoundsTrigger extends AbstractClientPlayer  {
    public MixinWitcherMedallionsSoundsTrigger(ClientLevel world, GameProfile profile) {
        super(world, profile);
    }
    @Unique
    private static boolean cooldownSound = false;
    @Unique
    private static int ticksSound = 0;
    @Inject(method = "aiStep", at = @At("HEAD"))
    public void tickMovement(CallbackInfo ci) {

        if(WitcherMedallions_Main.CONFIG.medallionSounds()){
            boolean soundTriggered=false;


            if(!cooldownSound && !Minecraft.getInstance().isPaused()) {
                //Makes sound when trinket equipped
                //Checks if it has any Trinket equipped
                if(TrinketsApi.getTrinketComponent(this).isPresent()){

                    //Get all the medallions equipped
                    List<Tuple<SlotReference, ItemStack>> equippedMedallions =
                            TrinketsApi.getTrinketComponent(this).get().getEquipped(stack -> stack.getItem() instanceof ActivedMedallionBaseItem);

                    //Get the first medallion equipped if it has any, otherwise it's an empty stack
                    ItemStack medallionStack = equippedMedallions.stream().findFirst().isPresent()? equippedMedallions.stream().findFirst().get().getB(): ItemStack.EMPTY;

                    //Check if the medallion has sounds and any monster is nearby
                    if((this.witcherMedallionsMod$getHasStrongMagicNear() || this.witcherMedallionsMod$getHasMagicMobNear())
                                    //Detects if it has sounds
                                    && this.getStackIsMedallionWithSounds(medallionStack)
                                    //The player exists
                                    && Minecraft.getInstance().player!=null){

                        Minecraft.getInstance().player.playNotifySound(
                                this.witcherMedallionsMod$getHasStrongMagicNear()?
                                        ((ActivedMedallionBaseItem)(medallionStack.getItem())).getStrongAnimalSound():
                                        ((ActivedMedallionBaseItem)(medallionStack.getItem())).getAnimalSound(), SoundSource.PLAYERS, 1, 1);

                        soundTriggered=true;
                    }
                }

                //If none medallion equipped triggered the sound already, search in the inventory and offhand
                if(!soundTriggered && (this.getInventory().items.stream().anyMatch(this::getStackIsMedallionWithSounds) || this.getInventory().offhand.stream().anyMatch(this::getStackIsMedallionWithSounds))){

                    Optional<ItemStack> medallionStackOffhand = this.getInventory().offhand.stream().filter(this::getStackIsMedallionWithSounds).findFirst();
                    Optional<ItemStack> medallionStack = this.getInventory().items.stream().filter(this::getStackIsMedallionWithSounds).findFirst();

                    //If detect something magic nearby, it sounds
                    if(this.witcherMedallionsMod$getHasMagicMobNear() || this.witcherMedallionsMod$getHasStrongMagicNear()){

                        if(medallionStackOffhand.isPresent() && medallionStackOffhand.get().getItem() instanceof ActivedMedallionBaseItem medallion && Minecraft.getInstance().player!=null){

                            Minecraft.getInstance().player.playNotifySound(
                                    this.witcherMedallionsMod$getHasStrongMagicNear()?
                                            medallion.getStrongAnimalSound():
                                            medallion.getAnimalSound(), SoundSource.PLAYERS, 1, 1);

                        } else if (medallionStack.isPresent() && medallionStack.get().getItem() instanceof ActivedMedallionBaseItem medallion && Minecraft.getInstance().player!=null) {

                            Minecraft.getInstance().player.playNotifySound(
                                    this.witcherMedallionsMod$getHasStrongMagicNear()?
                                            medallion.getStrongAnimalSound():
                                            medallion.getAnimalSound(), SoundSource.PLAYERS, 1, 1);
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
