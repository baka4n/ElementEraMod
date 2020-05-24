package io.github.elementera.energy;

import io.github.elementera.api.config.有序排列对;
import java.io.*;
import static io.github.elementera.api.config.Config.*;
import static java.lang.Thread.sleep;

public class ElementAmpere {
    public static final long b = 1L;
    public static final 有序排列对 p = new 有序排列对();
    public ElementAmpere() {
        writter();
    }

    public static void writter() {
        mkDirs("config");
        mkDirs("config" + s +  "fabric");
        mkDirs("config" + s +  "fabric" + s + "energy");
        try {
            p.load(new BufferedInputStream(new FileInputStream("config" + s +  "fabric" + s + "energy"+ s + "BoPt.ee")));
        } catch (FileNotFoundException e) {
            p.put("BoPt", "0");
            try {
                FileOutputStream outputStream = new FileOutputStream("config" + s +  "fabric" + s + "energy"+ s + "BoPt.ee");
                p.store(new BufferedOutputStream(outputStream),
                        "Save Configs File.");
            }
            catch (IOException f) { f.printStackTrace(); }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void tick(long timeInterval, String Key, long c) {
        // basic of the power! ampere max lang 3000L
        Runnable runnable = () -> {
            String string = p.getProperty(Key);
            if (Integer.parseInt(string) >= 90000L) string = String.valueOf(90000L);
            long a = Long.parseLong(string);
            do {
                if (a >= c) {
                    a = c;
                } else if (a < 0L) {
                    a = 0L;
                } else {
                    a += b;
                    output(Key, a);
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

    public static void output(String string,long a){
        try {
            FileOutputStream outputStream = new FileOutputStream("config" + s +  "fabric" + s + "energy"+ s + "BoPt.ee");
            p.setProperty(string, String.valueOf(a));
            p.store(outputStream, "Save Configs File.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


