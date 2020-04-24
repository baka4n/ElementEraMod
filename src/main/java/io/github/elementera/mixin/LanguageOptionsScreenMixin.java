package io.github.elementera.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.GameOptionsScreen;
import net.minecraft.client.gui.screen.options.LanguageOptionsScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.options.GameOptions;

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

    protected TextFieldWidget searchBox;

    public LanguageOptionsScreenMixin(Screen parent, GameOptions options, LanguageManager languageManager) {
        super(parent, options, new TranslatableText("options.language", new Object[0]));
        this.languageManager = languageManager;
    }

    public void tick() {
        this.searchBox.tick();
    }

    @Inject(at=@At("RETURN"), method = "init()V")
    protected void init(CallbackInfo info) {
        this.searchBox = new TextFieldWidget(this.textRenderer, this.width / 2 - 100, 6, 200, 20, this.searchBox, new TranslatableText("selectWorld.search"));

        this.children.add(this.searchBox);
        this.setInitialFocus(this.searchBox);

    }

    @Inject(method = "render", at=@At("RETURN"))
    public void render(MatrixStack matrixStack, int mouseY, int i, float f, CallbackInfo info) {
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return super.keyPressed(keyCode, scanCode, modifiers) ? true : this.searchBox.keyPressed(keyCode, scanCode, modifiers);
    }

    public boolean charTyped(char chr, int keyCode) {
        return this.searchBox.charTyped(chr, keyCode);
    }

}
