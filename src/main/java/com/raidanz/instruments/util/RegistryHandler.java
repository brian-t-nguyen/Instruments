package com.raidanz.instruments.util;

import com.raidanz.instruments.InstrumentsMod;
import com.raidanz.instruments.items.Instrument;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler<location> {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, InstrumentsMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Sounds
    public static ResourceLocation drum_hat_closed_path = new ResourceLocation("instruments", "drum_hat_closed");
    public static SoundEvent drum_hat_closed = new SoundEvent(drum_hat_closed_path);

    public static ResourceLocation drum_hat_open_path = new ResourceLocation("instruments", "drum_hat_open");
    public static SoundEvent drum_hat_open = new SoundEvent(drum_hat_open_path);

    public static ResourceLocation drum_toms_path = new ResourceLocation("instruments", "drum_toms");
    public static SoundEvent drum_toms = new SoundEvent(drum_toms_path);

    public static ResourceLocation drum_kick_path = new ResourceLocation("instruments", "drum_kick");
    public static SoundEvent drum_kick = new SoundEvent(drum_kick_path);

    public static ResourceLocation drum_snare_path = new ResourceLocation("instruments", "drum_snare");
    public static SoundEvent drum_snare = new SoundEvent(drum_snare_path);

    public static ResourceLocation drum_crash_path = new ResourceLocation("instruments", "drum_crash");
    public static SoundEvent drum_crash = new SoundEvent(drum_crash_path);
    // Items
    public static final RegistryObject<Item> GUITAR = ITEMS.register("guitar", Instrument.Guitar::new);
    public static final RegistryObject<Item> DRUM_KIT = ITEMS.register("drum_kit", Instrument.DrumKit::new);
}
