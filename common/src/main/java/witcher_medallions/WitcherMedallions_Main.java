package witcher_medallions;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class WitcherMedallions_Main {
    //Data initializer
    public static final String MOD_ID = "witcher_medallions";
    public static final Logger LOGGER = LoggerFactory.getLogger("witcher_medallions");
    //Data initializer
    public static final witcher_medallions.WitcherMedallionsConfig CONFIG = witcher_medallions.WitcherMedallionsConfig.createAndLoad();

    //Dynamic Recipes
    public static JsonObject WOLF_MEDALLION_OFF_RPG=null;
    public static JsonObject CAT_MEDALLION_OFF_RPG=null;
    public static JsonObject BEAR_MEDALLION_OFF_RPG=null;
    public static JsonObject GRIFFIN_MEDALLION_OFF_RPG=null;
    public static JsonObject VIPER_MEDALLION_OFF_RPG=null;
    public static JsonObject MANTICORE_MEDALLION_OFF_RPG=null;
    public static JsonObject ANCIENT_WOLF_MEDALLION_OFF_RPG=null;
    public static List<Tuple<ResourceLocation, JsonObject>> recipes= new ArrayList<>();


    public static void init() {
    }

    public static JsonObject create(String addition, String medallion, String base, boolean isTag){
        JsonObject mainJson = new JsonObject();

        //Type
        mainJson.addProperty("type", "minecraft:smithing_transform");

        //Addition
        JsonObject additionJson = new JsonObject();
        additionJson.addProperty(isTag?"tag": "item", addition);
        mainJson.add("addition", additionJson);

        //Base
        JsonObject baseJson = new JsonObject();
        baseJson.addProperty("item", base);
        mainJson.add("base", baseJson);

        //Result
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("id", medallion);
        jsonobject.addProperty("count", 1);
        mainJson.add("result", jsonobject);

        //Template
        JsonObject templateJson = new JsonObject();
        templateJson.addProperty("item", BuiltInRegistries.ITEM.getKey(Items.CHAIN).toString());
        mainJson.add("template", templateJson);

        return mainJson;
    }

    public static JsonObject create(String addition, Item medallion, String base, boolean isTag){
        return create(addition, BuiltInRegistries.ITEM.getKey(medallion).toString(), base, isTag);
    }

}