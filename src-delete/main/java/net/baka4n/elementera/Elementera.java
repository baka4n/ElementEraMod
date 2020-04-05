package net.baka4n.elementera;
// TODO: 2020/4/3 重新拾取fabric编写
// TODO: 2020/4/4 这个是当时脑洞的时候尝试开发的，具体bbs可查

import net.baka4n.elementera.proxy.ElementProxies;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Elementera implements ModInitializer {
	public static final String modid = "elementera";
	public static final Logger logger = LogManager.getLogger(modid);
	public static Elementera INSTANCE;
	@Override
	public void onInitialize() {
		INSTANCE = this;
		new ElementProxies();
		logger.info(modid);
        System.out.println("Hello Welcome to element era!");
	}
}
