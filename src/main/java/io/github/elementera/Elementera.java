package io.github.elementera;

import io.github.elementera.config.Config;
import io.github.elementera.config.RemoveItemConfig;
import io.github.elementera.energy.ElementAmpere;
import io.github.elementera.items.Public;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

import static io.github.elementera.Proxies.registerItem;
import static io.github.elementera.config.RemoveItemConfig.pr;
import static io.github.elementera.items.Public.*;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Thread.sleep;

/*import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;*/

/**
 * @author baka4n
 * classes
 */
public class Elementera implements ModInitializer {
	public static final Logger logger = LogManager.getLogger("OnInitializes");

	@Override
	public void onInitialize() {
		proxy();
		logger.info("element era mods OnInitializes!"); }
	public static void proxy() { new Proxies(); logger.info("proxy oninitialize"); }
}

class Proxies implements Loggers {
	public Proxies() {
		modBlock(); config(); publicS(); energy();
		removeItemConfig();
		if (removeItemConfig()) {
			modItem();
		}
	}
	public static void modItem() { new ModItems();proxys.info("moditem register"); }
	public static void modBlock() { new ModBlocks(); proxys.info("modblock register");}
	public static void config() { new Config(); proxys.info("config register"); }
	public static boolean removeItemConfig() {  new RemoveItemConfig();
		return true;
	}
	public static void publicS() { new Public(); proxys.info("public register"); }
	public static void registerItem(String itemName, Item item) {
		ItemsRegister.registerItem(MODID, itemName, item);
	}
	public static void energy() {
		new ElementAmpere();
		proxys.info("ampere register");
		tick(
				3000L,
				"config" + File.separator + File.separator +  "fabric" + File.separator + File.separator + "energy"+ File.separator + File.separator + "BoPt.ee",
				3000L
		);
	}

	public static void tick(long timeInterval, String filename, long c) {
		Runnable runnable = () -> {
			do {
				boolean bool = true;
				try {
					ElementAmpere.p.load(new BufferedInputStream(new FileInputStream(filename)));
				} catch (FileNotFoundException e) {
					bool = false;
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (bool) ElementAmpere.tick(timeInterval, "BoPt", c);
				}
				try {
					sleep(timeInterval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while (true);
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}

/*
	public static void registerArmor(String armorName, Item helmet, Item chestplate, Item leggings, Item boots) { ItemsRegister.registerArmor(MODID, armorName, helmet, chestplate, leggings, boots); }
	public static void registerTool(String toolName, Item axe, Item hoe, Item pickaxe, Item shovel, Item sword) { ItemsRegister.registerTool(MODID, toolName, axe, hoe, pickaxe, shovel, sword); }
	public static void registerBlock(String blockName, Block block, Item.Settings settings) { BlockRegister.registerBlock(MODID, blockName, block, settings); }
	public static void registerContainer(Identifier identifier, Block block, Item.Settings settings) { BlockRegister.registerContainer(identifier, block, settings); }
*/
}
class ModItems implements Loggers {

	public ModItems() {
		if (parseBoolean(pr.getProperty("protium"))) registerItem("protium", PROTIUM);
		if (parseBoolean(pr.getProperty("helium_4"))) registerItem("helium_4", He4);
		if (parseBoolean(pr.getProperty("lithium_7"))) registerItem("lithium_7", Li7);
		if (parseBoolean(pr.getProperty("beryllium_8"))) registerItem("beryllium_8", Be8);
		if (parseBoolean(pr.getProperty("carbon_12"))) registerItem("carbon_12", C12);
		if (parseBoolean(pr.getProperty("fluorine_19"))) registerItem("fluorine_19", F19);

		if (parseBoolean(pr.getProperty("helium_5"))) registerItem("helium_5", He5);
		if (parseBoolean(pr.getProperty("deuterium"))) registerItem("deuterium", DEUTERIUM);
		if (parseBoolean(pr.getProperty("tritium"))) registerItem("tritium", TRITIUM);
		if (parseBoolean(pr.getProperty("helium_2"))) registerItem("helium_2", He2);
		if (parseBoolean(pr.getProperty("helium_3"))) registerItem("helium_3", He3);
		if (parseBoolean(pr.getProperty("helium_6"))) registerItem("helium_6", He6);
		if (parseBoolean(pr.getProperty("helium_7"))) registerItem("helium_7", He7);
		if (parseBoolean(pr.getProperty("helium_8"))) registerItem("helium_8", He8);
		if (parseBoolean(pr.getProperty("helium_9"))) registerItem("helium_9", He9);
		if (parseBoolean(pr.getProperty("helium_10"))) registerItem("helium_10", He10);
		if (parseBoolean(pr.getProperty("lithium_6"))) registerItem("lithium_6", Li6);
		if (parseBoolean(pr.getProperty("beryllium_7"))) registerItem("beryllium_7", Be7);
		if (parseBoolean(pr.getProperty("beryllium_9"))) registerItem("beryllium_9", Be9);
		if (parseBoolean(pr.getProperty("beryllium_10"))) registerItem("beryllium_10", Be10);
		if (parseBoolean(pr.getProperty("boron_6"))) registerItem("boron_6", B6);
		if (parseBoolean(pr.getProperty("boron_7"))) registerItem("boron_7", B7);
		if (parseBoolean(pr.getProperty("boron_8"))) registerItem("boron_8", B8);
		if (parseBoolean(pr.getProperty("boron_9"))) registerItem("boron_9", B9);
		if (parseBoolean(pr.getProperty("boron_10"))) registerItem("boron_10", B10);
		if (parseBoolean(pr.getProperty("boron_11"))) registerItem("boron_11", B11);
		if (parseBoolean(pr.getProperty("boron_12"))) registerItem("boron_12", B12);
		if (parseBoolean(pr.getProperty("boron_13"))) registerItem("boron_13", B13);
		if (parseBoolean(pr.getProperty("boron_14"))) registerItem("boron_14", B14);
		if (parseBoolean(pr.getProperty("boron_15"))) registerItem("boron_15", B15);
		if (parseBoolean(pr.getProperty("boron_16"))) registerItem("boron_16", B16);
		if (parseBoolean(pr.getProperty("boron_17"))) registerItem("boron_17", B17);
		if (parseBoolean(pr.getProperty("boron_18"))) registerItem("boron_18", B18);
		registerItem("boron_19", B19);
		registerItem("carbon_8", C8);
		registerItem("carbon_9", C9);
		registerItem("carbon_10", C10);
		registerItem("carbon_11", C11);
		registerItem("carbon_13", C13);
		registerItem("carbon_14", C14);
		registerItem("carbon_15", C15);
		registerItem("carbon_16", C16);
		registerItem("carbon_17", C17);
		registerItem("carbon_18", C18);
		registerItem("carbon_19", C19);
		registerItem("carbon_20", C20);
		registerItem("carbon_21", C21);
		registerItem("carbon_22", C22);
		registerItem("nitrogen_10", N10);
		registerItem("nitrogen_11", N11);
		registerItem("nitrogen_12", N12);
		registerItem("nitrogen_13", N13);
		registerItem("nitrogen_14", N14);
		registerItem("nitrogen_15", N15);
		registerItem("nitrogen_16", N16);
		registerItem("nitrogen_17", N17);
		registerItem("nitrogen_18", N18);
		registerItem("nitrogen_19", N19);
		registerItem("nitrogen_20", N20);
		registerItem("nitrogen_21", N21);
		registerItem("nitrogen_22", N22);
		registerItem("nitrogen_23", N23);
		registerItem("nitrogen_24", N24);
		registerItem("nitrogen_25", N25);
		registerItem("oxygen_13", O13);
		registerItem("oxygen_14", O14);
		registerItem("oxygen_15", O15);
		registerItem("oxygen_16", O16);
		registerItem("oxygen_17", O17);
		registerItem("oxygen_18", O18);
		registerItem("oxygen_19", O19);
		registerItem("oxygen_20", O20);
		registerItem("oxygen_21", O21);
		registerItem("oxygen_22", O22);
		registerItem("oxygen_23", O23);
		registerItem("oxygen_24", O24);
		registerItem("fluorine_14", F14);
		registerItem("fluorine_15", F15);
		registerItem("fluorine_16", F16);
		registerItem("fluorine_17", F17);
		registerItem("fluorine_18", F18);
		registerItem("fluorine_20", F20);
		registerItem("fluorine_21", F21);
		registerItem("fluorine_22", F22);
		registerItem("fluorine_23", F23);
		registerItem("fluorine_24", F24);
		registerItem("fluorine_25", F25);
		registerItem("fluorine_26", F26);
		registerItem("fluorine_27", F27);
		registerItem("fluorine_28", F28);
		registerItem("fluorine_29", F29);
		registerItem("fluorine_30", F30);
		registerItem("fluorine_31", F31);
		itemreg.info("register all item success!");
	}
}class ItemsRegister implements Loggers {
	public static void registerItem(String modid,String itemName,Item item) {
		Registry.register(Registry.ITEM, new Identifier(modid, itemName), item);
		itemreg.info("register " + itemName);
	}

	/*public static void registerArmor(String modid, String armorName, Item helmet, Item chestplate, Item leggings, Item boots) {
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
	}*/
}
class ModBlocks implements Loggers {
	public ModBlocks() {
	}
}/*class BlockRegister implements Loggers {
	*//*public static void registerBlock(String modid, String blockName, Block block, Item.Settings settings) {
		Registry.register(Registry.BLOCK, new Identifier(modid, blockName), block);
		blockreg.info("regblock " + blockName);
		Registry.register(Registry.ITEM, new Identifier(modid, blockName), new BlockItem(block, settings));
		blockreg.info("regblockitem" + blockName);
	}
	public static void registerContainer(Identifier identifier, Block block, Item.Settings settings) {
		Registry.register(Registry.BLOCK, identifier, block);
		Registry.register(Registry.ITEM, identifier, new BlockItem(block, settings));
		blockreg.info("register container!");
	}*//*
}*/
