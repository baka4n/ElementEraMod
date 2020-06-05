package io.github.elementera.api.common.items;

import io.github.elementera.api.config.CenterConfig;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;

import static net.minecraft.util.registry.Registry.*;

public class RegisterItem {
    public static final Settings s0, s1;
    static {
        s0 = new Settings();s1 = DCount(s0);
    }
    public RegisterItem() {
        Reg("hydrogen", get(s1));
    }
    public static Item get(Settings settings) {
        return new GetSetting(settings);
    }
    public static void Reg(String s, Item item) {
        register(ITEM, "elementera:" + s, item);
    }
    public static Settings DCount(Settings settings) {
        return settings.maxCount(getPint("dcount"));//default count
    }
    // get center config load
    public static double getPDouble(String s) { return Double.parseDouble(s); }
    public static short getPShort(String s) { return Short.parseShort(s); }
    public static long getPLong(String s) { return Long.parseLong(s); }
    public static boolean getPBoolean(String s) { return Boolean.parseBoolean(s); }
    public static String getPString(String s) { return CenterConfig.getConfig.getProperty(s); }
    public static int getPint(String s) { return Integer.parseInt(CenterConfig.getConfig.getProperty(s)); }
}
class GetSetting extends Item {
    public GetSetting(Settings settings) { super(settings); }
}
