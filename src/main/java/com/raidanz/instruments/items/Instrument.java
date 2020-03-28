package com.raidanz.instruments.items;

import com.raidanz.instruments.InstrumentsMod;
import com.raidanz.instruments.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// Instrument Properties
public class Instrument extends Item {
    public Instrument() {
        super(new Item.Properties().group(InstrumentsMod.InstrumentItemGroup.instance).maxStackSize(1));
    }
    public Instrument(Properties properties) {
        super(properties.group(InstrumentsMod.InstrumentItemGroup.instance).maxStackSize(1));
    }

    // Guitar Class
    public static class Guitar extends Instrument {
    }

    //Drum Kit Class
    public static class DrumKit extends Instrument {
        public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn){


            worldIn.playSound(playerIn, new BlockPos(playerIn.getPositionVector()), RegistryHandler.drum_hat_closed, SoundCategory.VOICE, 1.0f, 1.0f);
            playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 500, 5));
            return super.onItemRightClick(worldIn, playerIn, handIn);
        }
    }
}
