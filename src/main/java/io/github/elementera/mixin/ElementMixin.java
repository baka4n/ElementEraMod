package io.github.elementera.mixin;

import io.github.elementera.gui.Authors;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.gui.screen.multiplayer.*;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.text.*;
import net.minecraft.world.level.storage.LevelStorage.Session;
import org.apache.logging.log4j.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.*;

import static com.google.common.util.concurrent.Runnables.doNothing;
import static io.github.elementera.api.config.Config.getProperties;
import static io.github.elementera.gui.ItemDisable.OpenGui;
import static java.lang.Integer.parseInt;
import static net.minecraft.client.resource.language.I18n.translate;

@Mixin(TitleScreen.class)
@Environment(EnvType.CLIENT)
public abstract class ElementMixin extends Screen {
	public Logger logger = LogManager.getLogger("ElementMixin");
	@Shadow private Screen realmsNotificationGui;
	@Shadow private int copyrightTextX;
	@Shadow private int copyrightTextWidth;
	@Shadow public abstract void render(MatrixStack matrices, int mouseX, int mouseY, float delta);
	protected ElementMixin() {
		super(new TranslatableText("narrator.screen.title"));
	}
	/**
	 * @author baka4n
	 */
	@Inject(method = "render", at = @At("RETURN"))
	protected void render(MatrixStack m, int X, int Y, float delta, CallbackInfo info) {
		if (getProperties("titleScreen_mouseX_hide").equals("no")) draw(m, "mouseX", X, 5, 5);
		if (getProperties("titleScreen_mouseY_hide").equals("no")) draw(m, "mouseY", Y, 5, 5 + textRenderer.fontHeight);
	}

	/**
	 * @author baka4n
	 * @reason Overwrite initWidgetsNormal.
	   		by TitleScreen.class int y!
				by spacingY;
					add Button authors move button to other by minecraft;
						if you follow eula you can edit this gui
	 */
	@Overwrite
	private void initWidgetsNormal(int y, int spacingY) {
		if (getProperties("eula").equals("true")) {
			if (getProperties("editGui").equals("yes")) {
				if (getProperties("author_hide").equals("no")) {
					int inty;
					if (getProperties("author_this_y").equals("y")) {
						inty = y;
					} else {
						inty = parseInt(getProperties("author_this_y"));
					}
					MYButton(parseInt(getProperties("author_this_a")) * this.width / parseInt(getProperties("author_this_b")) + parseInt(getProperties("author_this_c")), inty, parseInt(getProperties("author_button_width")), parseInt(getProperties("author_button_height")), "elementera.ElementEra", (buttonWidget) -> OpenGui(new Authors(this)));
				}
				MYButton(parseInt(getProperties("sing_player_this_a")) * this.width / parseInt(getProperties("sing_player_this_b")) + parseInt(getProperties("sing_player_this_c")), parseInt(getProperties("sing_player_this_y")), parseInt(getProperties("sing_player_button_width")), parseInt(getProperties("sing_player_button_height")), "menu.singleplayer", (buttonWidget) -> OpenGui(new SelectWorldScreen(this)));
				MYButton(parseInt(getProperties("multiplayer_this_a")) * this.width / parseInt(getProperties("multiplayer_this_b")) + parseInt(getProperties("multiplayer_this_c")), parseInt(getProperties("multiplayer_this_y")), parseInt(getProperties("multiplayer_button_width")), parseInt(getProperties("multiplayer_button_height")), "menu.multiplayer", (buttonWidget) -> OpenGui(new MultiplayerScreen(this)));
				MYButton(parseInt(getProperties("online_this_a")) * this.width / parseInt(getProperties("online_this_b")) + parseInt(getProperties("online_this_c")), parseInt(getProperties("online_this_y")), parseInt(getProperties("online_button_width")), parseInt(getProperties("online_button_height")), "menu.online", (buttonWidget) -> this.switchToRealms());
			} else {
				MYButton(this.width / 2 - 100, y, 200, 20, "elementera.ElementEra", (buttonWidget) -> OpenGui(new Authors(this)));
				MYButton(this.width / 2 - 100, y, 200, 20, "elementera.ElementEra", (buttonWidget) -> OpenGui(new Authors(this)));
				MYButton(this.width / 2 - 100, y + spacingY, 100, 20, "menu.singleplayer", (buttonWidget) -> OpenGui(new SelectWorldScreen(this)));
				MYButton(this.width / 2, y + spacingY, 100, 20, "menu.multiplayer", (buttonWidget) -> OpenGui(new MultiplayerScreen(this)));
				MYButton(this.width / 2 - 100, y + spacingY * 2, 200, 20, "menu.online", (buttonWidget) -> this.switchToRealms());
			}
		} else if (getProperties("eula").equals("false")){
			MYButton(this.width / 2 - 100, y, 200, 20, "menu.singleplayer", (buttonWidget) -> OpenGui(new SelectWorldScreen(this)));
			MYButton(this.width / 2 - 100, y + spacingY, 200, 20, "menu.multiplayer", (buttonWidget) -> { assert this.client != null;if (this.client.options.skipMultiplayerWarning) OpenGui(new MultiplayerScreen(this));else OpenGui(new MultiplayerWarningScreen(this)); });
			MYButton(this.width / 2 - 100, y + spacingY * 2, 200, 20, "menu.online", (buttonWidget) -> this.switchToRealms());
		}
	}

	/**
	 * @author baka4n
	 * @reason  add extends void switchToRealms
	 */
	@Overwrite
	private void switchToRealms() {
		RealmsBridge realmsBridge = new RealmsBridge();realmsBridge.switchToRealms(this);
	}
	/**
	 * @author baka4n
	 * @reason import for minecraft
	 */
	@Overwrite
	private boolean areRealmsNotificationsEnabled() {
		assert this.client != null;
		return this.client.options.realmsNotifications && this.realmsNotificationGui != null;
	}
	/**
	 * @author baka4n
	 * @reason import for minecraft
	 */
	@Overwrite
	public void tick() {
		if (this.areRealmsNotificationsEnabled()) {
			this.realmsNotificationGui.tick();
		}

	}
	/**
	 * @author baka4n
	 * @reason import for minecraft
	 */
	@Overwrite
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		if (super.mouseClicked(mouseX, mouseY, button)) {
			return true;
		} else if (this.areRealmsNotificationsEnabled() && this.realmsNotificationGui.mouseClicked(mouseX, mouseY, button)) {
			return true;
		} else {
			if (mouseX > (double)this.copyrightTextX && mouseX < (double)(this.copyrightTextX + this.copyrightTextWidth) && mouseY > (double)(this.height - 10) && mouseY < (double)this.height) {
				assert this.client != null;
				this.client.openScreen(new CreditsScreen(false, doNothing()));
			}
			return false;
		}
	}
	/**
	 * @author baka4n
	 * @reason if realmsNotificationGui no have in genuine to remove
	 */
	@Overwrite
	public void removed() {
		if (this.realmsNotificationGui != null) {
			this.realmsNotificationGui.removed();
		}
	}
	/**
	 * @author baka4n
	 * @reason import for minecraft
	 */
	@Overwrite
	private void onDemoDeletionConfirmed(boolean delete) {
		if (delete) {
			try { assert this.client != null;
				Session session = this.client.getLevelStorage().createSession("Demo_World");
				Throwable var3 = null;
				try { session.deleteSessionLock();
				} catch (Throwable var13) { var3 = var13;throw var13;
				} finally {
					if (session != null) {
						if (var3 != null) {
							try { session.close();
							} catch (Throwable var12) { var3.addSuppressed(var12); }
						} else { session.close(); }
					}
				}
			} catch (IOException var15) {
				SystemToast.method_27025(this.client, "Demo_World");
				logger.warn("Failed to delete demo world", var15);
			}
		}
		assert this.client != null;
		this.client.openScreen(this);
	}
	public void draw(MatrixStack m, String s1, int a, int x, int y) {
		TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;textRenderer.draw(m, translate(s1) + ": " + a, x, y, 0xFFFFFFFF);
	}
	public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) { this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress)); }
}
