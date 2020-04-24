package io.github.elementera.mixin;

import com.google.common.util.concurrent.Runnables;
import io.github.elementera.gui.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.CreditsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.text.Text;
import net.minecraft.world.level.storage.LevelStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

/**
 * @author baka4n
 * @Nullable mixins
 * @Nullable inject
 */
@Mixin(TitleScreen.class)
@Nullable
public class ElementMixin extends Screen {
	public Logger logger = LogManager.getLogger("ElementMixin");
	@Shadow
	private Screen realmsNotificationGui;
	@Shadow
	private int copyrightTextX;
	@Shadow
	private int copyrightTextWidth;

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

	/**
	 * @author baka4n
	 * @param info
	 * @Nullable int call back info head mixin
	 */
	@Inject(at = @At("HEAD"), method = "init()V")
	@Nullable
	private void init(CallbackInfo info) {

	}

	/**
	 * @author baka4n
	 * @Nullable Overwrite initWidgetsNormal
	 * @Nullable by TitleScreen.class int y!
	 * @Nullable by spacingY;
	 * @Nullable add Button authors move button to other by minecraft;
	 */
	@Overwrite
	@Nullable
	private void initWidgetsNormal(@Nullable int y,@Nullable int spacingY) {
		this.addButton(new ButtonWidget(this.width / 2 - 100, y, 200, 20, I18n.translate("elementera.ElementEra"), (action) -> {
			MinecraftClient.getInstance().openScreen(new Authors(this));

			logger.warn(I18n.translate("authors"));
			logger.warn(I18n.translate("open.authors"));
		}));
		this.addButton(new ButtonWidget(this.width / 2 - 100, y + spacingY * 1, 100, 20, I18n.translate("menu.singleplayer", new Object[0]), (buttonWidget) -> {
			logger.warn(I18n.translate("singleplayer"));
			this.client.openScreen(new SelectWorldScreen(this));
		}));
		this.addButton(new ButtonWidget(this.width / 2, y + spacingY * 1, 100, 20, I18n.translate("menu.multiplayer", new Object[0]), (buttonWidget) -> {
			logger.warn(I18n.translate("multiplayer"));
			this.client.openScreen(new MultiplayerScreen(this));
		}));
		this.addButton(new ButtonWidget(this.width / 2 - 100, y + spacingY * 2, 200, 20, I18n.translate("menu.online", new Object[0]), (buttonWidget) -> {
			logger.warn(I18n.translate("online"));
			this.switchToRealms();
		}));
	}

	/**
	 * @author baka4n
	 * @Nullable add extends void switchToRealms
	 */
	@Overwrite
	@Nullable
	private void switchToRealms() {
		RealmsBridge realmsBridge = new RealmsBridge();
		realmsBridge.switchToRealms(this);
	}

	/**
	 * @author baka4n
	 * @param title
	 */
	@Nullable
	protected ElementMixin(Text title) {
		super(title);
	}
	/**
	 * @author baka4n
	 */
	@Overwrite
	private boolean areRealmsNotificationsEnabled() {
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
				this.client.openScreen(new CreditsScreen(false, Runnables.doNothing()));
			}

			return false;
		}
	}

	/**
	 * @author baka4n
	 * @Nullable if realmsNotificationGui no have in genuine to remove
	 */
	@Overwrite
	@Nullable
	public void removed() {
		if (this.realmsNotificationGui != null) {
			this.realmsNotificationGui.removed();
		}

	}

	/**
	 * @author baka4n
	 * @Nullable delete
	 */
	@Overwrite
	@Nullable
	private void onDemoDeletionConfirmed(boolean delete) {
		if (delete) {
			try {
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

		this.client.openScreen(this);
	}
}
