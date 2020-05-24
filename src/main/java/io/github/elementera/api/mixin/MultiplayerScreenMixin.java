package io.github.elementera.api.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.elementera.api.config.Config.getProperties;

@Mixin(MultiplayerScreen.class)
@Environment(EnvType.CLIENT)
public abstract class MultiplayerScreenMixin extends Screen {
    @Shadow public abstract void render(MatrixStack matrices, int mouseX, int mouseY, float delta);

    /**
     * @author baka4n
     */
    @Inject(method = "render", at = @At("RETURN"))
    protected void render(MatrixStack m, int mouseX, int mouseY, float f, CallbackInfo info) {
        if (getProperties("titleScreen_mouseY_hide").equals("no")) a(m, "mouseX", mouseX, 5);
        if (getProperties("titleScreen_mouseY_hide").equals("no")) a(m, "mouseY", mouseY, 5 + textRenderer.fontHeight);
    }

    public MultiplayerScreenMixin() {
        super(new TranslatableText("multiplayer.title", new Object[0]));
    }

    private void a(MatrixStack m, String s,int k, int y) { this.textRenderer.draw(m, I18n.translate(s)+":" + k , 5, y, 0xFFFFFFFF); }
}
