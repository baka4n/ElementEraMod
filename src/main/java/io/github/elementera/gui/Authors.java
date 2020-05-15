package io.github.elementera.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.*;

import static io.github.elementera.config.Config.getProperties;
import static io.github.elementera.gui.ItemDisable.OpenGui;
@Environment(EnvType.CLIENT)
public class Authors extends Screen {
    public static org.apache.logging.log4j.Logger logger= org.apache.logging.log4j.LogManager.getLogger("test");
    private final Screen screen;
    public Authors(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) { this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress)); }
    @Override
    public void render(MatrixStack m, int X, int Y, float f) {
        renderBackground(m, X);
        if (getProperties("titleScreen_mouseY_hide").equals("no")) draw(m, "mouseX", "mouseY", X, Y, 5, 5, 0xFFFFFFFF);
        tooltip(m, "authors.info", 1, "baka4n", 21, "squidCraft() -> Team", 41);
        super.render(m, X, Y, f);super.init();
    }
    @Override
    protected void init() {
        logger.warn(I18n.translate("info.authors"));
        super.init();
        MYButton(3 * this.width / 4, 8 * this.height / 9, 100, 20, "authors.back", (buttonWidget) -> this.screen.onClose());
        MYButton(3 * this.width / 4, 8* this.height / 9 - 30, 100, 20, "config.edit", (buttonWidget) -> OpenGui(new ConfigEditGui(this)));
    }
    public void draw(MatrixStack m, String s1, String s2, int X, int Y, int x, int y, int c) {
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;textRenderer.draw(m, I18n.translate(s1) + ": " + X, x, y, c);
        textRenderer.draw(m, I18n.translate(s2) + ": " + Y, x, y + textRenderer.fontHeight, c);
    }
    public void tooltip(MatrixStack m, String s1, int X, String s2, int X2, String s3, int X3) {
        renderTooltip(m, new TranslatableText(s1), X * this.width / 100, this.height / 6);renderTooltip(m, new TranslatableText(s2), X2 * this.width / 100, this.height / 6);renderTooltip(m, new TranslatableText(s3), X3 * this.width / 100, this.height / 6);
    }
}
