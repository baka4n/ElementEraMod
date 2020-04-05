package net.baka4n.elementera;

import net.baka4n.elementera.core.proxy.ElementProxies;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// TODO: 2020/4/5 之前出了点问题重写一下
public class Elementera implements ModInitializer {
    public static final String modid = "elementera";
    public static final Logger logger = LogManager.getLogger(modid);
    public static Elementera Instance;
    @Override
    public void onInitialize() {
        Instance = this;
        new ElementProxies();
        System.out.println("welcome to used to this mod");
    }
}
