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
    @Shadow
    protected final Screen parent;
    @Shadow
    protected final GameOptions gameOptions;

    protected GameOptionsScreenMixin(Screen parent, GameOptions gameOptions, Text title) {
        super(title);
        this.parent = parent;
        this.gameOptions = gameOptions;
    }
    /**
     * @author baka4n
     */
    @Overwrite
    public void removed() {
        this.client.options.write();
    }

    /**
     * @author baka4n
     */
    @Overwrite
    public void onClose() {
        this.client.openScreen(this.parent);
    }

}
