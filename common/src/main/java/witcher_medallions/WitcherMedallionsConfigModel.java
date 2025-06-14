package witcher_medallions;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;

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

                    //1.21 Mobs
                    "minecraft:bogged",
                    "minecraft:breeze",

                    //1.21.4 Mobs
                    "minecraft:creaking",

                    //The Conjunction of the Spheres
                        //Necrophages
                        "tcots_witcher:drowner",
                        "tcots_witcher:ghoul",
                        "tcots_witcher:alghoul",
                        "tcots_witcher:rotfiend",
                        "tcots_witcher:foglet",
                        "tcots_witcher:water_hag",
                        "tcots_witcher:grave_hag",
                        "tcots_witcher:scurver",
                        "tcots_witcher:devourer",
                        "tcots_witcher:graveir",
                        "tcots_witcher:bullvore",

                    //Ogroids
                        "tcots_witcher:nekker",
                        "tcots_witcher:nekker_warrior",
                        "tcots_witcher:cyclops",
                        "tcots_witcher:rock_troll",
                        "tcots_witcher:ice_troll",
                        "tcots_witcher:forest_troll",
                        "tcots_witcher:ice_giant",


                    //Fantasy MC
                    "enderscape:drifter",
                    "enderscape:driftlet",
                    "enderscape:rubblemite",
                    "enderscape:rustle",

                    "affinity:inert_wisp",
                    "affinity:wise_wisp",
                    "affinity:vicious_wisp",

                    "loot_n_explore:frost_haunt",
                    "loot_n_explore:glaze",
                    "loot_n_explore:frost_monarch",

                    "friendsandfoes:copper_golem",
                    "friendsandfoes:glare",
                    "friendsandfoes:iceologer",
                    "friendsandfoes:illusioner",
                    "friendsandfoes:mauler",
                    "friendsandfoes:tuff_golem",
                    "friendsandfoes:rascal",
                    "friendsandfoes:wildfire",

                    "the_bumblezone:honey_slime",
                    "the_bumblezone:rootmin",

                    "variantsandventures:gelid",
                    "variantsandventures:murk",
                    "variantsandventures:thicket",
                    "variantsandventures:verdant",

                    "adventurez:blackstone_golem",
                    "adventurez:mini_blackstone_golem",
                    "adventurez:piglin_beast",
                    "adventurez:soul_reaper",
                    "adventurez:necromancer",
                    "adventurez:wither_puppet",
                    "adventurez:skeleton_vanguard",
                    "adventurez:summoner",
                    "adventurez:blaze_guardian",
                    "adventurez:the_eye",
                    "adventurez:void_shadow",
                    "adventurez:void_shade",
                    "adventurez:amethyst_golem",
                    "adventurez:shaman",
                    "adventurez:enderwarthog",
                    "adventurez:red_fungus",
                    "adventurez:brown_fungus",
                    "adventurez:nightmare",
                    "adventurez:dragon",
                    "adventurez:ender_whale",
                    "adventurez:void_fragment",

                    "artifacts:mimic",

                    "biomeswevegone:pumpkin_warden",
                    "biomeswevegone:oddion",

                    "deeperdarker:sculk_centipede",
                    "deeperdarker:sculk_leech",
                    "deeperdarker:sculk_snapper",
                    "deeperdarker:shattered",
                    "deeperdarker:shriek_worm",
                    "deeperdarker:sludge",
                    "deeperdarker:stalker",

                    "eternal_starlight:astral_golem",
                    "eternal_starlight:gleech",
                    "eternal_starlight:lonestar_skeleton",
                    "eternal_starlight:nightfall_spider",
                    "eternal_starlight:thirst_walker",
                    "eternal_starlight:creteor",
                    "eternal_starlight:tiny_creteor",
                    "eternal_starlight:stranghoul",
                    "eternal_starlight:ent",
                    "eternal_starlight:zombified_ratlin",
                    "eternal_starlight:yeti",
                    "eternal_starlight:aurora_deer",
                    "eternal_starlight:crystallized_moth",
                    "eternal_starlight:shimmer_lacewing",
                    "eternal_starlight:grimstone_golem",
                    "eternal_starlight:aethersent_golem",
                    "eternal_starlight:freeze",
                    "eternal_starlight:tangled",
                    "eternal_starlight:tangled_skull",
                    "eternal_starlight:tangled_hatred",

                    "frostiful:frostologer",
                    "frostiful:biter",

                    "hexblade:magus",

                    "hyrule_terrors:bokoblin",
                    "hyrule_terrors:lizalfos",
                    "hyrule_terrors:chuchu",
                    "hyrule_terrors:keese",

                    "illagerinvasion:sorcerer",
                    "illagerinvasion:archivist",
                    "illagerinvasion:invoker",
                    "illagerinvasion:alchemist",
                    "illagerinvasion:firecaller",
                    "illagerinvasion:necromancer",
                    "illagerinvasion:surrendered",

                    "impillagers:zombie_impillager",
                    "impillagers:dung_golem",

                    "knightquest:gremlin",
                    "knightquest:eldknight",
                    "knightquest:eldbomb",
                    "knightquest:samhain",
                    "knightquest:swampman",
                    "knightquest:fallen_knight",
                    "knightquest:ratman",
                    "knightquest:bad_patch",
                    "knightquest:ghosty",
                    "knightquest:ghastling",
                    "knightquest:netherman",

                    "mobs_of_mythology:automaton",
                    "mobs_of_mythology:chupacabra",
                    "mobs_of_mythology:drake",
                    "mobs_of_mythology:sporeling",
                    "mobs_of_mythology:basilisk",
                    "mobs_of_mythology:pegasus",

                    "mutantmonsters:creeper_minion",
                    "mutantmonsters:mutant_creeper",
                    "mutantmonsters:mutant_enderman",
                    "mutantmonsters:mutant_skeleton",
                    "mutantmonsters:mutant_snow_golem",
                    "mutantmonsters:mutant_zombie",
                    "mutantmonsters:spider_pig",

                    "oblivion:elysian_elk",
                    "oblivion:elysian_shaman",
                    "oblivion:elysian_wolf",
                    "oblivion:treeder",
                    "oblivion:shroom",

                    "rpg-minibosses:minor_archmage_fire",
                    "rpg-minibosses:archmage_fire",
                    "rpg-minibosses:magus"
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

                    "illagerinvasion:magic_fire",

                    //StrongEntities
                        //Vanilla
                        "minecraft:wither",
                        "minecraft:ender_dragon",
                        "minecraft:elder_guardian",
                        "minecraft:warden",

                        //The Conjunction of the Spheres
                        "tcots_witcher:graveir",
                        "tcots_witcher:bullvore",
                        "tcots_witcher:ice_giant",

                        //Fantasy MC
                        "adventurez:blackstone_golem",
                        "adventurez:the_eye",
                        "adventurez:void_shadow",

                        "deeperdarker:stalker",

                        "frostiful:frostologer",

                        "hexblade:magus",

                        "illagerinvasion:invoker",

                        "knightquest:netherman",

                        "rpg-minibosses:magus"
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