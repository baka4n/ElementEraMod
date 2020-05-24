package io.github.elementera;

import io.github.elementera.api.config.移除物品;
import io.github.elementera.common.items.MachineBlock;
import io.github.elementera.common.items.Public;
import io.github.elementera.energy.ElementAmpere;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.*;

import java.io.*;
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
		hydrogen();helium();lithium();beryllium();
		boron();carbon();nitrogen();oxygen();
		fluorine();
		/*neon*/chooseReg(neon_16, Ne16);chooseReg(neon_17, Ne17);chooseReg(neon_18, Ne18);chooseReg(neon_19, Ne19);chooseReg(neon_20, Ne20);chooseReg(neon_21, Ne21);chooseReg(neon_22, Ne22);chooseReg(neon_23, Ne23);chooseReg(neon_24, Ne24);chooseReg(neon_25, Ne25);chooseReg(neon_26, Ne26);chooseReg(neon_27, Ne27);chooseReg(neon_28, Ne28);
		log("items register", "register all item success!");
	}
	public static void hydrogen() {/*hydrogen*/chooseReg(protium, PROTIUM);chooseReg(deuterium, DEUTERIUM);chooseReg(tritium, TRITIUM);chooseReg(hydrogen_4, H4);chooseReg(hydrogen_5, H5);chooseReg(hydrogen_6, H6);chooseReg(hydrogen_7, H7); }
	public static void lithium() {/*lithium*/chooseReg(lithium_5, Li5);chooseReg(lithium_6, Li6);chooseReg(lithium_7, Li7);chooseReg(lithium_8, Li8);chooseReg(lithium_9, Li9);chooseReg(lithium_10, Li10);chooseReg(lithium_11, Li11);chooseReg(lithium_12, Li12);chooseReg(lithium_13, Li13); }
	public static void helium() {/*helium*/chooseReg(helium_3, He3);chooseReg(helium_4, He4);chooseReg(helium_5, He5);chooseReg(helium_6, He6);chooseReg(helium_7, He7);chooseReg(helium_8, He8);chooseReg(helium_9, He9);chooseReg(helium_10, He10); }
	public static void beryllium() {/*beryllium*/chooseReg(beryllium_5, Be5);chooseReg(beryllium_6, Be6);chooseReg(beryllium_7, Be7);chooseReg(beryllium_8, Be8);chooseReg(beryllium_9, Be9);chooseReg(beryllium_10, Be10);chooseReg(beryllium_11, Be11);chooseReg(beryllium_12, Be12);chooseReg(beryllium_13, Be13);chooseReg(beryllium_14, Be14);chooseReg(beryllium_15, Be15);chooseReg(beryllium_16, Be16); }
	public static void boron() {/*boron*/chooseReg(boron_7, B7);chooseReg(boron_8, B8);chooseReg(boron_9, B9);chooseReg(boron_10, B10);chooseReg(boron_11, B11);chooseReg(boron_14, B14);chooseReg(boron_15, B15);chooseReg(boron_16, B16);chooseReg(boron_17, B17); }
	public static void carbon() {/*carbon*/chooseReg(carbon_8, C8);chooseReg(carbon_9, C9);chooseReg(carbon_10, C10);chooseReg(carbon_11, C11);chooseReg(carbon_12, C12);chooseReg(carbon_13, C13);chooseReg(carbon_14, C14);chooseReg(carbon_15, C15);chooseReg(carbon_16, C16);chooseReg(carbon_17, C17);chooseReg(carbon_18, C18);chooseReg(carbon_19, C19);chooseReg(carbon_20, C20);chooseReg(carbon_21, C21);chooseReg(carbon_22, C22);chooseReg(carbon_23, C23); }
	public static void nitrogen() {/*nitrogen*/chooseReg(nitrogen_10, N10);chooseReg(nitrogen_11, N11);chooseReg(nitrogen_12, N12);chooseReg(nitrogen_13, N13);chooseReg(nitrogen_14, N14);chooseReg(nitrogen_15, N15);chooseReg(nitrogen_16, N16);chooseReg(nitrogen_17, N17);chooseReg(nitrogen_18, N18);chooseReg(nitrogen_19, N19);chooseReg(nitrogen_20, N20);chooseReg(nitrogen_21, N21);chooseReg(nitrogen_22, N22);chooseReg(nitrogen_23, N23);chooseReg(nitrogen_24, N24);chooseReg(nitrogen_25, N25); }
	public static void oxygen() {/*oxygen*/chooseReg(oxygen_12, O12);chooseReg(oxygen_13, O13);chooseReg(oxygen_14, O14);chooseReg(oxygen_15, O15);chooseReg(oxygen_16, O16);chooseReg(oxygen_17, O17);chooseReg(oxygen_18, O18);chooseReg(oxygen_19, O19);chooseReg(oxygen_20, O20);chooseReg(oxygen_21, O21);chooseReg(oxygen_22, O22);chooseReg(oxygen_23, O23);chooseReg(oxygen_24, O24);chooseReg(oxygen_25, O25);chooseReg(oxygen_26, O26); chooseReg(oxygen_27, O27);chooseReg(oxygen_28, O28); }
	public static void fluorine() {/*fluorine*/chooseReg(fluorine_14, F14);chooseReg(fluorine_15, F15);chooseReg(fluorine_16, F16);chooseReg(fluorine_17, F17);chooseReg(fluorine_18, F18);chooseReg(fluorine_19, F19);chooseReg(fluorine_20, F20);chooseReg(fluorine_21, F21);chooseReg(fluorine_22, F22);chooseReg(fluorine_23, F23);chooseReg(fluorine_24, F24);chooseReg(fluorine_25, F25);chooseReg(fluorine_26, F26);chooseReg(fluorine_27, F27);chooseReg(fluorine_28, F28);chooseReg(fluorine_29, F29);chooseReg(fluorine_30, F30);chooseReg(fluorine_31, F31); }
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

class ModBlocks {

	public ModBlocks() { register(new Identifier("elementera","distillation_machine"), new MachineBlock(AbstractBlock.Settings.of(Material.STONE).strength(3.5F).lightLevel(createLightLevelFromBlockState(13)))); }
	private static void register(Identifier id, Block block) {
		Registry.register(Registry.BLOCK, id, block);
	}
	private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel) {
		return (blockState) -> (Boolean)blockState.get(Properties.LIT) ? litLevel : 0;
	}
}class BlockRegister {
	public static void registerBlock(String modid, String blockName, Block block, Item.Settings settings) {
		Registry.register(Registry.BLOCK, new Identifier(modid, blockName), block);
		log("block register", "regblock " + blockName);
		Registry.register(Registry.ITEM, new Identifier(modid, blockName), new BlockItem(block, settings));
		log("block register", "regblockitem" + blockName);
	}
	public static void registerContainer(Identifier identifier, Block block, Item.Settings settings) {
		Registry.register(Registry.BLOCK, identifier, block);
		Registry.register(Registry.ITEM, identifier, new BlockItem(block, settings));
		log("block register", "register container!");
	}
}
