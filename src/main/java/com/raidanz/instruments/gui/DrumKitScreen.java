package com.raidanz.instruments.gui;

import com.raidanz.instruments.util.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class DrumKitScreen extends InstrumentScreen {
    World world = Minecraft.getInstance().world;
    PlayerEntity playerEntity = Minecraft.getInstance().player;

    public DrumKitScreen() {
        super("drum_kit");
    }

    public boolean keyPressed(int glfw, int ascii, int modifier) {
        switch (glfw){
            case GLFW.GLFW_KEY_ESCAPE: close(playerEntity);
                break;
            case GLFW.GLFW_KEY_X: world.playSound(playerEntity, new BlockPos(playerEntity.getPositionVector()), RegistryHandler.drum_hat_closed, SoundCategory.VOICE, 1.0f, 1.0f);
                break;
            case GLFW.GLFW_KEY_Z: world.playSound(playerEntity, new BlockPos(playerEntity.getPositionVector()), RegistryHandler.drum_hat_open, SoundCategory.VOICE, 1.0f, 1.0f);
                break;
            case GLFW.GLFW_KEY_D: world.playSound(playerEntity, new BlockPos(playerEntity.getPositionVector()), RegistryHandler.drum_toms, SoundCategory.VOICE, 1.0f, 1.0f);
                break;
            case GLFW.GLFW_KEY_F: world.playSound(playerEntity, new BlockPos(playerEntity.getPositionVector()), RegistryHandler.drum_toms, SoundCategory.VOICE, 1.0f, 0.93f);
                break;
            case GLFW.GLFW_KEY_G: world.playSound(playerEntity, new BlockPos(playerEntity.getPositionVector()), RegistryHandler.drum_toms, SoundCategory.VOICE, 1.0f, 0.86f);
                break;
            case GLFW.GLFW_KEY_H: world.playSound(playerEntity, new BlockPos(playerEntity.getPositionVector()), RegistryHandler.drum_toms, SoundCategory.VOICE, 1.0f, 0.79f);
                break;
            case GLFW.GLFW_KEY_B: world.playSound(playerEntity, new BlockPos(playerEntity.getPositionVector()), RegistryHandler.drum_kick, SoundCategory.VOICE, 1.0f, 1.0f);
                break;
            case GLFW.GLFW_KEY_C: world.playSound(playerEntity, new BlockPos(playerEntity.getPositionVector()), RegistryHandler.drum_snare, SoundCategory.VOICE, 1.0f, 1.0f);
                break;
            case GLFW.GLFW_KEY_T: world.playSound(playerEntity, new BlockPos(playerEntity.getPositionVector()), RegistryHandler.drum_crash, SoundCategory.VOICE, 1.0f, 1.0f);

        }

        return true;
    }

    public static void open(){
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.deferTask(() -> minecraft.displayGuiScreen(new DrumKitScreen()));
    }
}
