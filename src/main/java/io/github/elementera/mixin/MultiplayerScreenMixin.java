package io.github.elementera.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.TranslatableText;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin extends Screen {

    @Shadow
    private final Screen parent;

    /**
     * @ahthor baka4n
     * @param mouseX
     * @param mouseY
     * @param delta
     * @param info
     * @Nullable render  return mixin in call back info.
     */
    @Inject(method = "render", at = @At("RETURN"))
    @Nullable
    protected void render(int mouseX, int mouseY, float delta, CallbackInfo info) {
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        textRenderer.draw(I18n.translate("mouseX") + mouseX, 5, 5, 0xFFFFFFFF);
        textRenderer.draw(I18n.translate("mouseY") + mouseY, 5, 5 + textRenderer.fontHeight, 0xFFFFFFFF);
    }

    public MultiplayerScreenMixin(Screen parent) {
        super(new TranslatableText("multiplayer.title", new Object[0]));
        this.parent = parent;
    }
}
