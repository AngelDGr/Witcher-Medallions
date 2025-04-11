package witcher_medallions.items;

import net.minecraft.world.item.Item;
import software.bernie.geckolib.animatable.GeoItem;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public abstract class MedallionBaseItem_NeoForge extends Item implements GeoItem, ICurioItem{
    public MedallionBaseItem_NeoForge(Item.Properties settings) {
        super(settings);
    }
}
