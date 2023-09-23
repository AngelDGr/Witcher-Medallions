package witchermedallions.items.gecko.item.heads;

import net.minecraft.item.Item;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.InstancedAnimationFactory;

public class WolfHeadItem extends Item implements IAnimatable {
    public AnimationFactory factory = new InstancedAnimationFactory(this);

    public WolfHeadItem(Settings settings) {
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
