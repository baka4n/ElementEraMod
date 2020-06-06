package io.github.elementera;

import io.github.elementera.api.common.items.RegisterItem;

import static io.github.elementera.api.common.fluids.ABaseFluid.regF;
import static io.github.elementera.api.config.CenterConfig.config;

/**
 * @author baka4n
 * classes
 */
public class Elementera implements net.fabricmc.api.ModInitializer {
	/**
	 * @param s1 log4j pre-position
	 * @param s2 log4j post-position
	 */
	public static void log(String s1, String s2) {
		org.apache.logging.log4j.LogManager.getLogger(s1).info(s2);
	}
	public static final String s = "OnInitializes";
	@Override
	public void onInitialize() {
		proxy();
		log(s, "element era mods OnInitializes!");
	}
	public static void proxy() {
		configs(); log(s, "proxy oninitialize");
	}

	public static void configs() {
		config();
		new RegisterItem();
		regF();
	}
}

