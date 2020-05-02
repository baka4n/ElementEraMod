package io.github.elementera.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

import static io.github.elementera.gui.Authors.logger;

public class ConfigEditGui extends Screen {
    private final Screen screen;
    protected ConfigEditGui(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float f) {
        renderBackground(matrixStack, mouseX);
        super.render(matrixStack, mouseX, mouseY, f);
        super.init();
    }
    @Override
    protected void init() {
        this.addButton(new ButtonWidget(3 * this.width / 4,
                8 * this.height / 9,
                100,
                20,
                new TranslatableText("authors.back"), (buttonWidget) -> {
            logger.warn(I18n.translate("close.authors"));
            this.screen.onClose();
        }));
        this.addButton(new ButtonWidget( 10, 10, 200, 20,
                new TranslatableText("items.disable"),
                (buttonWidget) -> MinecraftClient.getInstance().openScreen(new ItemDisable(this))));
    }
}
