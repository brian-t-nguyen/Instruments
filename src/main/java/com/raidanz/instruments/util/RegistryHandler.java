package com.raidanz.instruments.util;

import com.raidanz.instruments.Instruments;
import com.raidanz.instruments.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Instruments.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    // Items
    public static final RegistryObject<Item> GUITAR = ITEMS.register("guitar", ItemBase::new);
    public static final RegistryObject<Item> DRUM_KIT = ITEMS.register("drum_kit", ItemBase::new);
}
