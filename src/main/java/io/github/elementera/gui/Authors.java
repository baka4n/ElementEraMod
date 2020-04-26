package io.github.elementera.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.*;
import org.apache.logging.log4j.*;

public class Authors extends Screen {

    public Logger logger= LogManager.getLogger("test");
    //Authors info
    private Screen screen;
    public Authors(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }

    @Override
    protected void init() {
        super.init();
        logger.warn(I18n.translate("info.authors"));
        this.addButton(new ButtonWidget(3 * this.width / 4,
                8 * this.height / 9,
                100,
                20,
                new TranslatableText("authors.back"), (action) -> {
            logger.warn(I18n.translate("close.authors"));
            this.screen.onClose();
        }));
    }
    @Override
    public void render(MatrixStack matrixStack, int mouseY, int i, float f) {
        renderBackground(matrixStack, i);
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        textRenderer.draw(matrixStack, I18n.translate("mouseX") + ": " + mouseY, 5, 5, 0xFFFFFFFF);
        textRenderer.draw(matrixStack, I18n.translate("mouseY") + ": " + i, 5, 5 + textRenderer.fontHeight, 0xFFFFFFFF);
        renderTooltip(matrixStack, new TranslatableText("authors.info"), this.width / 100, this.height / 6);
        renderTooltip(matrixStack, new TranslatableText("baka4n"), 21 * this.width / 100, this.height / 6);
        renderTooltip(matrixStack, new TranslatableText("squidCraft() -> Team"), 41 * this.width / 100, this.height / 6);
        super.render(matrixStack, mouseY, i, f);
    }
}
