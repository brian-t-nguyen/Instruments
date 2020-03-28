package com.raidanz.instruments.items;

import com.raidanz.instruments.InstrumentsMod;
import com.raidanz.instruments.gui.DrumKitScreen;
import com.raidanz.instruments.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// Instrument Properties
public class Instrument extends Item {
    private String name;
    public Instrument() {
        super(new Item.Properties().group(InstrumentsMod.InstrumentItemGroup.instance).maxStackSize(1));
        this.name = "base_instrument";
    }
    public Instrument(Properties properties) {
        super(properties.group(InstrumentsMod.InstrumentItemGroup.instance).maxStackSize(1));
        this.name = "base_instrument";
    }
    public String getInstrumentName() {
        return name;
    }

    // Guitar Class
    public static class Guitar extends Instrument {
        public Guitar(){
            super.name = "guitar";
        }
    }

    //Drum Kit Class
    public static class DrumKit extends Instrument {
        private boolean isPlaying = false;
        public DrumKit(){
            super.name = "drum_kit";
        }
        public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
            DrumKitScreen.open();
            return super.onItemRightClick(worldIn, playerIn, handIn);
        }
    }
}
