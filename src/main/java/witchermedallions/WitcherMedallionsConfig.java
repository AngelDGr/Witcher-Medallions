package witchermedallions;

import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.util.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class WitcherMedallionsConfig extends ConfigWrapper<witchermedallions.WitcherMedallionsConfigModel> {

    private final Option<java.util.List<java.lang.String>> MobList = this.optionForKey(new Option.Key("MobList"));
    private final Option<java.lang.Integer> activeDetectionSize = this.optionForKey(new Option.Key("activeDetectionSize"));
    private final Option<java.lang.Integer> passiveDetectionXZ = this.optionForKey(new Option.Key("passiveDetectionXZ"));
    private final Option<java.lang.Integer> passiveDetectionY = this.optionForKey(new Option.Key("passiveDetectionY"));
    private final Option<java.lang.Boolean> medallionSounds = this.optionForKey(new Option.Key("medallionSounds"));

    private WitcherMedallionsConfig() {
        super(witchermedallions.WitcherMedallionsConfigModel.class);
    }

    public static WitcherMedallionsConfig createAndLoad() {
        var wrapper = new WitcherMedallionsConfig();
        wrapper.load();
        return wrapper;
    }

    public java.util.List<java.lang.String> MobList() {
        return MobList.value();
    }

    public void MobList(java.util.List<java.lang.String> value) {
        MobList.set(value);
    }

    public int activeDetectionSize() {
        return activeDetectionSize.value();
    }

    public void activeDetectionSize(int value) {
        activeDetectionSize.set(value);
    }

    public int passiveDetectionXZ() {
        return passiveDetectionXZ.value();
    }

    public void passiveDetectionXZ(int value) {
        passiveDetectionXZ.set(value);
    }

    public int passiveDetectionY() {
        return passiveDetectionY.value();
    }

    public void passiveDetectionY(int value) {
        passiveDetectionY.set(value);
    }

    public boolean medallionSounds() {
        return medallionSounds.value();
    }

    public void medallionSounds(boolean value) {
        medallionSounds.set(value);
    }




}

