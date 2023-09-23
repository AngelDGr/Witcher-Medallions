package witchermedallions.items.gecko.item.heads;

import net.minecraft.item.Item;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.InstancedAnimationFactory;

public class CatHeadItem extends Item implements IAnimatable {
    public AnimationFactory factory = new InstancedAnimationFactory(this);

    public CatHeadItem(Settings settings) {
        super(settings);
    }


    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
