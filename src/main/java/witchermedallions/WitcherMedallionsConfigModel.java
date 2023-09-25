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

    public int activeDetectionSize = 35;
    public int passiveDetectionXZ = 15;
    public int passiveDetectionY = 4;
    public boolean medallionSounds = true;
    public boolean medallionsHaveSoulbound = true;
}