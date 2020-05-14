package io.github.elementera.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.*;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.*;

import java.util.List;

import static io.github.elementera.config.Config.getProperties;

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
     * @reason import for minecraft add mouseX and mouseY
     */
    @Overwrite
    public void render(MatrixStack m, int X, int Y, float delta) {
        this.tooltipText = null;
        this.levelList.render(m, X, Y, delta);
        this.searchBox.render(m, X, Y, delta);
        this.drawCenteredText(m, this.textRenderer, this.title, this.width / 2, 8, 16777215);
        if (getProperties("titleScreen_mouseY_hide").equals("no")) a(m, "mouseX", X, 5);
        if (getProperties("titleScreen_mouseY_hide").equals("no")) a(m, "mouseY", Y, 5 + textRenderer.fontHeight);
        super.render(m, X, Y, delta);
        if (this.tooltipText != null) {
            this.renderTooltip(m, this.tooltipText, X, Y);
        }
    }
    private void a(MatrixStack m, String s,int k, int y) { this.textRenderer.draw(m, I18n.translate(s)+":" + k , 5, y, 0xFFFFFFFF); }
}
