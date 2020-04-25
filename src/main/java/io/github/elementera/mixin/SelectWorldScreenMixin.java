package io.github.elementera.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SelectWorldScreen.class)
public class SelectWorldScreenMixin extends Screen {

    @Shadow
    protected final Screen parent;

    public SelectWorldScreenMixin(Screen parent) {
        super(new TranslatableText("selectWorld.title", new Object[0]));
        this.parent = parent;
    }
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
}
