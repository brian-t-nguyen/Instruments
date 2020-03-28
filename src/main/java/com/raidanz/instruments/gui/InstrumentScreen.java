package com.raidanz.instruments.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.raidanz.instruments.InstrumentsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InstrumentScreen extends Screen {
    private static final int WIDTH = 220;
    private static final int HEIGHT = 220;
    private ResourceLocation BACKGROUND_TEXTURE;
    private boolean showImage = true;
    public InstrumentScreen(String instrumentName) {
        super(new StringTextComponent("instrument gui"));
        BACKGROUND_TEXTURE = new ResourceLocation(InstrumentsMod.MOD_ID, "textures/gui/" +instrumentName +"_screen.png");
        System.out.println("textures/gui/" +instrumentName +"_screen");
    }
    protected void init() {
        showImage = true;
        addButton(new Button((this.width)-110, (this.height/2), 110, 20, "Toggle Image", button -> toggleShowImage()));
    }
    public void toggleShowImage(){
        showImage = !showImage;
    }

    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton){
        System.out.println(mouseButton);
        if (mouseButton == 1){
            close(Minecraft.getInstance().player);
        } else if (buttons.get(0).mouseClicked(mouseX, mouseY, mouseButton)){
            System.out.println(buttons.get(0).mouseClicked(mouseX, mouseY, mouseButton));
            toggleShowImage();
        }
        return true;
    }

    public void render(final int mouseX, final int mouseY, final float partialTicks){
        if (showImage){
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
        else{
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 0F);
        }

        this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int relX = (this.width - WIDTH) / 2;
        int relY = (this.height - HEIGHT) / 2;
        this.blit(relX, relY, 0, 0, WIDTH, HEIGHT);
        super.render(mouseX, mouseY, partialTicks);
    }
    public boolean isPauseScreen(){
        return false;
    }

    public static void open(String instrumentName){
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.deferTask(() -> minecraft.displayGuiScreen(new InstrumentScreen(instrumentName)));
    }
    public static void close(PlayerEntity playerIn){
        playerIn.closeScreen();
    }
}
