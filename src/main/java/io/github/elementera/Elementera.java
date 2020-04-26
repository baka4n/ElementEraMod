package io.github.elementera;

import io.github.elementera.items.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.*;
import java.util.*;
import static io.github.elementera.items.Public.*;

/**
 * @author baka4n
 * classes
 */
public class Elementera implements ModInitializer {
	public static final TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
	interface OnInitialize { Logger logger = LogManager.getLogger("OnInitialize");}
	@Override
	public void onInitialize() {
		proxy();OnInitialize.logger.info("element era mods OnInitialize!");
	}

	public static void proxy(String... args) {
		new Proxies();OnInitialize.logger.info("proxy oninitialize");
		new Public();
	}
}

class Proxies implements Loggers {
	public Proxies() {
		modItem();
	}
	public static void modItem(String... args) { new ModItems();proxys.info("moditem register");
	}
}
class ModItems implements Loggers {
	public ModItems() {
		registerItem("protium", PROTIUM); registerItem("helium_4", He4);
		registerItem("lithium_7", Li7); registerItem("beryllium_8", Be8);
		registerItem("carbon_12", C12); registerItem("fluorine_19", F19);

		registerItem("helium_5", He5); registerItem("deuterium", DEUTERIUM);
		registerItem("tritium", TRITIUM); registerItem("helium_2", He2);
		registerItem("helium_3", He3); registerItem("helium_6", He6);
		registerItem("helium_7", He7); registerItem("helium_8", He8);
		registerItem("helium_9", He9); registerItem("helium_10", He10);
		registerItem("lithium_6", Li6); registerItem("beryllium_7", Be7);
		registerItem("beryllium_9", Be9); registerItem("beryllium_10", Be10);
		registerItem("boron_6", B6); registerItem("boron_7", B7);
		registerItem("boron_8", B8); registerItem("boron_9", B9);
		registerItem("boron_10", B10); registerItem("boron_11", B11);
		registerItem("boron_12", B12); registerItem("boron_13", B13);
		registerItem("boron_14", B14); registerItem("boron_15", B15);
		registerItem("boron_16", B16); registerItem("boron_17", B17);
		registerItem("boron_18", B18); registerItem("boron_19", B19);
		registerItem("carbon_8", C8); registerItem("carbon_9", C9);
		registerItem("carbon_10", C10); registerItem("carbon_11", C11);
		registerItem("carbon_13", C13); registerItem("carbon_14", C14);
		registerItem("carbon_15", C15); registerItem("carbon_16", C16);
		registerItem("carbon_17", C17); registerItem("carbon_18", C18);
		registerItem("carbon_19", C19); registerItem("carbon_20", C20);
		registerItem("carbon_21", C21); registerItem("carbon_22", C22);
		registerItem("nitrogen_10", N10); registerItem("nitrogen_11", N11);
		registerItem("nitrogen_12", N12); registerItem("nitrogen_13", N13);
		registerItem("nitrogen_14", N14); registerItem("nitrogen_15", N15);
		registerItem("nitrogen_16", N16); registerItem("nitrogen_17", N17);
		registerItem("nitrogen_18", N18); registerItem("nitrogen_19", N19);
		registerItem("nitrogen_20", N20); registerItem("nitrogen_21", N21);
		registerItem("nitrogen_22", N22); registerItem("nitrogen_23", N23);
		registerItem("nitrogen_24", N24); registerItem("nitrogen_25", N25);
		registerItem("oxygen_13", O13); registerItem("oxygen_14", O14);
		registerItem("oxygen_15", O15); registerItem("oxygen_16", O16);
		registerItem("oxygen_17", O17); registerItem("oxygen_18", O18);
		registerItem("oxygen_19", O19); registerItem("oxygen_20", O20);
		registerItem("oxygen_21", O21); registerItem("oxygen_22", O22);
		registerItem("oxygen_23", O23); registerItem("oxygen_24", O24);
		registerItem("fluorine_14", F14); registerItem("fluorine_15", F15);
		registerItem("fluorine_16", F16); registerItem("fluorine_17", F17);
		registerItem("fluorine_18", F18); registerItem("fluorine_20", F20);
		registerItem("fluorine_21", F21); registerItem("fluorine_22", F22);
		registerItem("fluorine_23", F23); registerItem("fluorine_24", F24);
		registerItem("fluorine_25", F25); registerItem("fluorine_26", F26);
		registerItem("fluorine_27", F27); registerItem("fluorine_28", F28);
		registerItem("fluorine_29", F29); registerItem("fluorine_30", F30);
		registerItem("fluorine_31", F31);
		itemreg.info("register all item success!");
	}
	private static void registerItem(String itemName, Item item) {
		ItemsRegister.registerItem(MODID, itemName, item);
	}
	private static void registerArmor(String armorName, Item helmet, Item chestplate, Item leggings, Item boots) {
		ItemsRegister.registerArmor(MODID, armorName, helmet, chestplate, leggings, boots);
	}
	private static void registerTool(String toolName, Item axe, Item hoe, Item pickaxe, Item shovel, Item sword) {
		ItemsRegister.registerTool(MODID, toolName, axe, hoe, pickaxe, shovel, sword);
	}
}
class ItemsRegister implements Loggers {
	public static void registerItem(String modid,String itemName,Item item) {
		Registry.register(Registry.ITEM, new Identifier(modid, itemName), item);
		itemreg.info("register " + itemName);
	}

	public static void registerArmor(String modid, String armorName, Item helmet, Item chestplate, Item leggings, Item boots) {
		Registry.register(Registry.ITEM, new Identifier(modid, armorName+"_helmet"), helmet);
		Registry.register(Registry.ITEM, new Identifier(modid, armorName+"_chestplate"), chestplate);
		Registry.register(Registry.ITEM, new Identifier(modid, armorName+"_leggings"), leggings);
		Registry.register(Registry.ITEM, new Identifier(modid, armorName+"_boots"), boots);
		itemreg.info("register ", armorName);
	}

	public static void registerTool(String modid, String toolName, Item axe, Item hoe, Item pickaxe, Item shovel, Item sword) {
		Registry.register(Registry.ITEM, new Identifier(modid, toolName+"_axe"), axe);
		Registry.register(Registry.ITEM, new Identifier(modid, toolName+"_hoe"), hoe);
		Registry.register(Registry.ITEM, new Identifier(modid, toolName+"_pickaxe"), pickaxe);
		Registry.register(Registry.ITEM, new Identifier(modid, toolName+"_shovel"), shovel);
		Registry.register(Registry.ITEM, new Identifier(modid, toolName+"_sword"), sword);
		itemreg.info("register " + toolName);
	}

	public static void registerAll(Collection<Item> c, List<String> itemNames) {
		c.forEach(items -> {
			itemNames.forEach(string -> {
				Registry.register(Registry.ITEM, new Identifier(MODID, string), items);
			});
		});
	}
}
