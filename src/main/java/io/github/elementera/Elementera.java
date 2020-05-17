package io.github.elementera;

import io.github.elementera.api.config.移除物品;
import io.github.elementera.common.items.MachineBlock;
import io.github.elementera.common.items.Public;
import io.github.elementera.energy.ElementAmpere;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.function.ToIntFunction;

import static io.github.elementera.Elementera.log;
import static io.github.elementera.ItemsRegister.registerItem;
import static io.github.elementera.Proxies.proxyS;
import static io.github.elementera.Proxies.registerItem;
import static io.github.elementera.api.config.Config.config;
import static io.github.elementera.api.config.移除物品.*;
import static io.github.elementera.common.items.Public.*;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Thread.sleep;

/**
 * @author baka4n
 * classes
 */
public class Elementera implements ModInitializer {
	public static void log(String s1, String s2) {
		Logger logger = LogManager.getLogger(s1); logger.info(s2);
	}
	public static final String s = "OnInitializes";
	@Override
	public void onInitialize() {
		proxy();
		log(s, "element era mods OnInitializes!");
	}
	public static void proxy() { proxyS(); log(s, "proxy oninitialize"); }
}
class Proxies {
	public static final String s = "proxy";
	public static void proxyS() {
		modBlock(); configs(); publicS(); energy();
		removeItemConfig();if (removeItemConfig()) modItem();
	}
	public static void modItem() { ModItems.registerItemAll(); log(s, "moditem register"); }
	public static void modBlock() { new ModBlocks(); log(s, "modblock register");}
	public static void configs() { config(); log(s, "config register"); }
	public static boolean removeItemConfig() {  new 移除物品(); return true; }
	public static void publicS() { new Public(); log(s, "public register"); }
	public static void registerItem(String itemName, Item item) {
		ItemsRegister.registerItem(MODID, itemName, item);
	}
	public static void energy() {
		new ElementAmpere();
		log(s, "ampere register");
		tick(
				3000L,
				"config" + s +  "fabric" + s + "energy"+ s + "BoPt.ee",
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
class ModItems {
	public static void chooseReg(String s1, Item i) { if (parseBoolean(pr.getProperty(s1))) registerItem(s1, i); }
	public static void registerItemAll() {
		chooseReg(protium, PROTIUM);chooseReg(deuterium, DEUTERIUM);
		chooseReg(tritium, TRITIUM);chooseReg(hydrogen_4, H4);
		chooseReg(hydrogen_5, H5);chooseReg(hydrogen_6, H6);
		chooseReg(hydrogen_7, H7);chooseReg(helium_3, He3);
		chooseReg(helium_4, He4);chooseReg(helium_5, He5);
		chooseReg(helium_6, He6);chooseReg(helium_7, He7);
		chooseReg(helium_8, He8);chooseReg(helium_9, He9);
		chooseReg(helium_10, He10);chooseReg(lithium_5, Li5);
		chooseReg(lithium_6, Li6);chooseReg(lithium_7, Li7);
		chooseReg(lithium_8, Li8);chooseReg(lithium_9, Li9);
		chooseReg(lithium_10, Li10);chooseReg(lithium_11, Li11);
		chooseReg(lithium_12, Li12);chooseReg(lithium_13, Li13);
		chooseReg(beryllium_5, Be5);chooseReg(beryllium_6, Be6);
		chooseReg(beryllium_7, Be7);chooseReg(beryllium_8, Be8);
		chooseReg(beryllium_9, Be9);chooseReg(beryllium_10, Be10);
		chooseReg(beryllium_11, Be11);chooseReg(beryllium_12, Be12);
		chooseReg(beryllium_13, Be13);chooseReg(beryllium_14, Be14);
		chooseReg(beryllium_15, Be15);chooseReg(beryllium_16, Be16);
		chooseReg(boron_7, B7);chooseReg(boron_8, B8);
		chooseReg(boron_9, B9);chooseReg(boron_10, B10);
		chooseReg(boron_11, B11);chooseReg(boron_14, B14);
		chooseReg(boron_15, B15);chooseReg(boron_16, B16);
		chooseReg(boron_17, B17);chooseReg(carbon_8, C8);
		chooseReg(carbon_9, C9);chooseReg(carbon_10, C10);
		chooseReg(carbon_11, C11);chooseReg(carbon_12, C12);
		chooseReg(carbon_13, C13);chooseReg(carbon_14, C14);
		chooseReg(carbon_15, C15);chooseReg(carbon_16, C16);
		chooseReg(carbon_17, C17);chooseReg(carbon_18, C18);
		chooseReg(carbon_19, C19);chooseReg(carbon_20, C20);
		chooseReg(carbon_21, C21);chooseReg(carbon_22, C22);
		chooseReg(carbon_23, C23);chooseReg(nitrogen_10, N10);
		chooseReg(nitrogen_11, N11);chooseReg(nitrogen_12, N12);
		chooseReg(nitrogen_13, N13);chooseReg(nitrogen_14, N14);
		chooseReg(nitrogen_15, N15);chooseReg(nitrogen_16, N16);
		chooseReg(nitrogen_17, N17);
		log("items register", "register all item success!");
	}

	public static void regI(String s, Item i) {
		registerItem(MODID, s, i);
	}
}class ItemsRegister {

	public static void registerItem(String modid,String itemName,Item item) {
		Registry.register(Registry.ITEM, new Identifier(modid, itemName), item);
		log("items register", "register " + itemName);
	}

	/*public static void registerArmor(String modid, String armorName, Item helmet, Item chestplate, Item leggings, Item boots) {
		Registry.register(Registry.ITEM, new Identifier(modid, armorName+"_helmet"), helmet);
		Registry.register(Registry.ITEM, new Identifier(modid, armorName+"_chestplate"), chestplate);
		Registry.register(Registry.ITEM, new Identifier(modid, armorName+"_leggings"), leggings);
		Registry.register(Registry.ITEM, new Identifier(modid, armorName+"_boots"), boots);
		log("items register", "register ", armorName);
	}

	public static void registerTool(String modid, String toolName, Item axe, Item hoe, Item pickaxe, Item shovel, Item sword) {
		Registry.register(Registry.ITEM, new Identifier(modid, toolName+"_axe"), axe);
		Registry.register(Registry.ITEM, new Identifier(modid, toolName+"_hoe"), hoe);
		Registry.register(Registry.ITEM, new Identifier(modid, toolName+"_pickaxe"), pickaxe);
		Registry.register(Registry.ITEM, new Identifier(modid, toolName+"_shovel"), shovel);
		Registry.register(Registry.ITEM, new Identifier(modid, toolName+"_sword"), sword);
		log("items register", "register " + toolName);
	}*/
}

class ModBlocks implements Loggers {

	public ModBlocks() {
		register(new Identifier("elementera","distillation_machine"), new MachineBlock(AbstractBlock.Settings.of(Material.STONE).strength(3.5F).lightLevel(createLightLevelFromBlockState(13))));
	}
	private static void register(Identifier id, Block block) {
		Registry.register(Registry.BLOCK, id, block);
	}
	private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel) {
		return (blockState) -> (Boolean)blockState.get(Properties.LIT) ? litLevel : 0;
	}
}class BlockRegister implements Loggers {
	public static void registerBlock(String modid, String blockName, Block block, Item.Settings settings) {
		Registry.register(Registry.BLOCK, new Identifier(modid, blockName), block);
		blockreg.info("regblock " + blockName);
		Registry.register(Registry.ITEM, new Identifier(modid, blockName), new BlockItem(block, settings));
		blockreg.info("regblockitem" + blockName);
	}
	public static void registerContainer(Identifier identifier, Block block, Item.Settings settings) {
		Registry.register(Registry.BLOCK, identifier, block);
		Registry.register(Registry.ITEM, identifier, new BlockItem(block, settings));
		blockreg.info("register container!");
	}
}
