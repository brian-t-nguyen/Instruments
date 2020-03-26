package com.raidanz.instruments;

import com.raidanz.instruments.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("instruments")
public class Instruments
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "instruments";
    public static Instruments instance;

    public Instruments() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
    public static class InstrumentItemGroup extends ItemGroup {
        public static final InstrumentItemGroup instance = new InstrumentItemGroup();

        private InstrumentItemGroup() {
            super("Instruments");
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.GUITAR.get());
        }

    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void guitarEvent(RegistryEvent.Register<Block> blockRegistryEvent) {
        }
    }
}
