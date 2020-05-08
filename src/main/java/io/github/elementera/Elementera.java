package io.github.elementera;

import io.github.elementera.config.*;
import io.github.elementera.energy.ElementAmpere;
import io.github.elementera.items.Public;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.*;

import java.io.*;

import static io.github.elementera.Elementera.log;
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
	public static void log(String s1, String s2) {
		Logger logger = LogManager.getLogger(s1); logger.info(s2);
	}
	public static final String s = "OnInitializes";
	@Override
	public void onInitialize() {
		proxy();
		log(s, "element era mods OnInitializes!");
	}
	public static void proxy() { new Proxies(); log(s, "proxy oninitialize"); }
}
class Proxies {
	public static final String s = "proxy";
	public Proxies() {
		modBlock(); config(); publicS(); energy();
		removeItemConfig();if (removeItemConfig()) modItem();
		fluids();
	}
	public static void modItem() { new ModItems(); log(s, "moditem register"); }
	public static void modBlock() { new ModBlocks(); log(s, "modblock register");}
	public static void config() { new Config(); log(s, "config register"); }
	public static boolean removeItemConfig() {  new RemoveItemConfig(); return true; }
	public static void publicS() { new Public(); log(s, "public register"); }
	public static void registerItem(String itemName, Item item) {
		ItemsRegister.registerItem(MODID, itemName, item);
	}

	public static void fluids() { new ModFluids(); }
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
	public static void chooseRegTwo(String s1, String s2, Item i1, Item i2) { chooseReg(s1, i1); chooseReg(s2, i2); }
	public static void chooseRegFour(String s1, String s2, String s3, String s4, Item i1, Item i2, Item i3, Item i4) { chooseRegTwo(s1, s2, i1, i2); chooseRegTwo(s3, s4, i3, i4); }
	public ModItems() {
		chooseRegFour("protium", "helium_4", "lithium_7", "beryllium_8", PROTIUM, He4, Li7, Be8);
		chooseRegTwo("carbon_12", "fluorine_19", C12, F19);
		chooseRegFour("helium_5", "deuterium", "tritium", "helium_2", He5, DEUTERIUM, TRITIUM, He2);
		chooseRegFour("helium_3", "helium_6", "helium_7", "helium_8", He3, He6, He7, He8);
		chooseRegTwo("helium_9", "helium_10", He9, He10); chooseRegTwo("lithium_6", "beryllium_7", Li6, Be7);
		chooseRegTwo("beryllium_9", "beryllium_10", Be9, Be10); chooseRegTwo("boron_6", "boron_7", B6, B7);
		chooseRegTwo("boron_8", "boron_9", B8, B9); chooseRegTwo("boron_10", "boron_11", B10, B11);
		chooseRegTwo("boron_12", "boron_13", B12, B13); chooseRegTwo("boron_14", "boron_15", B14, B15);
		chooseRegTwo("boron_16", "boron_17", B16, B17); chooseRegTwo("boron_18", "boron_19", B18, B19);
		chooseRegTwo("carbon_8", "carbon_9", C8, C9); chooseRegTwo("carbon_10", "carbon_11", C10, C11);
		chooseRegTwo("carbon_13", "carbon_14", C13, C14); chooseRegTwo("carbon_15", "carbon_16", C15, C16);
		chooseRegTwo("carbon_17", "carbon_18", C17, C18); chooseRegTwo("carbon_19", "carbon_20", C19, C20);
		chooseRegTwo("carbon_21", "carbon_22", C21, C22); chooseRegTwo("nitrogen_10", "nitrogen_11", N10, N11);
		chooseRegTwo("nitrogen_12", "nitrogen_13", N12, N13); chooseRegTwo("nitrogen_14", "nitrogen_15", N14, N15);
		chooseRegTwo("nitrogen_16", "nitrogen_17", N16, N17); chooseRegTwo("nitrogen_18", "nitrogen_19", N18, N19);
		chooseRegTwo("nitrogen_20", "nitrogen_21", N20, N21); chooseRegTwo("nitrogen_22", "nitrogen_23", N22, N23);
		chooseRegTwo("nitrogen_24", "nitrogen_25", N24, N25); chooseRegTwo("oxygen_13", "oxygen_14", O13, O14);
		chooseRegTwo("oxygen_15", "oxygen_16", O15, O16); chooseRegTwo("oxygen_17", "oxygen_18", O17, O18);
		chooseRegTwo("oxygen_19", "oxygen_20", O19, O20); chooseRegTwo("oxygen_21", "oxygen_22", O21, O22);
		chooseRegTwo("oxygen_23", "oxygen_24", O23, O24); chooseRegTwo("fluorine_14", "fluorine_15", F14, F15);
		chooseRegTwo("fluorine_16", "fluorine_17", F16, F17); chooseRegTwo("fluorine_18", "fluorine_20", F18, F20);
		chooseRegTwo("fluorine_21", "fluorine_22", F21, F22); chooseRegTwo("fluorine_23", "fluorine_24", F23, F24);
		chooseRegTwo("fluorine_25", "fluorine_26", F25, F26); chooseRegTwo("fluorine_27", "fluorine_28", F27, F28);
		chooseRegTwo("fluorine_29", "fluorine_30", F29, F30); chooseReg("fluorine_31", F31);log("items register", "register all item success!");
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
	}
}/*class BlockRegister implements Loggers {
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
}*/
class ModFluids {
	public static WaterFluid FRESH_WATER = new WaterFluid.Still();
	public static WaterFluid FLOWING_FRESH_WATER = new WaterFluid.Flowing();
	public static Block FRESHWATER = new FluidBlock(FRESH_WATER, FabricBlockSettings.copy(Blocks.WATER)){};
	public static final Item BUCKET_FRESHWATER = new BucketItem(FRESH_WATER, new Item.Settings().maxCount(1).group(ItemGroup.MISC));
	public ModFluids() {
		registerFluids("fresh_water", FRESH_WATER, FLOWING_FRESH_WATER, FRESHWATER, BUCKET_FRESHWATER);
	}
	public void registerFluids(String fluidID, WaterFluid stillFluid, WaterFluid flowingFluid, Block fluidBlock, Item item) {
		registerFluid(MODID, fluidID, stillFluid, flowingFluid, fluidBlock, item);
	}
	public static void registerFluid(String modid, String fluidID, WaterFluid stillFluid, WaterFluid flowingFluid, Block fluidBlock, Item item) {
		Registry.register(Registry.FLUID, new Identifier(modid, fluidID), stillFluid);
		Registry.register(Registry.FLUID, new Identifier(modid, "flowing_" + fluidID), flowingFluid);
		Registry.register(Registry.BLOCK, new Identifier(modid, fluidID), fluidBlock);
		Registry.register(Registry.ITEM, new Identifier(modid, fluidID + "_bucket"), item);
	}
}
