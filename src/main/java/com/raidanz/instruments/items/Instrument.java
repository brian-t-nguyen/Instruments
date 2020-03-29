package com.raidanz.instruments.items;

import com.raidanz.instruments.InstrumentsMod;
import com.raidanz.instruments.gui.DrumKitScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import java.util.List;

// Instrument Properties
public class Instrument extends Item {
    public Instrument() {
        super(new Item.Properties().group(InstrumentsMod.InstrumentItemGroup.instance).maxStackSize(1));
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A7b" +"Right click to Start/Stop playing"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    // Guitar Class
    public static class Guitar extends Instrument {
        public Guitar(){
            super();
        }
    }

    //Drum Kit Class
    public static class DrumKit extends Instrument {
        public DrumKit(){
            super();
        }

        public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
            DrumKitScreen.open();
            return super.onItemRightClick(worldIn, playerIn, handIn);
        }
    }
}
