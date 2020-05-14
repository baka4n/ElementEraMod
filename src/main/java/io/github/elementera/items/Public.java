package io.github.elementera.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraft.item.ItemGroup.MISC;
import static net.minecraft.item.Items.*;

public class Public implements Loggers {
	public static void main(String[] args) { }
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
	public static final Item O24 = new O24();public static final Item F14 = new F14();
	public static final Item F15 = new F15();public static final Item F16 = new F16();
	public static final Item F17 = new F17();public static final Item F18 = new F18();
	public static final Item F19 = new F19();public static final Item F20 = new F20();
	public static final Item F21 = new F21();public static final Item F22 = new F22();
	public static final Item F23 = new F23();public static final Item F24 = new F24();
	public static final Item F25 = new F25();public static final Item F26 = new F26();
	public static final Item F27 = new F27();public static final Item F28 = new F28();
	public static final Item F29 = new F29();public static final Item F30 = new F30();
	public static final Item F31 = new F31();public static final Item FRESH_WATER = new MyBucket(new Item.Settings().recipeRemainder(BUCKET).maxCount(1).group(MISC));
	public static final String MODID = "elementera";
	public static final ItemGroup GAS = FabricItemGroupBuilder.create(
			new Identifier(MODID, "gas")).icon(() -> new ItemStack(AIR))
			.appendItems(itemStacks -> {
				itemStacks.add(new ItemStack(PROTIUM));itemStacks.add(new ItemStack(He4));
				itemStacks.add(new ItemStack(N14));itemStacks.add(new ItemStack(O16));
				itemStacks.add(new ItemStack(F19));

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
				itemStacks.add(new ItemStack(F14));itemStacks.add(new ItemStack(F15));
				itemStacks.add(new ItemStack(F16));itemStacks.add(new ItemStack(F17));
				itemStacks.add(new ItemStack(F18));itemStacks.add(new ItemStack(F20));
				itemStacks.add(new ItemStack(F21));itemStacks.add(new ItemStack(F22));
				itemStacks.add(new ItemStack(F23));itemStacks.add(new ItemStack(F24));
				itemStacks.add(new ItemStack(F25));itemStacks.add(new ItemStack(F26));
				itemStacks.add(new ItemStack(F27));itemStacks.add(new ItemStack(F28));
				itemStacks.add(new ItemStack(F29));itemStacks.add(new ItemStack(F30));
				itemStacks.add(new ItemStack(F31));
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
interface Loggers {
	Logger publics = LogManager.getLogger("public load");
}