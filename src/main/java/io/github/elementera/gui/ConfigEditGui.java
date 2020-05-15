package io.github.elementera.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.*;
import static io.github.elementera.gui.ItemDisable.OpenGui;
@Environment(EnvType.CLIENT)
public class ConfigEditGui extends Screen {
    private final Screen screen;
    protected ConfigEditGui(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) { this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress)); }
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float f) {
        renderBackground(matrixStack, mouseX);
        super.render(matrixStack, mouseX, mouseY, f);
        super.init();
    }
    @Override
    protected void init() {
        MYButton(3 * this.width / 4, 8 * this.height / 9, 100, 20, "authors.back", (buttonWidget) -> this.screen.onClose());
        MYButton(10, 10, 200, 20, "items.disable", (buttonWidget) -> OpenGui(new ItemDisable(this)));
    }
}
