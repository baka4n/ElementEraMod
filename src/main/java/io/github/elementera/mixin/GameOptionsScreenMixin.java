package io.github.elementera.mixin;

import net.fabricmc.api.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.GameOptionsScreen;
import net.minecraft.client.options.GameOptions;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.*;

@Mixin(GameOptionsScreen.class)
@Environment(EnvType.CLIENT)
public class GameOptionsScreenMixin extends Screen {
    protected final Screen parent;
    protected final GameOptions gameOptions;

    protected GameOptionsScreenMixin(Screen parent, GameOptions gameOptions, Text title) {
        super(title);
        this.parent = parent;
        this.gameOptions = gameOptions;
    }
    /**
     * @author baka4n
     * @reason import for minecraft
     */
    @Overwrite
    public void removed() {
        assert this.client != null;
        this.client.options.write();
    }

    /**
     * @author baka4n
     * @reason import for minecraft
     */
    @Overwrite
    public void onClose() {
        assert this.client != null;
        this.client.openScreen(this.parent);
    }

}
