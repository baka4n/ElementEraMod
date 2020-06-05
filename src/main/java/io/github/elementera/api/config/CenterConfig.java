package io.github.elementera.api.config;

import java.io.*;

/**
 * @author baka4n
 * <p>
 *     基础配置文件
 * </p>
 */
public class CenterConfig {
    public static final String s = File.separator, ss = s + s, config = "config", elementera_c = config + ss + "elementera", config_f = elementera_c + ss + "center.config";
    public static final MyProperties getConfig = new MyProperties();
    public static void config() {
        String a2 = elementera_c + ss + "center.config";
        File configs = new File(config), elementera = new File(elementera_c);
        ifs(configs); ifs(elementera);
        try {
            load(config_f);
        } catch (FileNotFoundException e) {
            put("used_config", "false");put("config", "load success");put("dcount", "16");
            try { store(getConfig, config_f, "save Config."); } catch (IOException f) { f.printStackTrace(); }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void ifs(File a) { if (!exists(a) && !isDirectory(a)) a.mkdir(); }
    public static void put(String a, String a1) { getConfig.put(a, a1); }
    public static void load(String a) throws IOException { getConfig.load(new BufferedInputStream(new FileInputStream(a))); }
    public static void store(MyProperties m, String s, String s1) throws IOException { m.store(new BufferedOutputStream(new FileOutputStream(s)), s1); }
    public static boolean exists(File a) { return a.exists(); }
    public static boolean isDirectory(File a) { return a.isDirectory(); }
}
