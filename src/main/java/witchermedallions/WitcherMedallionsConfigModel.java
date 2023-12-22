package witchermedallions;

import io.wispforest.owo.config.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Modmenu(modId = witcherMod.MODID)
@Config(name = "witchermedallions-config", wrapperName = "WitcherMedallionsConfig")
public class WitcherMedallionsConfigModel {
    public List<String> MobList = new ArrayList<>(List.of
            (
             //HostileMobs
                    "entity.minecraft.blaze",
                    "entity.minecraft.cave_spider",
                    "entity.minecraft.creeper",
                    "entity.minecraft.drowned",
                    "entity.minecraft.elder_guardian",
                    "entity.minecraft.ender_dragon",
                    "entity.minecraft.end_crystal",
                    "entity.minecraft.ender_pearl",
                    "entity.minecraft.enderman",
                    "entity.minecraft.endermite",
                    "entity.minecraft.evoker_fangs",
                    "entity.minecraft.evoker",
                    "entity.minecraft.eye_of_ender",
                    "entity.minecraft.ghast",
                    "entity.minecraft.giant",
                    "entity.minecraft.guardian",
                    "entity.minecraft.husk",
                    "entity.minecraft.ravager",
                    "entity.minecraft.illusioner",
                    "entity.minecraft.magma_cube",
                    "entity.minecraft.phantom",
                    "entity.minecraft.potion",
                    "entity.minecraft.shulker",
                    "entity.minecraft.shulker_bullet",
                    "entity.minecraft.silverfish",
                    "entity.minecraft.skeleton",
                    "entity.minecraft.skeleton_horse",
                    "entity.minecraft.slime",
                    "entity.minecraft.snow_golem",
                    "entity.minecraft.spectral_arrow",
                    "entity.minecraft.spider",
                    "entity.minecraft.stray",
                    "entity.minecraft.strider",
                    "entity.minecraft.vex",
                    "entity.minecraft.iron_golem",
                    "entity.minecraft.witch",
                    "entity.minecraft.wither",
                    "entity.minecraft.wither_skeleton",
                    "entity.minecraft.wither_skull",

                    "entity.minecraft.experience_bottle",
                    "entity.minecraft.experience_orb",
                    "entity.minecraft.zoglin",
                    "entity.minecraft.zombie",
                    "entity.minecraft.zombie_horse",
                    "entity.minecraft.zombified_piglin",
                    "entity.minecraft.zombie_villager",
                    //1.19 Mobs
                    "entity.minecraft.allay",
                    "entity.minecraft.warden",

                    //MythicMobs Mod
                    "entity.mythicmobs.automaton",
                    "entity.mythicmobs.mushroom_thing",
                    "entity.mythicmobs.drake",
                    "entity.mythicmobs.chupacabra"
            )
    );

    public List<String> StrongMagicSourcesList = new ArrayList<>(List.of
            (
                    //MagicBlocks
                    "block.minecraft.enchanting_table",
                        //End
                        "block.minecraft.end_portal_frame",
                        "block.minecraft.end_portal",
                        "block.minecraft.ender_chest",
                        "block.minecraft.dragon_egg",

                    "block.minecraft.nether_portal",

                        //Soul
                        "block.minecraft.soul_sand",
                        "block.minecraft.soul_fire",
                        "block.minecraft.soul_torch",
                        "block.minecraft.soul_lantern",
                        "block.minecraft.soul_campfire",
                        //Amethyst
                        "block.minecraft.budding_amethyst",
                        //Sculk
                        "block.minecraft.sculk",
                        "block.minecraft.sculk_vein",
                        "block.minecraft.sculk_catalyst",
                        "block.minecraft.sculk_shrieker",
                        "block.minecraft.sculk_sensor",
                        "block.minecraft.calibrated_sculk_sensor",

                    "block.minecraft.beacon",
                    "block.minecraft.conduit",
                    "block.minecraft.respawn_anchor",
                    "block.minecraft.spawner",

                    //StrongEntities
                    "entity.minecraft.wither",
                    "entity.minecraft.ender_dragon",
                    "entity.minecraft.elder_guardian",
                    "entity.minecraft.warden"

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