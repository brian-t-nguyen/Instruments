package com.raidanz.instruments.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Keybinds {
    private static final long WINDOW = Minecraft.getInstance().getMainWindow().getHandle();
    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingKey(int key) {
        return InputMappings.isKeyDown(WINDOW, key) || InputMappings.isKeyDown(WINDOW, key);
    }
}
