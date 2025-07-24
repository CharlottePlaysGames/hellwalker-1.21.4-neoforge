package com.jinxedstudios.hellwalker.sounds;

import com.jinxedstudios.hellwalker.Hellwalker;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HellwalkerSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Hellwalker.MODID);

    public static final Supplier<SoundEvent> POSSESSED_SCIENTIST_SAY = registerSoundEvent("possessed_scientist_say");
    public static final Supplier<SoundEvent> POSSESSED_SCIENTIST_HURT = registerSoundEvent("possessed_scientist_hurt");
    public static final Supplier<SoundEvent> POSSESSED_SCIENTIST_DEATH = registerSoundEvent("possessed_scientist_death");
    public static final Supplier<SoundEvent> POSSESSED_SCIENTIST_STEP = registerSoundEvent("possessed_scientist_step");

    // Doom 2016 soundtrack tracks
    public static final Supplier<SoundEvent> DOOM_1_DOGMA = registerSoundEvent("dogma");
    public static final Supplier<SoundEvent> DOOM_2_RIP_AND_TEAR = registerSoundEvent("rip_and_tear");
    public static final Supplier<SoundEvent> DOOM_3_AT_DOOMS_GATE = registerSoundEvent("at_dooms_gate");
    public static final Supplier<SoundEvent> DOOM_4_RUST_DUST_AND_GUTS = registerSoundEvent("rust_dust_and_guts");
    public static final Supplier<SoundEvent> DOOM_5_DEMIGOD = registerSoundEvent("demigod");
    public static final Supplier<SoundEvent> DOOM_6_HELLWALKER = registerSoundEvent("hellwalker");
    public static final Supplier<SoundEvent> DOOM_7_AUTHORIZATION_OLIVIA_PIERCE = registerSoundEvent("authorization_olivia_pierce");
    public static final Supplier<SoundEvent> DOOM_8_FLESH_AND_METAL = registerSoundEvent("flesh_and_metal");
    public static final Supplier<SoundEvent> DOOM_9_IMPURE_SPECTRUM = registerSoundEvent("impure_spectrum");
    public static final Supplier<SoundEvent> DOOM_10_TIES_THAT_BIND = registerSoundEvent("ties_that_bind");
    public static final Supplier<SoundEvent> DOOM_11_BFG_DIVISION = registerSoundEvent("bfg_division");
    public static final Supplier<SoundEvent> DOOM_12_RESIDUAL = registerSoundEvent("residual");
    public static final Supplier<SoundEvent> DOOM_13_ARGENT_ENERGY = registerSoundEvent("argent_energy");
    public static final Supplier<SoundEvent> DOOM_14_HARBINGER = registerSoundEvent("harbinger");
    public static final Supplier<SoundEvent> DOOM_15_BIOWAVES = registerSoundEvent("biowaves");
    public static final Supplier<SoundEvent> DOOM_CREDITS = registerSoundEvent("credits");
    public static final Supplier<SoundEvent> DOOM_17_TRANSISTOR_FIST = registerSoundEvent("transistor_fist");
    public static final Supplier<SoundEvent> DOOM_18_DR_SAMUEL_HAYDEN = registerSoundEvent("dr_samuel_hayden");
    public static final Supplier<SoundEvent> DOOM_19_CYBERDEMON = registerSoundEvent("cyberdemon");
    public static final Supplier<SoundEvent> DOOM_20_INCANTATION = registerSoundEvent("incantation");
    public static final Supplier<SoundEvent> DOOM_21_DAKHMA = registerSoundEvent("dakhma");
    public static final Supplier<SoundEvent> DOOM_22_DAMNATION = registerSoundEvent("damnation");
    public static final Supplier<SoundEvent> DOOM_23_THE_STENCH = registerSoundEvent("the_stench");
    public static final Supplier<SoundEvent> DOOM_24_UAC_REPORT_FILE_SHTO36U3 = registerSoundEvent("uac_report_file_shto36u3");
    public static final Supplier<SoundEvent> DOOM_25_DEATH_AND_EXHALE = registerSoundEvent("death_and_exhale");
    public static final Supplier<SoundEvent> DOOM_26_SKULLHACKER = registerSoundEvent("skullhacker");
    public static final Supplier<SoundEvent> DOOM_27_LAZARUS_WAVES = registerSoundEvent("lazarus_waves");
    public static final Supplier<SoundEvent> DOOM_28_VEGA_CORE = registerSoundEvent("vega_core");
    public static final Supplier<SoundEvent> DOOM_29_6_IDKILL_VEGA_CIH = registerSoundEvent("vega_death");
    public static final Supplier<SoundEvent> DOOM_30_MASTERMIND = registerSoundEvent("mastermind");
    public static final Supplier<SoundEvent> DOOM_31_DOOM = registerSoundEvent("doom");


    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
