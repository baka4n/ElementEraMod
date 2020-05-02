package io.github.elementera.gui;

import io.github.elementera.Loggers;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.*;

import java.io.*;

import static io.github.elementera.config.RemoveItemConfig.pr;
import static io.github.elementera.gui.HydrogenGui.save;

public class ItemDisable extends Screen {
    private final Screen screen;
    protected ItemDisable(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    @Override
    public void render(MatrixStack matrixStack, int mouseY, int i, float f) {
        renderBackground(matrixStack, i);
        super.render(matrixStack, mouseY, i, f);
        super.init();
    }
    @Override
    protected void init() {
        /*
         left width.
         x
        */
        int ok = this.width / 2;
        int a = ok - 40;
        int b = a + 10;
        /*
         right width
         x
        */
        int c = ok + b - a;
        int d = ok + b;
        // y
        int e = 10;
        int f = this.height - 10;
        int g = f - e;
        int h = g / 8;
        int h1 = e + h;
        int h2 = h1 + h;
        int h3 = h2 + h;
        int h4 = h3 + h;
        int h5 = h4 + h;
        int h6 = h5 + h;
        int h7 = h6 + h;
        MYButton(e, e, 200, 20,"hydrogen.disable.all",(butonWidget) -> OpenGui(new HydrogenGui(this)));
        MYButton(e, h1, 200, 20, "helium.disable.all", (butonWidget) -> OpenGui(new HeliumGui(this)));
        MYButton(e, h2, 200, 20, "lithium.disable.all", (butonWidget) -> OpenGui(new LithiumGui(this)));
        MYButton(e, h3, 200, 20, "beryllium.disable.all", (butonWidget) -> OpenGui(new BerylliumGui(this)));
    }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) {
        this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress));
    }
    public static void OpenGui(Screen screens) {
        MinecraftClient.getInstance().openScreen(screens);
    }
}
class HydrogenGui extends Screen implements Loggers {
    private final Screen screen;
    public HydrogenGui(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) {
        this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress));
    }
    public static void onPress(ButtonWidget buttonWidget) {
    }
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float f) {
        renderBackground(matrixStack, mouseX);
        super.render(matrixStack, mouseX, mouseY, f);
        super.init();
    }
    @Override
    protected void init() {
        String nul = "";
        String string = nul;
        String string1 = nul;
        String string3 = nul;
        String string4 = nul;
        String string5 = nul;
        String string6 = nul;
        if (pr.getProperty("protium").equals("true")) {
            string += "true";
            string1 += "protium in enable";
        } else if (pr.getProperty("protium").equals("false")) {
            string += "false";
            string1 += "protium in disable";
        }
        if (pr.getProperty("deuterium").equals("true")) {
            string3 += "deuterium in enable";
            string4 += "true";
        } else if (pr.getProperty("deuterium").equals("false")) {
            string3 += "deuterium in disable";
            string4 += "false";
        }
        if (pr.getProperty("tritium").equals("true")) {
            string5 += "tritium in enable";
            string6 += "true";
        } else if (pr.getProperty("tritium").equals("false")) {
            string5 += "tritium in disable";
            string6 += "false";
        }
        String finalString = string;
        String finalString1 = string4;
        String finalString2 = string6;
        MYButton( 10, 10, 200, 20, string1, HydrogenGui::onPress);
        MYButton( 220, 10, 20, 20, string, (butonWidget) -> save("protium", finalString, new HydrogenGui(this)));
        MYButton(10, 40, 200, 20, string3, HydrogenGui::onPress);
        MYButton(220, 40, 20, 20, string4, (butonWidget) -> save("deuterium", finalString1, new HydrogenGui(this)));
        MYButton(10, 70, 200, 20, string5, HydrogenGui::onPress);
        MYButton(200, 70, 20, 20, string6, (butonWidget) -> save("tritium", finalString2, new HydrogenGui(this)));
    }
    public static void save(String key, String finaL, Screen screen) {
        try {
            if (finaL.equals("true")) {
                pr.setProperty(key, "false"); itemdelete.warn(key + " " + "in disable");
            }
            if (finaL.equals("false")) {
                pr.setProperty(key, "true"); itemdelete.warn(key + " " + "in enable");
            }
            FileOutputStream outputStream = new FileOutputStream("config" + File.separator + File.separator +  "elementera" + File.separator + File.separator + "remove"+ File.separator + File.separator + "removeItem.rmv");
            pr.store(outputStream, "Save Configs File.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        MinecraftClient.getInstance().openScreen(screen);
    }
}
class HeliumGui extends Screen {
    private final Screen screen;
    protected HeliumGui(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) {
        this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress));
    }
    public static void onPress(ButtonWidget buttonWidget) {
    }
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float f) {
        renderBackground(matrixStack, mouseX);
        super.render(matrixStack, mouseX, mouseY, f);
        super.init();
    }
    @Override
    protected void init() {
        /*
        helium_2 to helium_10
         */
        Screen screen1 = new HeliumGui(this);
        String nul = "";
        String MsgHelium2 = "";
        String MsgHelium3 = MsgHelium2;
        String MsgHelium4 = MsgHelium3;
        String MsgHelium5 = MsgHelium4;
        String MsgHelium6 = MsgHelium5;
        String MsgHelium7 = MsgHelium6;
        String MsgHelium8 = MsgHelium7;
        String MsgHelium9 = MsgHelium8;
        String MsgHelium10 = MsgHelium9;
        String helium2 = MsgHelium10;
        String helium3 = helium2;
        String helium4 = helium3;
        String helium5 = helium4;
        String helium6 = helium5;
        String helium7 = helium6;
        String helium8 = helium7;
        String helium9 = helium8;
        String helium10 = helium9;
        if (pr.getProperty("helium_2").equals("true")) {
            MsgHelium2 += "helium_2 in enable";
            helium2 += "true";
        } else if (pr.getProperty("helium_2").equals("false")) {
            MsgHelium2 += "helium_2 in disable";
            helium2 += "false";
        }
        if (pr.getProperty("helium_3").equals("true")) {
            MsgHelium3 += "helium_3 in enable";
            helium3 += "true";
        } else if (pr.getProperty("helium_3").equals("false")) {
            MsgHelium3 += "helium_3 in disable";
            helium3 += "false";
        }
        if (pr.getProperty("helium_4").equals("true")) {
            MsgHelium4 += "helium_4 in enable";
            helium4 += "true";
        } else if (pr.getProperty("helium_4").equals("false")) {
            MsgHelium4 += "helium_4 in disable";
            helium4 += "false";
        }
        if (pr.getProperty("helium_5").equals("true")) {
            MsgHelium5 += "helium_5 in enable";
            helium5 += "true";
        } else if (pr.getProperty("helium_5").equals("false")) {
            MsgHelium5 += "helium_5 in disable";
            helium5 += "false";
        }
        if (pr.getProperty("helium_6").equals("true")) {
            MsgHelium6 += "helium_6 in enable";
            helium6 += "true";
        } else if (pr.getProperty("helium_6").equals("false")) {
            MsgHelium6 += "helium_6 in disable";
            helium6 += "false";
        }
        if (pr.getProperty("helium_7").equals("true")) {
            MsgHelium7 += "helium_7 in enable";
            helium7 += "true";
        } else if (pr.getProperty("helium_7").equals("false")) {
            MsgHelium7 += "helium_7 in disable";
            helium7 += "false";
        }
        if (pr.getProperty("helium_8").equals("true")) {
            MsgHelium8 += "helium_8 in enable";
            helium8 += "true";
        } else if (pr.getProperty("helium_8").equals("false")) {
            MsgHelium8 += "helium_8 in disable";
            helium8 += "false";
        }
        if (pr.getProperty("helium_9").equals("true")) {
            MsgHelium9 += "helium_9 in enable";
            helium9 += "true";
        } else if (pr.getProperty("helium_9").equals("false")) {
            MsgHelium9 += "helium_9 in disable";
            helium9 += "false";
        }
        if (pr.getProperty("helium_10").equals("true")) {
            MsgHelium10 += "helium_10 in enable";
            helium10 += "true";
        } else if (pr.getProperty("helium_10").equals("false")) {
            MsgHelium10 += "helium_10 in disable";
            helium10 += "false";
        }
        String finalString = helium2;
        String finalString1 = helium3;
        String finalString2 = helium4;
        String finalString3 = helium5;
        String finalString4 = helium6;
        String finalString7 = helium7;
        String finalString8 = helium8;
        String finalString9 = helium9;
        String finalString10 = helium10;
        /*
         left width.
         x
        */
        int ok = this.width / 2;
        int a = ok - 40;
        int b = a + 10;
        /*
         right width
         x
        */
        int c = ok + b - a;
        int d = ok + b;
        // y
        int e = 10;
        int f = this.height - 10;
        int g = f - e;
        int h = g / 8;
        int h1 = e + h;
        int h2 = h1 + h;
        int h3 = h2 + h;
        int h4 = h3 + h;
        int h5 = h4 + h;
        int h6 = h5 + h;
        int h7 = h6 + h;
        MYButton(e, e, a, 20, MsgHelium2, HeliumGui::onPress);
        MYButton(b, e, 20, 20, helium2, (butonWidget) -> save("helium_2",finalString, screen1));
        MYButton(e, h1, a, 20, MsgHelium3, HeliumGui::onPress);
        MYButton(b, h1, 20, 20, helium3, (butonWidget) -> save("helium_3", finalString1, screen1));
        MYButton(e, h2, a, 20, MsgHelium4, HeliumGui::onPress);
        MYButton(b, h2, 20, 20, helium4, (butonWidget) -> save("helium_4", finalString2, screen1));
        MYButton(e, h3, a, 20, MsgHelium5, HeliumGui::onPress);
        MYButton(b, h3, 20, 20, helium5, (butonWidget) -> save("helium_5", finalString3, screen1));
        MYButton(e, h4, a, 20, MsgHelium6, HeliumGui::onPress);
        MYButton(b, h4, 20, 20, helium6, (butonWidget) -> save("helium_6", finalString4, screen1));
        MYButton(e, h5, a, 20, MsgHelium7, HeliumGui::onPress);
        MYButton(b, h5, 20, 20, helium7, (butonWidget) -> save("helium_7", finalString7, screen1));
        MYButton(e, h6, a, 20, MsgHelium8, HeliumGui::onPress);
        MYButton(b, h6, 20, 20, helium8, (butonWidget) -> save("helium_8", finalString8, screen1));
        MYButton(e, h7, a, 20, MsgHelium9, HeliumGui::onPress);
        MYButton(b, h7, 20, 20, helium9, (butonWidget) -> save("helium_9", finalString9, screen1));
        MYButton(c, e, a, 20, MsgHelium10, HeliumGui::onPress);
        MYButton(d, e, 20, 20, helium10, (butonWidget) -> save("helium_10", finalString10, screen1));
    }
}
class LithiumGui extends Screen {
    private final Screen screen;
    protected LithiumGui(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) {
        this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress));
    }
    public static void onPress(ButtonWidget buttonWidget) {}
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float f) {
        renderBackground(matrixStack, mouseX);
        super.render(matrixStack, mouseX, mouseY, f);
        super.init();
    }
    @Override
    protected void init() {
        Screen screen1 = new LithiumGui(this);
        /*
         left width.
         x
        */
        int ok = this.width / 2;
        int a = ok - 40;
        int b = a + 10;
        // y
        int e = 10;
        int f = this.height - 10;
        int g = f - e;
        int h = g / 8;
        int h1 = e + h;
        String MsgLithium6 = "";
        String MsgLithium7 = MsgLithium6;
        String lithium6 = MsgLithium7;
        String lithium7 = lithium6;
        if (pr.getProperty("lithium_6").equals("true")) {
            MsgLithium6 += "lithium_6 in enable";
            lithium6 += "true";
        } else if (pr.getProperty("lithium_6").equals("false")) {
            MsgLithium6 += "lithium_6 in disable";
            lithium6 += "false";
        }
        if (pr.getProperty("lithium_7").equals("true")) {
            MsgLithium7 += "lithium_7 in enable";
            lithium7 += "true";
        } else if (pr.getProperty("lithium_7").equals("false")) {
            MsgLithium7 += "lithium_7 in disable";
            lithium7 += "false";
        }
        String finalString = lithium6;
        String finalString1 = lithium7;
        MYButton(e, e, a, 20, MsgLithium6, LithiumGui::onPress);
        MYButton(b, e, 20, 20, lithium6, (butonWidget) -> save("lithium_6", finalString, screen1));
        MYButton(e, h1, a, 20, MsgLithium7, LithiumGui::onPress);
        MYButton(b, h1, 20, 20, lithium7, (butonWidget) -> save("lithium_7", finalString1, screen1));
    }
}
class BerylliumGui extends Screen {
    private final Screen screen;
    public BerylliumGui(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) {
        this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress));
    }
    public static void onPress(ButtonWidget buttonWidget) {}
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float f) {
        renderBackground(matrixStack, mouseX);
        super.render(matrixStack, mouseX, mouseY, f);
        super.init();
    }
    @Override
    protected void init() {
        Screen screen1 = new BerylliumGui(this);
        /*
         left width.
         x
        */
        int ok = this.width / 2;
        int a = ok - 40;
        int b = a + 10;
        // y
        int e = 10;
        int f = this.height - 10;
        int g = f - e;
        int h = g / 8;
        int h1 = e + h;
        int h2 = h1 + h;
        int h3 = h2 + h;
        String MsgBeryllium7 = "";
        String MsgBeryllium8 = MsgBeryllium7;
        String MsgBeryllium9 = MsgBeryllium8;
        String MsgBeryllium10 = MsgBeryllium9;
        String beryllium7 = MsgBeryllium10;
        String beryllium8 = beryllium7;
        String beryllium9 = beryllium8;
        String beryllium10 = beryllium9;
        if (pr.getProperty("beryllium_7").equals("true")) {
            MsgBeryllium7 += "beryllium_7 in enable";
            beryllium7 += "true";
        } else if (pr.getProperty("beryllium_7").equals("false")) {
            MsgBeryllium7 += "beryllium_7 in disable";
            beryllium7 += "false";
        }
        if (pr.getProperty("beryllium_8").equals("true")) {
            MsgBeryllium8 += "beryllium_8 in enable";
            beryllium8 += "true";
        } else if (pr.getProperty("beryllium_8").equals("false")) {
            MsgBeryllium8 += "beryllium_8 in disable";
            beryllium8 += "false";
        }
        if (pr.getProperty("beryllium_9").equals("true")) {
            MsgBeryllium9 += "beryllium_9 in enable";
            beryllium9 += "true";
        } else if (pr.getProperty("beryllium_9").equals("false")) {
            MsgBeryllium9 += "beryllium_9 in disable";
            beryllium9 += "false";
        }
        if (pr.getProperty("beryllium_10").equals("true")) {
            MsgBeryllium10 += "beryllium_10 in enable";
            beryllium10+= "true";
        } else if (pr.getProperty("beryllium_10").equals("false")) {
            MsgBeryllium10 += "beryllium_9 in disable";
            beryllium10 += "false";
        }
        String finalberyllium7 = beryllium7;
        String finalberyllium8 = beryllium8;
        String finalberyllium9 = beryllium9;
        String finalberyllium10 = beryllium10;
        MYButton(e, e, a, 20, MsgBeryllium7, BerylliumGui::onPress);
        MYButton(b, e, 20, 20, beryllium7, (butonWidget) -> save("beryllium_7", finalberyllium7, screen1));
        MYButton(e, h1, a, 20, MsgBeryllium8, BerylliumGui::onPress);
        MYButton(b, h1, 20, 20, beryllium8, (butonWidget) -> save("beryllium_8", finalberyllium8, screen1));
        MYButton(e, h2, a, 20, MsgBeryllium9, BerylliumGui::onPress);
        MYButton(b, h2, 20, 20, beryllium9, (butonWidget) -> save("beryllium_9", finalberyllium9, screen1));
        MYButton(e, h3, a, 20, MsgBeryllium10, BerylliumGui::onPress);
        MYButton(b ,h3, 20, 20, beryllium10, (butonWidget) -> save("beryllium_10", finalberyllium10, screen1));
    }
}

