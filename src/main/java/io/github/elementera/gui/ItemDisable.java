package io.github.elementera.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

public class ItemDisable extends Screen {
    private final Screen screen;
    protected ItemDisable(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    @Override
    public void render(MatrixStack matrixStack, int mouseY, int i, float f) {
        renderBackground(matrixStack, i);
        super.render(matrixStack, mouseY, i, f);
        super.init();
    }
    @Override
    protected void init() {
        this.addButton(new ButtonWidget( 10, 10, 200, 20,
                new TranslatableText("hydrogen.disable.all"),
                (buttonWidget) -> MinecraftClient.getInstance().openScreen(new HydrogenGui(this))));
        this.addButton(new ButtonWidget(10, 40, 200, 20,
                new TranslatableText("helium.disable.all"),
                (buttonWidget) -> MinecraftClient.getInstance().openScreen(new HeliumGui(this))));
    }
}
