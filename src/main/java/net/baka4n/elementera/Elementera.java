package net.baka4n.elementera;
// TODO: 2020/4/3 重新拾取fabric编写
import net.baka4n.elementera.itemgroup.Gas;
import net.baka4n.elementera.itemsettings.Hydrogen;
import net.baka4n.elementera.itemsettings.Oxygen;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Elementera implements ModInitializer {
	public static final String modid = "elementera";
	public static final Logger logger = LogManager.getLogger(modid);
	public static Elementera INSTANCE;
	public static final Hydrogen hydrogen = new Hydrogen(new Item.Settings()
			.maxCount(16)
			.group(Gas.Gas));
	public static final Oxygen oxygen = new Oxygen(new Item.Settings()
			.group(Gas.Gas)
			.maxCount(16)
			.group(Gas.Gas));
	@Override
	public void onInitialize() {
		INSTANCE = this;
		Registry.register(Registry.ITEM, new Identifier(modid, "hydrogen"), hydrogen);
		Registry.register(Registry.ITEM, new Identifier(modid, "oxygen"), oxygen);
		System.out.println(modid);
		System.out.println("hello minecraft!welcome to element era mod!");
	}
}
