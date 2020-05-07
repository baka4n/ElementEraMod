package io.github.elementera.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.*;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.*;

import java.util.List;

@Mixin(SelectWorldScreen.class)
public class SelectWorldScreenMixin extends Screen {
    protected final Screen parent;
    @Shadow private List<Text> tooltipText;
    @Shadow private WorldListWidget levelList;
    @Shadow protected TextFieldWidget searchBox;

    public SelectWorldScreenMixin(Screen parent) {
        super(new TranslatableText("selectWorld.title", new Object[0]));
        this.parent = parent;
    }

    /**
     * @author baka4n
     * <p> minecraft render</p>
     * @param m
     * @param mouseX
     * @param mouseY
     * @param delta
     * @reason import for minecraft add mouseX and mouseY
     */
    @Overwrite
    public void render(MatrixStack m, int mouseX, int mouseY, float delta) {
        this.tooltipText = null;
        this.levelList.render(m, mouseX, mouseY, delta);
        this.searchBox.render(m, mouseX, mouseY, delta);
        this.drawCenteredText(m, this.textRenderer, this.title, this.width / 2, 8, 16777215);
        a(m, "mouseX", mouseX, 5, 5, 0xFFFFFFFF);
        a(m, "mouseY", mouseY, 5, 5 + textRenderer.fontHeight, 0xFFFFFFFF);
        super.render(m, mouseX, mouseY, delta);
        if (this.tooltipText != null) {
            this.renderTooltip(m, this.tooltipText, mouseX, mouseY);
        }
    }
    private void a(MatrixStack m, String s,int k, int x, int y, int c) { this.textRenderer.draw(m, I18n.translate(s)+":" + k , x, y, c); }
}
