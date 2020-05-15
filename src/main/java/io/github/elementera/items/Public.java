package io.github.elementera.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.*;

import static net.minecraft.item.ItemGroup.MISC;
import static net.minecraft.item.Items.*;

public class Public implements Loggers {
	// hydrogen
	public static final Item PROTIUM;public static final Item DEUTERIUM;public static final Item TRITIUM;public static final Item H4;public static final Item H5;public static final Item H6;public static final Item H7;
	// helium
	public static final Item He3;public static final Item He4;public static final Item He5;public static final Item He6;public static final Item He7;public static final Item He8;public static final Item He9;public static final Item He10;
	// lithium
	public static final Item Li4;public static final Item Li5;public static final Item Li6;public static final Item Li7;public static final Item Li8;public static final Item Li9;public static final Item Li10;public static final Item Li11;public static final Item Li12;public static final Item Li13;
	// beryllium
	public static final Item Be5;public static final Item Be6;public static final Item Be7;public static final Item Be8;public static final Item Be9;public static final Item Be10;public static final Item Be11;public static final Item Be12;public static final Item Be13;public static final Item Be14;public static final Item Be15;public static final Item Be16;
	// boron
	public static final Item B7;public static final Item B8;public static final Item B9;public static final Item B10;public static final Item B11;public static final Item B12;public static final Item B13;public static final Item B14;public static final Item B15;public static final Item B16;public static final Item B17;public static final Item B18;public static final Item B19;public static final Item B20;public static final Item B21;
	// carbon
	public static final Item C8;public static final Item C9;public static final Item C10;public static final Item C11;public static final Item C12;public static final Item C13;public static final Item C14;public static final Item C15;public static final Item C16;public static final Item C17;public static final Item C18;public static final Item C19;public static final Item C20;public static final Item C21;public static final Item C22;public static final Item C23;
	// nitrogen
	public static final Item N10;public static final Item N11;public static final Item N12;public static final Item N13;public static final Item N14;public static final Item N15;public static final Item N16;public static final Item N17;public static final Item N18;public static final Item N19;public static final Item N20;public static final Item N21;public static final Item N22;public static final Item N23;public static final Item N24;public static final Item N25;
	// oxygen
	public static final Item O12;public static final Item O13;public static final Item O14;public static final Item O15;public static final Item O16;public static final Item O17;public static final Item O18;public static final Item O19;public static final Item O20;public static final Item O21;public static final Item O22;public static final Item O23;public static final Item O24;public static final Item O25;public static final Item O26;public static final Item O27;public static final Item O28;
	// fluorine
	public static final Item F14;public static final Item F15;public static final Item F16;public static final Item F17;public static final Item F18;public static final Item F19;public static final Item F20;public static final Item F21;public static final Item F22;public static final Item F23;public static final Item F24;public static final Item F25;public static final Item F26;public static final Item F27;public static final Item F28;public static final Item F29;public static final Item F30;public static final Item F31;
	// neon
	public static final Item Ne16;public static final Item Ne17;public static final Item Ne18;public static final Item Ne19;public static final Item Ne20;public static final Item Ne21;
	// bucket
	public static final Item FRESH_WATER;
	public static final String MODID = "elementera";
	static {
		// 杂乱 不堪 待整理
		Settings myBucket = new Settings().recipeRemainder(BUCKET).maxCount(1).group(MISC);
		Settings nonmetals_set = new Settings().group(Public.NONMETALS).maxCount(16);
		Settings metals_set = new Settings().group(Public.METALS).maxCount(16);
		Settings gas_set = new Settings().group(Public.GAS).maxCount(16);
		FRESH_WATER = new MyBucket(myBucket);
		PROTIUM = new GasAll(gas_set);   DEUTERIUM = new GasAll(gas_set); TRITIUM = new GasAll(gas_set);
		H4 = new GasAll(gas_set);  H5 = new GasAll(gas_set); H6 = new GasAll(gas_set); H7 = new GasAll(gas_set);
		He3 = new GasAll(gas_set);  He4 = new GasAll(gas_set);  He5 = new GasAll(gas_set);  He6 = new GasAll(gas_set);
		He7 = new GasAll(gas_set);  He8 = new GasAll(gas_set);  He9 = new GasAll(gas_set);  He10 = new GasAll(gas_set);
		Li4 = new MetalsAll(metals_set);  Li5 = new MetalsAll(metals_set);  Li6 = new MetalsAll(metals_set);  Li7 = new MetalsAll(metals_set);
		Li8 = new MetalsAll(metals_set);  Li9 = new MetalsAll(metals_set);  Li10 = new MetalsAll(metals_set); Li11= new MetalsAll(metals_set);
		Li12 = new MetalsAll(metals_set); Li13 = new MetalsAll(metals_set);
		// beryllium
		Be5 = new MetalsAll(metals_set); Be6 = new MetalsAll(metals_set); Be7 = new MetalsAll(metals_set);
		Be8 = new MetalsAll(metals_set); Be9 = new MetalsAll(metals_set); Be10 = new MetalsAll(metals_set);
		Be11 = new MetalsAll(metals_set); Be12 = new MetalsAll(metals_set); Be13 = new MetalsAll(metals_set);
		Be14 = new MetalsAll(metals_set); Be15 = new MetalsAll(metals_set); Be16 = new MetalsAll(metals_set);
		// boron
		B7  = new NonMetalsAll(nonmetals_set);B8  = new NonMetalsAll(nonmetals_set); B9  = new NonMetalsAll(nonmetals_set);
		B10 = new NonMetalsAll(nonmetals_set); B11 = new NonMetalsAll(nonmetals_set); B12 = new NonMetalsAll(nonmetals_set);
		B13 = new NonMetalsAll(nonmetals_set); B14 = new NonMetalsAll(nonmetals_set); B15 = new NonMetalsAll(nonmetals_set);
		B16 = new NonMetalsAll(nonmetals_set); B17 = new NonMetalsAll(nonmetals_set); B18 = new NonMetalsAll(nonmetals_set);
		B19 = new NonMetalsAll(nonmetals_set); B20 = new NonMetalsAll(nonmetals_set); B21 = new NonMetalsAll(nonmetals_set);
		// carbon
		C8  = new NonMetalsAll(nonmetals_set); C9  = new NonMetalsAll(nonmetals_set); C10 = new NonMetalsAll(nonmetals_set);
		C11 = new NonMetalsAll(nonmetals_set); C12 = new NonMetalsAll(nonmetals_set); C13 = new NonMetalsAll(nonmetals_set);
		C14 = new NonMetalsAll(nonmetals_set); C15 = new NonMetalsAll(nonmetals_set); C16 = new NonMetalsAll(nonmetals_set);
		C17 = new NonMetalsAll(nonmetals_set); C18 = new NonMetalsAll(nonmetals_set); C19 = new NonMetalsAll(nonmetals_set);
		C20 = new NonMetalsAll(nonmetals_set); C21 = new NonMetalsAll(nonmetals_set); C22 = new NonMetalsAll(nonmetals_set);
		C23 = new NonMetalsAll(nonmetals_set);
		// nitrogen
		N10 = new GasAll(gas_set);  N11 = new GasAll(gas_set);  N12 = new GasAll(gas_set);
		N13 = new GasAll(gas_set);  N14 = new GasAll(gas_set);  N15 = new GasAll(gas_set);  N16 = new GasAll(gas_set);
		N17 = new GasAll(gas_set);  N18 = new GasAll(gas_set);  N19 = new GasAll(gas_set);  N20 = new GasAll(gas_set);
		N21 = new GasAll(gas_set);  N22 = new GasAll(gas_set);  N23 = new GasAll(gas_set);  N24 = new GasAll(gas_set);
		N25 = new GasAll(gas_set);
		// oxygen
		O12 = new GasAll(gas_set);  O13 = new GasAll(gas_set);  O14 = new GasAll(gas_set);  O15 = new GasAll(gas_set);
		O16 = new GasAll(gas_set);  O17 = new GasAll(gas_set);  O18 = new GasAll(gas_set);  O19 = new GasAll(gas_set);
		O20 = new GasAll(gas_set);  O21 = new GasAll(gas_set);  O22 = new GasAll(gas_set);  O23 = new GasAll(gas_set);
		O24 = new GasAll(gas_set);  O25 = new GasAll(gas_set);  O26 = new GasAll(gas_set);  O27 = new GasAll(gas_set);
		O28 = new GasAll(gas_set);
		// fluorine
		F14 = new GasAll(gas_set);  F15 = new GasAll(gas_set);  F16 = new GasAll(gas_set);
		F17 = new GasAll(gas_set);  F18 = new GasAll(gas_set);  F19 = new GasAll(gas_set);  F20 = new GasAll(gas_set);
		F21 = new GasAll(gas_set);  F22 = new GasAll(gas_set);  F23 = new GasAll(gas_set);  F24 = new GasAll(gas_set);
		F25 = new GasAll(gas_set);  F26 = new GasAll(gas_set);  F27 = new GasAll(gas_set);  F28 = new GasAll(gas_set);
		F29 = new GasAll(gas_set);  F30 = new GasAll(gas_set);  F31 = new GasAll(gas_set);
		// neon
		Ne16 = new GasAll(gas_set); Ne17 = new GasAll(gas_set); Ne18 = new GasAll(gas_set); Ne19 = new GasAll(gas_set);
		Ne20 = new GasAll(gas_set);Ne21 = new GasAll(gas_set);
	}
	public static final ItemGroup GAS = FabricItemGroupBuilder.create(
			new Identifier(MODID, "gas")).icon(() -> new ItemStack(AIR))
			.appendItems(itemStacks -> {
				itemStacks.add(new ItemStack(PROTIUM));itemStacks.add(new ItemStack(He4));
				itemStacks.add(new ItemStack(N14));itemStacks.add(new ItemStack(O16));
				itemStacks.add(new ItemStack(F19));

				itemStacks.add(new ItemStack(DEUTERIUM));itemStacks.add(new ItemStack(TRITIUM));
				itemStacks.add(new ItemStack(He3));
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
				itemStacks.add(new ItemStack(B7));
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