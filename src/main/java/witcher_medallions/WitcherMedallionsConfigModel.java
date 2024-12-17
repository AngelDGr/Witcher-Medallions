package witcher_medallions;

import io.wispforest.owo.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@Modmenu(modId = WitcherMedallions_Main.MOD_ID)
@Config(name = "witchermedallions-config", wrapperName = "WitcherMedallionsConfig")
public class WitcherMedallionsConfigModel {
    public List<String> MobList = new ArrayList<>(List.of
            (
             //HostileMobs
                    "minecraft:blaze",
                    "minecraft:cave_spider",
                    "minecraft:creeper",
                    "minecraft:drowned",
                    "minecraft:elder_guardian",
                    "minecraft:ender_dragon",
                    "minecraft:end_crystal",
                    "minecraft:ender_pearl",
                    "minecraft:enderman",
                    "minecraft:endermite",
                    "minecraft:evoker_fangs",
                    "minecraft:evoker",
                    "minecraft:eye_of_ender",
                    "minecraft:ghast",
                    "minecraft:giant",
                    "minecraft:guardian",
                    "minecraft:husk",
                    "minecraft:ravager",
                    "minecraft:illusioner",
                    "minecraft:magma_cube",
                    "minecraft:phantom",
                    "minecraft:potion",
                    "minecraft:shulker",
                    "minecraft:shulker_bullet",
                    "minecraft:silverfish",
                    "minecraft:skeleton",
                    "minecraft:skeleton_horse",
                    "minecraft:slime",
                    "minecraft:snow_golem",
                    "minecraft:spectral_arrow",
                    "minecraft:spider",
                    "minecraft:stray",
                    "minecraft:strider",
                    "minecraft:vex",
                    "minecraft:iron_golem",
                    "minecraft:witch",
                    "minecraft:wither",
                    "minecraft:wither_skeleton",
                    "minecraft:wither_skull",

                    "minecraft:piglin_brute",
                    "minecraft:piglin",

                    "minecraft:experience_bottle",
                    "minecraft:experience_orb",
                    "minecraft:zoglin",
                    "minecraft:zombie",
                    "minecraft:zombie_horse",
                    "minecraft:zombified_piglin",
                    "minecraft:zombie_villager",
                    //1.19 Mobs
                    "minecraft:allay",
                    "minecraft:warden",

                    //The Conjunction of the Spheres
                        //Necrophages
                        "tcots-witcher:drowner",
                        "tcots-witcher:ghoul",
                        "tcots-witcher:alghoul",
                        "tcots-witcher:rotfiend",
                        "tcots-witcher:foglet",
                        "tcots-witcher:water_hag",
                        "tcots-witcher:grave_hag",
                        "tcots-witcher:scurver",
                        "tcots-witcher:devourer",
                        "tcots-witcher:graveir",
                        "tcots-witcher:bullvore",

                    //Ogroids
                        "tcots-witcher:nekker",
                        "tcots-witcher:nekker_warrior",
                        "tcots-witcher:cyclops",
                        "tcots-witcher:rock_troll",
                        "tcots-witcher:ice_troll",
                        "tcots-witcher:forest_troll",
                        "tcots-witcher:ice_giant",

                    //MythicMobs Mod
                    "mythicmobs:automaton",
                    "mythicmobs:mushroom_thing",
                    "mythicmobs:drake",
                    "mythicmobs:chupacabra"
            )
    );

    public List<String> StrongMagicSourcesList = new ArrayList<>(List.of
            (
                    //MagicBlocks
                    "minecraft:enchanting_table",
                        //End
                        "minecraft:end_portal_frame",
                        "minecraft:end_portal",
                        "minecraft:ender_chest",
                        "minecraft:dragon_egg",

                    "minecraft:nether_portal",

                        //Soul
                        "minecraft:soul_sand",
                        "minecraft:soul_fire",
                        "minecraft:soul_torch",
                        "minecraft:soul_lantern",
                        "minecraft:soul_campfire",
                        //Amethyst
                        "minecraft:budding_amethyst",
                        //Sculk
                        "minecraft:sculk",
                        "minecraft:sculk_vein",
                        "minecraft:sculk_catalyst",
                        "minecraft:sculk_shrieker",
                        "minecraft:sculk_sensor",
                        "minecraft:calibrated_sculk_sensor",

                    "minecraft:beacon",
                    "minecraft:conduit",
                    "minecraft:respawn_anchor",
                    "minecraft:spawner",

                    //StrongEntities
                    "minecraft:wither",
                    "minecraft:ender_dragon",
                    "minecraft:elder_guardian",
                    "minecraft:warden",

                    "tcots-witcher:graveir",
                    "tcots-witcher:bullvore",
                    "tcots-witcher:ice_giant"
            )
    );

    public int activeDetectionSize = 35;
    public int passiveDetectionXZ = 15;
    public int passiveDetectionY = 4;
    public int StrongpassiveDetectionXZ = 20;
    public int StrongpassiveDetectionY = 8;
    public boolean StrongDetectionForBlocks = true;
    public boolean medallionSounds = true;
    public boolean medallionsHaveSoulbound = true;
}