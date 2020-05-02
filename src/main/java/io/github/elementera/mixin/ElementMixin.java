package io.github.elementera.mixin;

import io.github.elementera.gui.Authors;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.text.*;
import net.minecraft.world.level.storage.LevelStorage;
import org.apache.logging.log4j.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

import static com.google.common.util.concurrent.Runnables.doNothing;
import static io.github.elementera.config.Config.properties;
import static java.lang.Integer.parseInt;
import static net.minecraft.client.resource.language.I18n.translate;

/**
 * @author baka4n
 * @Nullable mixins
 * @Nullable inject
 */
@Mixin(TitleScreen.class)
public class ElementMixin extends Screen {
	public Logger logger = LogManager.getLogger("ElementMixin");
	@Shadow private Screen realmsNotificationGui;
	@Shadow private int copyrightTextX;
	@Shadow private int copyrightTextWidth;
	protected ElementMixin(Text title) {
		super(title);
	}
	/**
	 * @author baka4n
	 */
	@Inject(method = "render", at = @At("RETURN"))
	protected void render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo info) {
		if ("no".equals(properties.getProperty("titleScreen_mouseX_hide"))) {
			textRenderer.draw(matrices, translate("mouseX") + ": " + mouseX, 5, 5, 0xFFFFFFFF);
		}
		if ("no".equals(properties.getProperty("titleScreen_mouseY_hide"))) {
			textRenderer.draw(matrices, translate("mouseY") + ": " + mouseY, 5, 5 + textRenderer.fontHeight, 0xFFFFFFFF);
		}
	}

	/**
	 * @author baka4n
	 * @param info
	 * int call back info head mixin
	 */
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		super.init();
	}

	/**
	 * @author baka4n
	 * Overwrite initWidgetsNormal
	 * by TitleScreen.class int y!
	 * by spacingY;
	 * add Button authors move button to other by minecraft;
	 */
	@Overwrite
	private void initWidgetsNormal(int y, int spacingY) {
		if (properties.getProperty("editGui").equals("yes")) {
			if (properties.getProperty("author_hide").equals("no")) {
				int inty;
				if (properties.getProperty("author_this_y").equals("y")) { inty = y; } else { inty = parseInt(properties.getProperty("author_this_y")); }
				this.addButton(new ButtonWidget(
						parseInt(properties.getProperty("author_this_a")) * this.width / parseInt(properties.getProperty("author_this_b")) + parseInt(properties.getProperty("author_this_c")),
						inty,
						parseInt(properties.getProperty("author_button_width")),
						parseInt(properties.getProperty("author_button_height")),
						new TranslatableText("elementera.ElementEra"), (action) -> {
					MinecraftClient.getInstance().openScreen(new Authors(this));
					logger.warn(translate("authors"));
					logger.warn(translate("open.authors"));
				}));
			}
			this.addButton(new ButtonWidget(
					parseInt(properties.getProperty("sing_player_this_a")) * this.width / parseInt(properties.getProperty("sing_player_this_b")) + parseInt(properties.getProperty("sing_player_this_c")),
					parseInt(properties.getProperty("sing_player_this_y")),
					parseInt(properties.getProperty("sing_player_button_width")),
					parseInt(properties.getProperty("sing_player_button_height")),
					new TranslatableText("menu.singleplayer"),
					(buttonWidget) -> {
				logger.warn(translate("singleplayer"));
						assert this.client != null;
						this.client.openScreen(new SelectWorldScreen(this));
			}));
			this.addButton(new ButtonWidget(
					parseInt(properties.getProperty("multiplayer_this_a")) * this.width / parseInt(properties.getProperty("multiplayer_this_b")) + parseInt(properties.getProperty("multiplayer_this_c")),
					parseInt(properties.getProperty("multiplayer_this_y")),
					parseInt(properties.getProperty("multiplayer_button_width")),
					parseInt(properties.getProperty("multiplayer_button_height")),
					new TranslatableText("menu.multiplayer"), (buttonWidget) -> {
				logger.warn(translate("multiplayer"));
				assert this.client != null;
				this.client.openScreen(new MultiplayerScreen(this));
			}));
			this.addButton(new ButtonWidget(
					parseInt(properties.getProperty("online_this_a")) * this.width / parseInt(properties.getProperty("online_this_b")) + parseInt(properties.getProperty("online_this_c")),
					parseInt(properties.getProperty("online_this_y")),
					parseInt(properties.getProperty("online_button_width")),
					parseInt(properties.getProperty("online_button_height")),
					new TranslatableText("menu.online"), (buttonWidget) -> {
				logger.warn(translate("online"));
				this.switchToRealms();
			}));
		} else {
			this.addButton(new ButtonWidget(
					this.width / 2 - 100, y, 200, 20, new TranslatableText("elementera.ElementEra"), (action) -> {
				MinecraftClient.getInstance().openScreen(new Authors(this));
				logger.warn(translate("authors"));
				logger.warn(translate("open.authors"));
			}));
			this.addButton(new ButtonWidget(this.width / 2 - 100, y + spacingY, 100, 20, new TranslatableText("menu.singleplayer"), (buttonWidget) -> {
				logger.warn(translate("singleplayer"));
				assert this.client != null;
				this.client.openScreen(new SelectWorldScreen(this));
			}));
			this.addButton(new ButtonWidget(this.width / 2, y + spacingY, 100, 20, new TranslatableText("menu.multiplayer"), (buttonWidget) -> {
				logger.warn(translate("multiplayer"));
				assert this.client != null;
				this.client.openScreen(new MultiplayerScreen(this));
			}));
			this.addButton(new ButtonWidget(this.width / 2 - 100, y + spacingY * 2, 200, 20, new TranslatableText("menu.online"), (buttonWidget) -> {
				logger.warn(translate("online"));
				this.switchToRealms();
			}));
		}
	}

	/**
	 * @author baka4n
	 * add extends void switchToRealms
	 */
	@Overwrite
	private void switchToRealms() {
		RealmsBridge realmsBridge = new RealmsBridge();
		realmsBridge.switchToRealms(this);
	}
	/**
	 * @author baka4n
	 */
	@Overwrite
	private boolean areRealmsNotificationsEnabled() {
		assert this.client != null;
		return this.client.options.realmsNotifications && this.realmsNotificationGui != null;
	}

	/**
	 * @author baka4n
	 */
	@Overwrite
	public void tick() {
		if (this.areRealmsNotificationsEnabled()) {
			this.realmsNotificationGui.tick();
		}

	}

	/**
	 * @author baka4n
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
	 *if realmsNotificationGui no have in genuine to remove
	 */
	@Overwrite
	public void removed() {
		if (this.realmsNotificationGui != null) {
			this.realmsNotificationGui.removed();
		}

	}

	/**
	 * @author baka4n
	 * delete
	 */
	@Overwrite
	private void onDemoDeletionConfirmed(boolean delete) {
		if (delete) {
			try {
				assert this.client != null;
				LevelStorage.Session session = this.client.getLevelStorage().createSession("Demo_World");
				Throwable var3 = null;

				try {
					session.deleteSessionLock();
				} catch (Throwable var13) {
					var3 = var13;
					throw var13;
				} finally {
					if (session != null) {
						if (var3 != null) {
							try {
								session.close();
							} catch (Throwable var12) {
								var3.addSuppressed(var12);
							}
						} else {
							session.close();
						}
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
}
