package com.raidanz.instruments.items;

import com.raidanz.instruments.Instruments;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(Instruments.InstrumentItemGroup.instance));
    }
}
