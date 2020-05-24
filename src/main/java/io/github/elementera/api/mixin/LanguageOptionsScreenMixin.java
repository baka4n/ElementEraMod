package io.github.elementera.api.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.*;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.resource.language.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.elementera.api.config.Config.getProperties;

@Mixin(LanguageOptionsScreen.class)
@Environment(EnvType.CLIENT)
public class LanguageOptionsScreenMixin extends GameOptionsScreen {
    public LanguageOptionsScreenMixin(Screen parent, GameOptions options) {
        super(parent, options, new TranslatableText("options.language", new Object[0]));
    }
    public void tick() {}

    /**
     * @author baka4n
     */
    @Inject(at=@At("RETURN"), method = "init()V")
    protected void init(CallbackInfo info) {
    }
    /**
     * @author baka4n
     */
    @Inject(method = "render", at=@At("RETURN"))
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float f, CallbackInfo info) {
        if (getProperties("titleScreen_mouseY_hide").equals("no")) a(matrixStack, "mouseX", mouseX, 5);
        if (getProperties("titleScreen_mouseY_hide").equals("no")) a(matrixStack, "mouseY", mouseY, 5 + textRenderer.fontHeight);
    }
    private void a(MatrixStack m, String s,int k, int y) { this.textRenderer.draw(m, I18n.translate(s)+":" + k , 5, y, 0xFFFFFFFF); }
}
