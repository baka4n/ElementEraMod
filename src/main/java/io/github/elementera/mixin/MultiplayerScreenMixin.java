package io.github.elementera.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin extends Screen {

    @Shadow
    private final Screen parent;

    /**
     *
     * @param matrixStack
     * @param mouseY
     * @param i
     * @param f
     * @param info
     */
    @Inject(method = "render", at = @At("RETURN"))
    protected void render(MatrixStack matrixStack, int mouseY, int i, float f, CallbackInfo info) {
        textRenderer.draw(matrixStack, I18n.translate("mouseX") + ": " + mouseY, 5, 5, 0xFFFFFFFF);
        textRenderer.draw(matrixStack, I18n.translate("mouseY") + ": " + i, 5, 5 + textRenderer.fontHeight, 0xFFFFFFFF);
        super.render(matrixStack, mouseY, i, f);
    }

    public MultiplayerScreenMixin(Screen parent) {
        super(new TranslatableText("multiplayer.title", new Object[0]));
        this.parent = parent;
    }
}
