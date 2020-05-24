package io.github.elementera.common.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.Collection;

import static net.minecraft.item.ItemGroup.MISC;
import static net.minecraft.item.Items.*;

public class Public implements Loggers {
	/*hydrogen*/public static final Item PROTIUM, DEUTERIUM, TRITIUM, H4, H5, H6, H7;
	/*helium*/public static final Item He3, He4, He5, He6, He7, He8, He9, He10;
	/*lithium*/public static final Item Li4, Li5, Li6, Li7, Li8, Li9, Li10, Li11, Li12, Li13;
	/*beryllium*/public static final Item Be5, Be6, Be7, Be8, Be9, Be10, Be11, Be12, Be13, Be14, Be15, Be16;
	/*boron*/public static final Item B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21;
	/*carbon*/public static final Item C8, C9, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19, C20, C21, C22, C23;
	/*nitrogen*/public static final Item N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21, N22, N23, N24, N25;
	/*oxygen*/public static final Item O12, O13, O14, O15, O16, O17, O18, O19, O20, O21, O22, O23, O24, O25, O26, O27, O28;
	/*fluorine*/public static final Item F14, F15, F16, F17, F18, F19, F20, F21, F22, F23, F24, F25, F26, F27, F28, F29, F30, F31;
	/*neon*/public static final Item Ne16, Ne17, Ne18, Ne19, Ne20, Ne21, Ne22, Ne23, Ne24, Ne25, Ne26, Ne27, Ne28, Ne29, Ne30, Ne31, Ne32, Ne33, Ne34;
	/*sodium*/public static final Item Na18, Na19;
	/*bucket*/
	public static final Item FRESH_WATER;
	public static final String MODID = "elementera";
	public static Settings gas_set = new Settings().group(Public.GAS).maxCount(16);
	public static Item gas() {
		return new GasAll(gas_set);
	}
	static {
		// 杂乱 不堪 待整理
		Settings myBucket = new Settings().recipeRemainder(BUCKET).maxCount(1).group(MISC);
		Settings nonmetals_set = new Settings().group(Public.NONMETALS).maxCount(16);
		Settings metals_set = new Settings().group(Public.METALS).maxCount(16);
		FRESH_WATER = new MyBucket(myBucket);
		/*hydrogen*/PROTIUM = gas();   DEUTERIUM = gas(); TRITIUM = gas();H4 = gas();  H5 = gas(); H6 = gas(); H7 = gas();
		/*helium*/He3 = gas();  He4 = gas();  He5 = gas();  He6 = gas();He7 = gas();  He8 = gas();  He9 = gas();  He10 = gas();
		/*lithium*/Li4 = new MetalsAll(metals_set);  Li5 = new MetalsAll(metals_set);  Li6 = new MetalsAll(metals_set);  Li7 = new MetalsAll(metals_set);Li8 = new MetalsAll(metals_set);  Li9 = new MetalsAll(metals_set);  Li10 = new MetalsAll(metals_set); Li11= new MetalsAll(metals_set);Li12 = new MetalsAll(metals_set); Li13 = new MetalsAll(metals_set);
		/*beryllium*/Be5 = new MetalsAll(metals_set); Be6 = new MetalsAll(metals_set); Be7 = new MetalsAll(metals_set);Be8 = new MetalsAll(metals_set); Be9 = new MetalsAll(metals_set); Be10 = new MetalsAll(metals_set);Be11 = new MetalsAll(metals_set); Be12 = new MetalsAll(metals_set); Be13 = new MetalsAll(metals_set);Be14 = new MetalsAll(metals_set); Be15 = new MetalsAll(metals_set); Be16 = new MetalsAll(metals_set);
		/*boron*/B7  = new NonMetalsAll(nonmetals_set);B8  = new NonMetalsAll(nonmetals_set); B9  = new NonMetalsAll(nonmetals_set);B10 = new NonMetalsAll(nonmetals_set); B11 = new NonMetalsAll(nonmetals_set); B12 = new NonMetalsAll(nonmetals_set);B13 = new NonMetalsAll(nonmetals_set); B14 = new NonMetalsAll(nonmetals_set); B15 = new NonMetalsAll(nonmetals_set);B16 = new NonMetalsAll(nonmetals_set); B17 = new NonMetalsAll(nonmetals_set); B18 = new NonMetalsAll(nonmetals_set);B19 = new NonMetalsAll(nonmetals_set); B20 = new NonMetalsAll(nonmetals_set); B21 = new NonMetalsAll(nonmetals_set);
		/*carbon*/C8  = new NonMetalsAll(nonmetals_set); C9  = new NonMetalsAll(nonmetals_set); C10 = new NonMetalsAll(nonmetals_set);C11 = new NonMetalsAll(nonmetals_set); C12 = new NonMetalsAll(nonmetals_set); C13 = new NonMetalsAll(nonmetals_set);C14 = new NonMetalsAll(nonmetals_set); C15 = new NonMetalsAll(nonmetals_set); C16 = new NonMetalsAll(nonmetals_set);C17 = new NonMetalsAll(nonmetals_set); C18 = new NonMetalsAll(nonmetals_set); C19 = new NonMetalsAll(nonmetals_set);C20 = new NonMetalsAll(nonmetals_set); C21 = new NonMetalsAll(nonmetals_set); C22 = new NonMetalsAll(nonmetals_set);C23 = new NonMetalsAll(nonmetals_set);
		/*nitrogen*/N10 = gas();  N11 = gas();  N12 = gas();  N13 = gas();  N14 = gas();  N15 = gas();  N16 = gas();N17 = gas();  N18 = gas();  N19 = gas();  N20 = gas();N21 = gas();  N22 = gas();  N23 = gas();  N24 = gas();N25 = gas();
		/*oxygen*/O12 = gas();  O13 = gas();  O14 = gas();  O15 = gas();  O16 = gas();  O17 = gas();  O18 = gas();  O19 = gas();O20 = gas();  O21 = gas();  O22 = gas();  O23 = gas();O24 = gas();  O25 = gas();  O26 = gas();  O27 = gas();O28 = gas();
		/*fluorine*/F14 = gas();  F15 = gas();  F16 = gas();  F17 = gas();  F18 = gas();  F19 = gas();  F20 = gas();F21 = gas();  F22 = gas();  F23 = gas();  F24 = gas();F25 = gas();  F26 = gas();  F27 = gas();  F28 = gas();F29 = gas();  F30 = gas();  F31 = gas();
		/*neon*/Ne16 = gas(); Ne17 = gas(); Ne18 = gas(); Ne19 = gas();  Ne20 = gas(); Ne21 = gas(); Ne22 = gas();  Ne23 = gas();  Ne24 = gas();  Ne25 = gas();  Ne26 = gas();  Ne27 = gas();  Ne28 = gas();  Ne29 = gas();  Ne30 = gas();  Ne31 = gas();  Ne32 = gas();  Ne33 = gas();  Ne34 = gas();
		/*sodium*/Na18 = new MetalsAll(metals_set); Na19 = new MetalsAll(metals_set);
	}

	public static ArrayList<ItemStack> arr() {
		return new ArrayList<>();
	}
	public static Collection<ItemStack> h = arr(), he = arr(), n =arr(), o = arr(), f = arr();
	static {
		h.add(s(PROTIUM));h.add(s(DEUTERIUM));h.add(s(TRITIUM));h.add(s(H4));h.add(s(H5));
		h.add(s(H6));h.add(s(H7));he.add(s(He3));he.add(s(He4));he.add(s(He5));
		he.add(s(He6));he.add(s(He7));he.add(s(He8));he.add(s(He9));he.add(s(He10));
		n.add(s(N10));n.add(s(N11));n.add(s(N12));n.add(s(N13));n.add(s(N14));
		n.add(s(N15));n.add(s(N16));n.add(s(N17));n.add(s(N18));n.add(s(N19));
		n.add(s(N19));n.add(s(N20));n.add(s(N21));n.add(s(N22));n.add(s(N23));
		n.add(s(N24));n.add(s(N25));o.add(s(O12));o.add(s(O13));o.add(s(O14));
		o.add(s(O15));o.add(s(O16));o.add(s(O17));o.add(s(O18));o.add(s(O19));
		o.add(s(O20));o.add(s(O21));o.add(s(O22));o.add(s(O23));o.add(s(O24));
		o.add(s(O25));o.add(s(O26));o.add(s(O27));o.add(s(O28));f.add(s(F14));
		f.add(s(F15));f.add(s(F16));f.add(s(F17));f.add(s(F18));f.add(s(F19));
		f.add(s(F20));f.add(s(F21));f.add(s(F22));f.add(s(F23));f.add(s(F24));
		f.add(s(F25));f.add(s(F26));f.add(s(F27));f.add(s(F28));f.add(s(F29));
		f.add(s(F30));f.add(s(F31));
	}
	public static ItemStack s(Item i) {
		return new ItemStack(i);
	}
	public static final ItemGroup GAS = FabricItemGroupBuilder.create(
			new Identifier(MODID, "gas")).icon(() -> s(AIR))
			.appendItems(i -> {
				i.addAll(h);i.addAll(he);i.addAll(n);i.addAll(o); i.addAll(f);
			}).build();
	public static final ItemGroup METALS = FabricItemGroupBuilder.create(
			new Identifier(MODID, "metals")).icon(() -> s(IRON_INGOT))
			.appendItems(i -> {
				i.add(s(Li4)); i.add(s(Li5)); i.add(s(Li6)); i.add(s(Li7));
				i.add(s(Li8)); i.add(s(Li9)); i.add(s(Li10)); i.add(s(Li11));
				i.add(s(Li12)); i.add(s(Li13));
				i.add(s(Be7)); i.add(s(Be8));
				i.add(s(Be9));i.add(s(Be10));
			}).build();
	public static final ItemGroup NONMETALS = FabricItemGroupBuilder.create(
			new Identifier(MODID, "nonmetals")).icon(() -> s(FLINT))
			.appendItems(i -> {
				i.add(s(B7));
				i.add(s(B7));i.add(s(B8));
				i.add(s(B9));i.add(s(B10));
				i.add(s(B11));i.add(s(B12));
				i.add(s(B13));i.add(s(B14));
				i.add(s(B15));i.add(s(B16));
				i.add(s(B17));i.add(s(B18));
				i.add(s(B19));i.add(s(C8));
				i.add(s(C9));i.add(s(C10));
				i.add(s(C11));i.add(s(C12));
				i.add(s(C13));i.add(s(C14));
				i.add(s(C15));i.add(s(C16));
				i.add(s(C17));i.add(s(C18));
				i.add(s(C19));i.add(s(C20));
				i.add(s(C21));i.add(s(C22));
			}).build();
	public Public() {
		publics.info("nonmetals have a " + NONMETALS.getIndex());publics.info("metals have a " + METALS.getIndex());
		publics.info("gas have a " + GAS.getIndex());publics.info("public static final");
	}
}
interface Loggers {
	Logger publics = LogManager.getLogger("public load");
}