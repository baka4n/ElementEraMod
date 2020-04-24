package io.github.elementera.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.util.math.MatrixStack;
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
     *
     * @param matrixStack
     * @param mouseY
     * @param i
     * @param f
     * @param info
     */
    @Inject(method = "render", at = @At("RETURN"))
    @Nullable
    protected void render(MatrixStack matrixStack, int mouseY, int i, float f, CallbackInfo info) {
    }

    public MultiplayerScreenMixin(Screen parent) {
        super(new TranslatableText("multiplayer.title", new Object[0]));
        this.parent = parent;
    }
}
