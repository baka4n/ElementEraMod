package io.github.elementera.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.GameOptionsScreen;
import net.minecraft.client.gui.screen.options.LanguageOptionsScreen;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.resource.language.LanguageManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LanguageOptionsScreen.class)
@Environment(EnvType.CLIENT)
public class LanguageOptionsScreenMixin extends GameOptionsScreen {

    @Shadow
    private final LanguageManager languageManager;


    public LanguageOptionsScreenMixin(Screen parent, GameOptions options, LanguageManager languageManager) {
        super(parent, options, new TranslatableText("options.language", new Object[0]));
        this.languageManager = languageManager;
    }

    public void tick() {}

    @Inject(at=@At("RETURN"), method = "init()V")
    protected void init(CallbackInfo info) {
    }

    /**
     *
     * @param matrixStack
     * @param mouseY
     * @param i
     * @param f
     * @param info
     */
    @Inject(method = "render", at=@At("RETURN"))
    public void render(MatrixStack matrixStack, int mouseY, int i, float f, CallbackInfo info) {
        textRenderer.draw(matrixStack, I18n.translate("mouseX") + ": " + mouseY, 5, 5, 0xFFFFFFFF);
        textRenderer.draw(matrixStack, I18n.translate("mouseY") + ": " + i, 5, 5 + textRenderer.fontHeight, 0xFFFFFFFF);
        super.render(matrixStack, mouseY, i, f);
    }

}
