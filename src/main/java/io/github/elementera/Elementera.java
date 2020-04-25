package io.github.elementera;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.List;

import static io.github.elementera.Public.*;
import static net.minecraft.item.Items.*;

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
		registerItem("carbon_12", C12);

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
class Public implements Loggers {
	public static final Item PROTIUM = new Protium();public static final Item DEUTERIUM = new Deuterium();
	public static final Item TRITIUM = new Tritium();public static final Item He2 = new He2();
	public static final Item He3 = new He3();public static final Item He4 = new He4();
	public static final Item He5 = new He5();public static final Item He6 = new He6();
	public static final Item He7 = new He7();public static final Item He8 = new He8();
	public static final Item He9 = new He9();public static final Item He10 = new He10();
	public static final Item Li6 = new Li6();public static final Item Li7 = new Li7();
	public static final Item Be7 = new Be7();public static final Item Be8 = new Be8();
	public static final Item Be9 = new Be9();public static final Item Be10 = new Be10();
	public static final Item B6 = new B6();public static final Item B7 = new B7();
	public static final Item B8 = new B8();public static final Item B9 = new B9();
	public static final Item B10 = new B10();public static final Item B11 = new B11();
	public static final Item B12 = new B12();public static final Item B13 = new B13();
	public static final Item B14 = new B14();public static final Item B15 = new B15();
	public static final Item B16 = new B16();public static final Item B17 = new B17();
	public static final Item B18 = new B18();public static final Item B19 = new B19();
	public static final Item C8 = new C8();public static final Item C9 = new C9();
	public static final Item C10 = new C10();public static final Item C11 = new C11();
	public static final Item C12 = new C12();public static final Item C13 = new C13();
	public static final Item C14 = new C14();public static final Item C15 = new C15();
	public static final Item C16 = new C16();public static final Item C17 = new C17();
	public static final Item C18 = new C18();public static final Item C19 = new C19();
	public static final Item C20 = new C20();public static final Item C21 = new C21();
	public static final Item C22 = new C22();public static final Item N10 = new N10();
	public static final Item N11 = new N11();public static final Item N12 = new N12();
	public static final Item N13 = new N13();public static final Item N14 = new N14();
	public static final Item N15 = new N15();public static final Item N16 = new N16();
	public static final Item N17 = new N17();public static final Item N18 = new N18();
	public static final Item N19 = new N19();public static final Item N20 = new N20();
	public static final Item N21 = new N21();public static final Item N22 = new N22();
	public static final Item N23 = new N23();public static final Item N24 = new N24();
	public static final Item N25 = new N25();public static final Item O13 = new O13();
	public static final Item O14 = new O14();public static final Item O15 = new O15();
	public static final Item O16 = new O16();public static final Item O17 = new O17();
	public static final Item O18 = new O18();public static final Item O19 = new O19();
	public static final Item O20 = new O20();public static final Item O21 = new O21();
	public static final Item O22 = new O22();public static final Item O23 = new O23();
	public static final Item O24 = new O24();
	public static final String MODID = "elementera";
	public static final ItemGroup GAS = FabricItemGroupBuilder.create(
			new Identifier(MODID, "gas")).icon(() -> new ItemStack(AIR))
			.appendItems(itemStacks -> {
				itemStacks.add(new ItemStack(PROTIUM));itemStacks.add(new ItemStack(He4));
				itemStacks.add(new ItemStack(N14));itemStacks.add(new ItemStack(O16));

				itemStacks.add(new ItemStack(DEUTERIUM));itemStacks.add(new ItemStack(TRITIUM));
				itemStacks.add(new ItemStack(He2));itemStacks.add(new ItemStack(He3));
				itemStacks.add(new ItemStack(He5));itemStacks.add(new ItemStack(He6));
				itemStacks.add(new ItemStack(He7));itemStacks.add(new ItemStack(He8));
				itemStacks.add(new ItemStack(He9));itemStacks.add(new ItemStack(He10));
				itemStacks.add(new ItemStack(N10));itemStacks.add(new ItemStack(N11));
				itemStacks.add(new ItemStack(N12));itemStacks.add(new ItemStack(N13));
				itemStacks.add(new ItemStack(N15));itemStacks.add(new ItemStack(N16));
				itemStacks.add(new ItemStack(N17));itemStacks.add(new ItemStack(N18));
				itemStacks.add(new ItemStack(N19));itemStacks.add(new ItemStack(N19));
				itemStacks.add(new ItemStack(N20));itemStacks.add(new ItemStack(N21));
				itemStacks.add(new ItemStack(N22));itemStacks.add(new ItemStack(N23));
				itemStacks.add(new ItemStack(N24));itemStacks.add(new ItemStack(N25));
				itemStacks.add(new ItemStack(O17));itemStacks.add(new ItemStack(O18));
				itemStacks.add(new ItemStack(O19));itemStacks.add(new ItemStack(O20));
				itemStacks.add(new ItemStack(O21));itemStacks.add(new ItemStack(O22));
				itemStacks.add(new ItemStack(O23));itemStacks.add(new ItemStack(O24));
			}).build();
	public static final ItemGroup METALS = FabricItemGroupBuilder.create(
			new Identifier(MODID, "metals")).icon(() -> new ItemStack(IRON_INGOT))
			.appendItems(itemStacks -> {
				itemStacks.add(new ItemStack(Li7));itemStacks.add(new ItemStack(Be8));

				itemStacks.add(new ItemStack(Li6));itemStacks.add(new ItemStack(Be7));
				itemStacks.add(new ItemStack(Be9));itemStacks.add(new ItemStack(Be10));
			}).build();
	public static final ItemGroup NONMETALS = FabricItemGroupBuilder.create(
			new Identifier(MODID, "nonmetals")).icon(() -> new ItemStack(FLINT))
			.appendItems(itemStacks -> {
				itemStacks.add(new ItemStack(B6));itemStacks.add(new ItemStack(B7));
				itemStacks.add(new ItemStack(B7));itemStacks.add(new ItemStack(B8));
				itemStacks.add(new ItemStack(B9));itemStacks.add(new ItemStack(B10));
				itemStacks.add(new ItemStack(B11));itemStacks.add(new ItemStack(B12));
				itemStacks.add(new ItemStack(B13));itemStacks.add(new ItemStack(B14));
				itemStacks.add(new ItemStack(B15));itemStacks.add(new ItemStack(B16));
				itemStacks.add(new ItemStack(B17));itemStacks.add(new ItemStack(B18));
				itemStacks.add(new ItemStack(B19));itemStacks.add(new ItemStack(C8));
				itemStacks.add(new ItemStack(C9));itemStacks.add(new ItemStack(C10));
				itemStacks.add(new ItemStack(C11));itemStacks.add(new ItemStack(C12));
				itemStacks.add(new ItemStack(C13));itemStacks.add(new ItemStack(C14));
				itemStacks.add(new ItemStack(C15));itemStacks.add(new ItemStack(C16));
				itemStacks.add(new ItemStack(C17));itemStacks.add(new ItemStack(C18));
				itemStacks.add(new ItemStack(C19));itemStacks.add(new ItemStack(C20));
				itemStacks.add(new ItemStack(C21));itemStacks.add(new ItemStack(C22));
			}).build();
	public Public() {
		publics.info("nonmetals have a " + NONMETALS.getIndex());publics.info("metals have a " + METALS.getIndex());
		publics.info("gas have a " + GAS.getIndex());publics.info("public static final");
	}
}
