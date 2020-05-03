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
public abstract class MultiplayerScreenMixin extends Screen {
    @Shadow public abstract void render(MatrixStack matrices, int mouseX, int mouseY, float delta);

    /**
     * @author baka4n
     */
    @Inject(method = "render", at = @At("RETURN"))
    protected void render(MatrixStack m, int mouseX, int mouseY, float f, CallbackInfo info) {
        a(m, "mouseX", mouseX, 5, 5, 0xFFFFFFFF);
        a(m, "mouseY", mouseY, 5, 5 + textRenderer.fontHeight, 0xFFFFFFFF);
    }

    public MultiplayerScreenMixin() {
        super(new TranslatableText("multiplayer.title", new Object[0]));
    }

    private void a(MatrixStack m, String s,int k, int x, int y, int c) { this.textRenderer.draw(m, I18n.translate(s)+":" + k , x, y, c); }
}
