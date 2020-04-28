package io.github.elementera.energy;

import io.github.elementera.Loggers;

import java.io.*;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class ElementAmpere implements Loggers {
    public static final long b = 1L;
    public static final Properties p = new Properties();
    public ElementAmpere() {
        writter();
    }

    public static void writter() {
        File name = new File("config");
        File file = new File("config" + File.separator + File.separator +  "fabric");
        File ampFile = new File("config" + File.separator + File.separator +  "fabric" + File.separator + File.separator + "energy");
        if (!name.exists() && !name.isDirectory()) name.mkdir();
        if (!file.exists() && !file.isDirectory()) file.mkdir();
        if (!ampFile.exists() && !ampFile.isDirectory()) ampFile.mkdir();
        try {
            p.load(new BufferedInputStream(new FileInputStream("config" + File.separator + File.separator +  "fabric" + File.separator + File.separator + "energy"+ File.separator + File.separator + "BoPt.ee")));
        } catch (FileNotFoundException e) {
            p.put("BoPt", "0");
            try {
                FileOutputStream outputStream = new FileOutputStream("config" + File.separator + File.separator +  "fabric" + File.separator + File.separator + "energy"+ File.separator + File.separator + "BoPt.ee");
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
            FileOutputStream outputStream = new FileOutputStream("config" + File.separator + File.separator +  "fabric" + File.separator + File.separator + "energy"+ File.separator + File.separator + "BoPt.ee");
            p.setProperty(string, String.valueOf(a));
            p.store(outputStream, "Save Configs File.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


