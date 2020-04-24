package io.github.elementera.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.LiteralText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
                I18n.translate("authors.back"), (action) -> {
            logger.warn(I18n.translate("close.authors"));
            this.screen.onClose();
        }));
    }
    @Override
    public void render(int mouseX, int mouseY, float delta) {
        renderBackground();
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        textRenderer.draw(I18n.translate("mouseX") + mouseX, 5, 5, 0xFFFFFFFF);
        textRenderer.draw(I18n.translate("mouseY") + mouseY, 5, 5 + textRenderer.fontHeight, 0xFFFFFFFF);

        renderTooltip(I18n
                        .translate("authors.info"),
                this.width / 100,
                this.height / 6);
        renderTooltip("baka4n",
                21 * this.width / 100,
                this.height / 6);
        renderTooltip("squidCraft() -> Team",
                41 * this.width / 100,
                this.height / 6);
        super.render(mouseX, mouseY, delta);
    }
}
