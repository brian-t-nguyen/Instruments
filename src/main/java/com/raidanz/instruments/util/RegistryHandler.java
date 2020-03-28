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

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, InstrumentsMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Sounds
    public static ResourceLocation location = new ResourceLocation("instruments", "sound_guitar_a");
    public static SoundEvent soundGuitarA = new SoundEvent(location);
    // Items
    public static final RegistryObject<Item> GUITAR = ITEMS.register("guitar", Instrument.Guitar::new);
    public static final RegistryObject<Item> DRUM_KIT = ITEMS.register("drum_kit", Instrument.DrumKit::new);
}
