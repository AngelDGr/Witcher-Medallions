package witcher_medallions;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import witcher_medallions.items.WitcherMedallions_ItemsCommon;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class WitcherMedallions_MainCommon {
    //Data initializer
    public static final String MOD_ID = "witcher_medallions";
    public static final Logger LOGGER = LoggerFactory.getLogger("witcher_medallions");

    //Dynamic Recipes
    public static JsonObject WOLF_MEDALLION_OFF_RPG=null;
    public static JsonObject CAT_MEDALLION_OFF_RPG=null;
    public static JsonObject BEAR_MEDALLION_OFF_RPG=null;
    public static JsonObject GRIFFIN_MEDALLION_OFF_RPG=null;
    public static JsonObject VIPER_MEDALLION_OFF_RPG=null;
    public static JsonObject MANTICORE_MEDALLION_OFF_RPG=null;
    public static JsonObject ANCIENT_WOLF_MEDALLION_OFF_RPG=null;
    public static List<Tuple<ResourceLocation, JsonObject>> recipes= new ArrayList<>();

    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.
    public static void init() {
        // It is common for all supported loaders to provide a similar feature that can not be used directly in the
        // common code. A popular way to get around this is using Java's built-in service loader feature to create
        // your own abstraction layer. You can learn more about this in our provided services class. In this example
        // we have an interface in the common code and use a loader specific implementation to delegate our call to
        // the platform specific approach.

        WitcherMedallions_ItemsCommon.registerItems();
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