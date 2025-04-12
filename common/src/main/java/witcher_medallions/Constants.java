package witcher_medallions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.animation.RawAnimation;

public class Constants {

	public static final String MOD_NAME = "Witcher Medallions";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static final RawAnimation SWING_ANIMATION = RawAnimation.begin().thenLoop("medallion_animation");
	public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
	public static final RawAnimation STRONG_ANIMATION = RawAnimation.begin().thenLoop("medallion_animation_strong");



    public static final String KEY_CATEGORY_MEDALLIONS = "key.category.witchermedallions.medallions";
    public static final String KEY_ACTIVE_MEDALLION = "key.witchermedallions.activemedallion";
	public static boolean outliningMonsters = false;
}