package io.github.elementera.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.*;
import java.io.*;
import static io.github.elementera.Elementera.log;
import static io.github.elementera.config.Config.s;
import static io.github.elementera.config.RemoveItemConfig.pr;
import static io.github.elementera.gui.HydrogenGui.save;
import static io.github.elementera.gui.ItemDisable.aBoolean;

public class ItemDisable extends Screen {
    private final Screen screen;
    protected ItemDisable(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    @Override
    public void render(MatrixStack matrixStack, int X, int Y, float f) {
        renderBackground(matrixStack, Y);
        super.render(matrixStack, X, Y, f);
        super.init();
    }
    @Override
    protected void init() {
        // left width for x
        int ok = this.width / 2, a = ok - 40, b = a + 10;
        // right width for x
        int c = ok + b - a, d = ok + b;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h3 = h2 + h, h4 = h3 + h, h5 = h4 + h, h6 = h5 + h, h7 = h6 + h;
        MYButton(e, e, 200, 20,"hydrogen.disable.all",(buttonWidget) -> OpenGui(new HydrogenGui(this)));
        MYButton(e, h1, 200, 20, "helium.disable.all", (buttonWidget) -> OpenGui(new HeliumGui(this)));
        MYButton(e, h2, 200, 20, "lithium.disable.all", (buttonWidget) -> OpenGui(new LithiumGui(this)));
        MYButton(e, h3, 200, 20, "beryllium.disable.all", (buttonWidget) -> OpenGui(new BerylliumGui(this)));
        MYButton(e, h4, 200, 20, "boron.disable.all", (buttonWidget) -> OpenGui(new BoronGui(this)));
    }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) { this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress)); }
    public static void OpenGui(Screen screens) { MinecraftClient.getInstance().openScreen(screens); }
    public static Boolean aBoolean(String s1, String s2) {
        boolean s3;
        if (s2.equals("1")) {
            s3 = pr.getProperty(s1).equals("true");
        } else {
            s3 = pr.getProperty(s1).equals("false");
        }
        return s3;
    }
}
class HydrogenGui extends Screen {
    private final Screen screen;
    public HydrogenGui(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) { this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress)); }
    public static void onPress(ButtonWidget buttonWidget) { }
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float f) {
        renderBackground(matrixStack, mouseX);
        super.render(matrixStack, mouseX, mouseY, f);
        super.init();
    }
    @Override
    protected void init() {
        Screen screen1 = new HydrogenGui(this);
        String string = "", string1 = "", string3 = "", string4 = "", string5 = "", string6 = "";
        if (aBoolean("protium", "1")) { string += "true";string1 += "protium in enable"; } else if (aBoolean("protium", "0")) { string += "false";string1 += "protium in disable"; }
        if (aBoolean("deuterium", "1")) { string3 += "deuterium in enable";string4 += "true"; } else if (aBoolean("deuterium", "0")) { string3 += "deuterium in disable";string4 += "false"; }
        if (aBoolean("tritium", "1")) { string5 += "tritium in enable";string6 += "true"; } else if (aBoolean("tritium", "0")) { string5 += "tritium in disable";string6 += "false"; }
        String finalString = string, finalString1 = string4, finalString2 = string6;
        MYButton( 10, 10, 200, 20, string1, HydrogenGui::onPress);
        MYButton( 220, 10, 20, 20, string, (butonWidget) -> save("protium", finalString, screen1));
        MYButton(10, 40, 200, 20, string3, HydrogenGui::onPress);
        MYButton(220, 40, 20, 20, string4, (butonWidget) -> save("deuterium", finalString1, screen1));
        MYButton(10, 70, 200, 20, string5, HydrogenGui::onPress);
        MYButton(220, 70, 20, 20, string6, (butonWidget) -> save("tritium", finalString2, screen1));
    }
    public static void save(String key, String finaL, Screen screen) {
        try {
            if (finaL.equals("true")) {
                pr.setProperty(key, "false"); log("item delete", key + " " + "in disable");
            }
            if (finaL.equals("false")) {
                pr.setProperty(key, "true"); log("item delete", key + " " + "in enable");
            }
            FileOutputStream outputStream = new FileOutputStream("config" + s + s +"elementera" + s + s + "remove" + s + s + "removeItem.rmv");
            pr.store(outputStream, "Save Configs File.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        MinecraftClient.getInstance().openScreen(screen);
    }
}
class HeliumGui extends Screen {
    private final Screen screen;
    protected HeliumGui(Screen screen) { super(new LiteralText(""));this.screen = screen; }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) { this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress)); }
    public static void onPress(ButtonWidget buttonWidget) { }
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float f) {
        renderBackground(matrixStack, mouseX);
        super.render(matrixStack, mouseX, mouseY, f);
        super.init();
    }
    @Override
    protected void init() {
        /*
         left width.
         x
        */
        int ok = this.width / 2, a = ok - 40, b = a + 10;
        // right width for x
        int c = ok + b - a, d = ok + b;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h3 = h2 + h, h4 = h3 + h, h5 = h4 + h, h6 = h5 + h, h7 = h6 + h;
        /*
        helium_2 to helium_10
         */
        Screen screen1 = new HeliumGui(this);
        String MsgHelium2 = "", MsgHelium3 = "", MsgHelium4 = "", MsgHelium5 = "", MsgHelium6 = "", MsgHelium7 = "", MsgHelium8 = "", MsgHelium9 = "", MsgHelium10 = "", helium2 = "", helium3 = "", helium4 = "", helium5 = "", helium6 = "", helium7 = "", helium8 = "", helium9 = "", helium10 = "";
        if (aBoolean("helium_2", "1")) { MsgHelium2 += "helium_2 in enable";helium2 += "true"; } else if (aBoolean("helium_2", "0")) { MsgHelium2 += "helium_2 in disable";helium2 += "false"; }
        if (aBoolean("helium_3", "1")) { MsgHelium3 += "helium_3 in enable";helium3 += "true"; } else if (aBoolean("helium_3", "0")) { MsgHelium3 += "helium_3 in disable";helium3 += "false"; }
        if (aBoolean("helium_4", "1")) { MsgHelium4 += "helium_4 in enable";helium4 += "true"; } else if (aBoolean("helium_4", "0")) { MsgHelium4 += "helium_4 in disable";helium4 += "false"; }
        if (aBoolean("helium_5", "1")) { MsgHelium5 += "helium_5 in enable";helium5 += "true"; } else if (aBoolean("helium_5", "0")) { MsgHelium5 += "helium_5 in disable";helium5 += "false"; }
        if (aBoolean("helium_6", "1")) { MsgHelium6 += "helium_6 in enable";helium6 += "true"; } else if (aBoolean("helium_6", "0")) { MsgHelium6 += "helium_6 in disable";helium6 += "false"; }
        if (aBoolean("helium_7", "1")) { MsgHelium7 += "helium_7 in enable";helium7 += "true"; } else if (aBoolean("helium_7", "0")) { MsgHelium7 += "helium_7 in disable";helium7 += "false"; }
        if (aBoolean("helium_8", "1")) { MsgHelium8 += "helium_8 in enable";helium8 += "true"; } else if (aBoolean("helium_8", "0")) { MsgHelium8 += "helium_8 in disable";helium8 += "false"; }
        if (aBoolean("helium_9", "1")) { MsgHelium9 += "helium_9 in enable";helium9 += "true"; } else if (aBoolean("helium_9", "0")) { MsgHelium9 += "helium_9 in disable";helium9 += "false"; }
        if (aBoolean("helium_10", "1")) { MsgHelium10 += "helium_10 in enable";helium10 += "true"; } else if (aBoolean("helium_10", "0")) { MsgHelium10 += "helium_10 in disable";helium10 += "false"; }
        String finalString = helium2, finalString1 = helium3, finalString2 = helium4, finalString3 = helium5, finalString4 = helium6, finalString7 = helium7, finalString8 = helium8, finalString9 = helium9, finalString10 = helium10;
        MYButton(e, e, a, 20, MsgHelium2, HeliumGui::onPress);
        MYButton(b, e, 20, 20, helium2, (buttonWidget) -> save("helium_2",finalString, screen1));
        MYButton(e, h1, a, 20, MsgHelium3, HeliumGui::onPress);
        MYButton(b, h1, 20, 20, helium3, (buttonWidget) -> save("helium_3", finalString1, screen1));
        MYButton(e, h2, a, 20, MsgHelium4, HeliumGui::onPress);
        MYButton(b, h2, 20, 20, helium4, (buttonWidget) -> save("helium_4", finalString2, screen1));
        MYButton(e, h3, a, 20, MsgHelium5, HeliumGui::onPress);
        MYButton(b, h3, 20, 20, helium5, (buttonWidget) -> save("helium_5", finalString3, screen1));
        MYButton(e, h4, a, 20, MsgHelium6, HeliumGui::onPress);
        MYButton(b, h4, 20, 20, helium6, (buttonWidget) -> save("helium_6", finalString4, screen1));
        MYButton(e, h5, a, 20, MsgHelium7, HeliumGui::onPress);
        MYButton(b, h5, 20, 20, helium7, (buttonWidget) -> save("helium_7", finalString7, screen1));
        MYButton(e, h6, a, 20, MsgHelium8, HeliumGui::onPress);
        MYButton(b, h6, 20, 20, helium8, (buttonWidget) -> save("helium_8", finalString8, screen1));
        MYButton(e, h7, a, 20, MsgHelium9, HeliumGui::onPress);
        MYButton(b, h7, 20, 20, helium9, (buttonWidget) -> save("helium_9", finalString9, screen1));
        MYButton(c, e, a, 20, MsgHelium10, HeliumGui::onPress);
        MYButton(d, e, 20, 20, helium10, (buttonWidget) -> save("helium_10", finalString10, screen1));
    }
}
class LithiumGui extends Screen {
    private final Screen screen;
    protected LithiumGui(Screen screen) { super(new LiteralText(""));this.screen = screen; }
    public void MYButton(int x, int y, int widget, int height, String s, ButtonWidget.PressAction onPress) { this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(s), onPress)); }
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
        // left width for x
        int ok = this.width / 2, a = ok - 40, b = a + 10;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h;
        String MsgLithium6 = "", MsgLithium7 = "", lithium6 = "", lithium7 = "";
        if (aBoolean("lithium_6", "1")) { MsgLithium6 += "lithium_6 in enable";lithium6 += "true"; } else if (aBoolean("lithium_6", "0")) { MsgLithium6 += "lithium_6 in disable";lithium6 += "false"; }
        if (aBoolean("lithium_7", "1")) { MsgLithium7 += "lithium_7 in enable";lithium7 += "true"; } else if (aBoolean("lithium_7", "0")) { MsgLithium7 += "lithium_7 in disable";lithium7 += "false"; }
        String finalString = lithium6, finalString1 = lithium7;
        MYButton(e, e, a, 20, MsgLithium6, LithiumGui::onPress);
        MYButton(b, e, 20, 20, lithium6, (buttonWidget) -> save("lithium_6", finalString, screen1));
        MYButton(e, h1, a, 20, MsgLithium7, LithiumGui::onPress);
        MYButton(b, h1, 20, 20, lithium7, (buttonWidget) -> save("lithium_7", finalString1, screen1));
    }
}
class BerylliumGui extends Screen {
    private final Screen screen;
    public BerylliumGui(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) { this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress)); }
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
        // left width for x
        int ok = this.width / 2, a = ok - 40, b = a + 10;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h3 = h2 + h;
        String MsgBeryllium7 = "", MsgBeryllium8 = "", MsgBeryllium9 = "", MsgBeryllium10 = "", beryllium7 = "", beryllium8 = "", beryllium9 = "", beryllium10 = "";
        if (aBoolean("beryllium_7", "1")) { MsgBeryllium7 += "beryllium_7 in enable";beryllium7 += "true"; } else if (aBoolean("beryllium_7", "0")) { MsgBeryllium7 += "beryllium_7 in disable";beryllium7 += "false"; }
        if (aBoolean("beryllium_8", "1")) { MsgBeryllium8 += "beryllium_8 in enable";beryllium8 += "true"; } else if (aBoolean("beryllium_8", "0")) { MsgBeryllium8 += "beryllium_8 in disable";beryllium8 += "false"; }
        if (aBoolean("beryllium_9", "1")) { MsgBeryllium9 += "beryllium_9 in enable";beryllium9 += "true"; } else if (aBoolean("beryllium_9", "0")) { MsgBeryllium9 += "beryllium_9 in disable";beryllium9 += "false"; }
        if (aBoolean("beryllium_10", "1")) { MsgBeryllium10 += "beryllium_10 in enable";beryllium10+= "true"; } else if (aBoolean("beryllium_10", "0")) { MsgBeryllium10 += "beryllium_9 in disable";beryllium10 += "false"; }
        String finalberyllium7 = beryllium7, finalberyllium8 = beryllium8, finalberyllium9 = beryllium9, finalberyllium10 = beryllium10;
        MYButton(e, e, a, 20, MsgBeryllium7, BerylliumGui::onPress);
        MYButton(b, e, 20, 20, beryllium7, (buttonWidget) -> save("beryllium_7", finalberyllium7, screen1));
        MYButton(e, h1, a, 20, MsgBeryllium8, BerylliumGui::onPress);
        MYButton(b, h1, 20, 20, beryllium8, (buttonWidget) -> save("beryllium_8", finalberyllium8, screen1));
        MYButton(e, h2, a, 20, MsgBeryllium9, BerylliumGui::onPress);
        MYButton(b, h2, 20, 20, beryllium9, (buttonWidget) -> save("beryllium_9", finalberyllium9, screen1));
        MYButton(e, h3, a, 20, MsgBeryllium10, BerylliumGui::onPress);
        MYButton(b ,h3, 20, 20, beryllium10, (buttonWidget) -> save("beryllium_10", finalberyllium10, screen1));
    }
}
class BoronGui extends Screen {
    private final Screen screen;
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) { this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress)); }
    protected BoronGui(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
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
        Screen screen1 = new BoronGui(this);
        // left width for x
        int ok = this.width / 2, a = ok - 40, b = a + 10;
        // right width for x
        int c = ok + b - a, d = ok + b;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h3 = h2 + h, h4 = h3 + h, h5 = h4 + h, h6 = h5 + h, h7 = h6 + h;
        String MsgBoron6 = "", MsgBoron7 = "", MsgBoron8 = "", MsgBoron9 = "", MsgBoron10 = "", MsgBoron11 = "", MsgBoron12 = "", MsgBoron13 = "", MsgBoron14 = "", MsgBoron15 = "", MsgBoron16 = "", MsgBoron17 = "", MsgBoron18 = "", MsgBoron19 = "", boron6 = "", boron7 = "", boron8 = "", boron9 = "", boron10 = "", boron11 = "", boron12 = "", boron13 = "", boron14 = "", boron15 = "", boron16 = "", boron17 = "", boron18 = "", boron19 = "";
        if (aBoolean("boron_6", "1")) { MsgBoron6 += "boron_6 in enable";boron6 += "true"; } else if (aBoolean("boron_6", "0")) { MsgBoron6 += "boron_6 in disable";boron6 += "false"; }
        if (aBoolean("boron_7", "1")) { MsgBoron7 += "boron_7 in enable";boron7 += "true"; } else if (aBoolean("boron_7", "0")) { MsgBoron7 += "boron_7 in disable";boron7 += "false"; }
        if (aBoolean("boron_8", "1")) { MsgBoron8 += "boron_8 in enable";boron8 += "true"; } else if (aBoolean("boron_8", "0")) { MsgBoron8 += "boron_8 in disable";boron8 += "false"; }
        if (aBoolean("boron_9", "1")) { MsgBoron9 += "boron_9 in enable";boron9 += "true"; } else if (aBoolean("boron_9", "0")) { MsgBoron9 += "boron_9 in disable";boron9 += "false"; }
        if (aBoolean("boron_10", "1")) { MsgBoron10 += "boron_10 in enable"; boron10 += "true"; } else if (aBoolean("boron_10", "0")) { MsgBoron10 += "boron_10 in disable"; boron10 += "false"; }
        if (aBoolean("boron_11", "1")) { MsgBoron11 += "boron_11 in enable"; boron11 += "true"; } else if (aBoolean("boron_11", "0")) { MsgBoron11 += "boron_11 in disable"; boron11 += "false"; }
        if (aBoolean("boron_12", "1")) { MsgBoron12 += "boron_12 in enable"; boron12 += "true"; } else if (aBoolean("boron_12", "0")) { MsgBoron12 += "boron_12 in disable"; boron12 += "false"; }
        if (aBoolean("boron_13", "1")) { MsgBoron13 += "boron_13 in enable"; boron13 += "true"; } else if (aBoolean("boron_13", "0")) { MsgBoron13 += "boron_13 in disable"; boron13 += "false"; }
        if (aBoolean("boron_14", "1")) { MsgBoron14 += "boron_14 in enable"; boron14 += "true"; } else if (aBoolean("boron_14", "0")) { MsgBoron14 += "boron_14 in disable"; boron14 += "false"; }
        if (aBoolean("boron_15", "1")) { MsgBoron15 += "boron_15 in enable"; boron15 += "true"; } else if (aBoolean("boron_15", "0")) { MsgBoron15 += "boron_15 in disable"; boron15 += "false"; }
        if (aBoolean("boron_16", "1")) { MsgBoron16 += "boron_16 in enable"; boron16 += "true"; } else if (aBoolean("boron_16", "0")) { MsgBoron16 += "boron_16 in disable"; boron16 += "false"; }
        if (aBoolean("boron_17", "1")) { MsgBoron17 += "boron_17 in enable"; boron17 += "true"; } else if (aBoolean("boron_17", "0")) { MsgBoron17 += "boron_17 in disable"; boron17 += "false"; }
        if (aBoolean("boron_18", "1")) { MsgBoron18 += "boron_18 in enable"; boron18 += "true"; } else if (aBoolean("boron_18", "0")) { MsgBoron18 += "boron_18 in disable"; boron18 += "false"; }
        if (aBoolean("boron_19", "1")) { MsgBoron19 += "boron_19 in enable"; boron19 += "true"; } else if (aBoolean("boron_19", "0")) { MsgBoron19 += "boron_19 in disable"; boron19 += "false"; }
        String finalboron6 = MsgBoron6, finalboron7 = boron7, finalboron8 = boron8, finalboron9 = boron9, finalboron10 = boron10, finalboron11 = boron11, finalboron12 = boron12, finalboron13 = boron13, finalboron14 = boron14, finalboron15 = boron15, finalboron16 = boron16, finalboron17 = boron17, finalboron18 = boron18, finalboron19 = boron19;
        MYButton(e, e, a, 20, MsgBoron6, BoronGui::onPress);
        MYButton(b, e, 20, 20, boron6, (buttonWidget) -> save("boron_6", finalboron6, screen1));
        MYButton(e, h1, a, 20, MsgBoron7, BoronGui::onPress);
        MYButton(b, h1, 20, 20, boron7, (buttonWidget) -> save("boron_7", finalboron7, screen1));
        MYButton(e, h2, a, 20, MsgBoron8, BoronGui::onPress);
        MYButton(b, h2, 20, 20, boron8, (buttonWidget) -> save("boron_8", finalboron8, screen1));
        MYButton(e, h3, a, 20, MsgBoron9, BoronGui::onPress);
        MYButton(b ,h3, 20, 20, boron9, (buttonWidget) -> save("boron_9", finalboron9, screen1));
        MYButton(e, h4, a, 20, MsgBoron10, BoronGui::onPress);
        MYButton(b, h4, 20, 20, boron10, (buttonWidget) -> save("boron_10", finalboron10, screen1));
        MYButton(e, h5, a, 20, MsgBoron11, BoronGui::onPress);
        MYButton(b, h5, 20, 20, boron11, (buttonWidget) -> save("boron_11", finalboron11, screen1));
        MYButton(e, h6, a, 20, MsgBoron12, BoronGui::onPress);
        MYButton(b, h6, 20, 20, boron12, (buttonWidget) -> save("boron_12", finalboron12, screen1));
        MYButton(e, h7, a, 20, MsgBoron13, BoronGui::onPress);
        MYButton(b, h7, 20, 20, boron13, (buttonWidget) -> save("boron_13", finalboron13, screen1));
        MYButton(c, e, a, 20 , MsgBoron14, BoronGui::onPress);
        MYButton(d, e, 20, 20, boron14, (buttonWidget) -> save("boron_14", finalboron14, screen1));
        MYButton(c, h1, a, 20, MsgBoron15, BoronGui::onPress);
        MYButton(d, h1, 20, 20, boron15, (buttonWidget) -> save("boron_15", finalboron15, screen1));
        MYButton(c, h2, a, 20, MsgBoron16, BoronGui::onPress);
        MYButton(d, h2, 20, 20, boron16, (buttonWidget) -> save("boron_16", finalboron16, screen1));
        MYButton(c, h3, a, 20, MsgBoron17, BoronGui::onPress);
        MYButton(d, h3, 20, 20, boron17, (buttonWidget) -> save("boron_17", finalboron17, screen1));
        MYButton(c, h4, a, 20, MsgBoron18, BoronGui::onPress);
        MYButton(d, h4, 20, 20, boron18, (buttonWidget) -> save("boron_18", finalboron18, screen1));
        MYButton(c, h5, a, 20, MsgBoron19, BoronGui::onPress);
        MYButton(d, h5, 20, 20, boron19, (buttonWidget) -> save("boron_19", finalboron19, screen1));
    }
}