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
import static io.github.elementera.gui.ItemDisable.*;

public class ItemDisable extends Screen {
    private final Screen screen;
    protected ItemDisable(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
    }
    @Override
    public void render(MatrixStack m, int X, int Y, float f) {
        renderBackground(m, Y);
        super.render(m, X, Y, f);
        super.init();
    }
    @Override
    protected void init() {
        int ok = this.width / 2, a = ok - 40, b = a + 10, c = ok + b - a;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h3 = h2 + h, h4 = h3 + h, h5 = h4 + h, h6 = h5 + h, h7 = h6 + h;
        MYButton(e, e, a, 20,"hydrogen.disable.all",(buttonWidget) -> OpenGui(new HydrogenGui(this)));
        MYButton(e, h1, a, 20, "helium.disable.all", (buttonWidget) -> OpenGui(new HeliumGui(this)));
        MYButton(e, h2, a, 20, "lithium.disable.all", (buttonWidget) -> OpenGui(new LithiumGui(this)));
        MYButton(e, h3, a, 20, "beryllium.disable.all", (buttonWidget) -> OpenGui(new BerylliumGui(this)));
        MYButton(e, h4, a, 20, "boron.disable.all", (buttonWidget) -> OpenGui(new BoronGui(this)));
        MYButton(e, h5, a, 20, "carbon.disable.all", (buttonWidget) -> OpenGui(new CarbonGui(this)));
        MYButton(e, h6, a, 20, "nitrogen.disable.all", (buttonWidget) -> OpenGui(new NitrogenGui(this)));
        MYButton(e, h7, a, 20, "oxygen.disable.all", (buttonWidget) -> OpenGui(new Oxygen(this)));
        MYButton(c, e, a, 20, "fluorine.disable.all", (buttonWidget) -> OpenGui(new FluorineGui(this)));
        MYButton(c, h7, a, 20, "authors.back", (buttonWidget) -> OpenGui(new ConfigEditGui(this)));
    }
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) { this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress)); }
    public static void OpenGui(Screen screens) { MinecraftClient.getInstance().openScreen(screens); }
    public static Boolean aBoolean(String s1, String s2) {
        boolean s3;
        if (s2.equals("1")) s3 = pr.getProperty(s1).equals("true"); else s3 = pr.getProperty(s1).equals("false");return s3;
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
        int ok = this.width / 2, a = ok - 40, b = a + 10, c = ok + b - a;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h7 = h2 + 5 * h;
        Screen screen1 = new HydrogenGui(this);
        IFs("protium", e, b, e, a, screen1);IFs("deuterium", e, b, h1, a, screen1);IFs("tritium", e, b, h2, a, screen1);
        MYButton(c, h7, a, 20, "authors.back", (buttonWidget) -> OpenGui(new ItemDisable(this)));
    }
    public void IFs(String s1, int x1, int x2, int y, int width, Screen screen) {
        String a = "", b = "";
        if (aBoolean(s1, "1")) { a += s1 + " in enable"; b += "true"; } else if (aBoolean(s1, "0")) { a += s1 + " in disable"; b += "false"; }
        String finalb = b;
        MYButton(x1, y, width, 20, a, HydrogenGui::onPress); MYButton(x2, y, 20, 20, b, (buttonWidget) -> save(s1, finalb, screen));
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
        Screen screen1 = new HeliumGui(this);
        IFs("helium_2", e, b, e, a, screen1); IFs("helium_3", e, b, h1, a, screen1); IFs("helium_4", e, b, h2, a, screen1);
        IFs("helium_5", e, b, h3, a, screen1); IFs("helium_6", e, b, h4, a, screen1); IFs("helium_7", e, b, h5, a, screen1);
        IFs("helium_8", e, b, h6, a, screen1); IFs("helium_9", e, b, h7, a, screen1); IFs("helium_10", c, d, e, a, screen1);
        MYButton(c, h7, a, 20, "authors.back", (buttonWidget) -> OpenGui(new ItemDisable(this)));
    }
    public void IFs(String s1, int x1, int x2, int y, int width, Screen screen) {
        String a = "", b = "";
        if (aBoolean(s1, "1")) { a += s1 + " in enable"; b += "true"; } else if (aBoolean(s1, "0")) { a += s1 + " in disable"; b += "false"; }
        String finalb = b;
        MYButton(x1, y, width, 20, a, HeliumGui::onPress); MYButton(x2, y, 20, 20, b, (buttonWidget) -> save(s1, finalb, screen));
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
        int ok = this.width / 2, a = ok - 40, b = a + 10, c = ok + b - a;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h7 = h1 + 6 * h;
        IFs("lithium_6", e, b, e, a, screen1); IFs("lithium_7", e, b, h1, a, screen1);MYButton(c, h7, a, 20, "authors.back", (buttonWidget) -> OpenGui(new ItemDisable(this)));
    }
    public void IFs(String s1, int x1, int x2, int y, int width, Screen screen) {
        String a = "", b = "";
        if (aBoolean(s1, "1")) { a += s1 + " in enable"; b += "true"; } else if (aBoolean(s1, "0")) { a += s1 + " in disable"; b += "false"; }
        String finalb = b;
        MYButton(x1, y, width, 20, a, LithiumGui::onPress); MYButton(x2, y, 20, 20, b, (buttonWidget) -> save(s1, finalb, screen));
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
        int ok = this.width / 2, a = ok - 40, b = a + 10, c = ok + b - a;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h3 = h2 + h, h7 = h3 + 4 * h;
        IFs("beryllium_7", e, b, e, a, screen1);IFs("beryllium_8", e, b, h1, a, screen1);
        IFs("beryllium_9", e, b, h2, a, screen1);IFs("beryllium_10", e, b, h3, a, screen1);
        MYButton(c, h7, a, 20, "authors.back", (buttonWidget) -> OpenGui(new ItemDisable(this)));
    }
    public void IFs(String s1, int x1, int x2, int y, int width, Screen screen) {
        String a = "", b = "";
        if (aBoolean(s1, "1")) { a += s1 + " in enable"; b += "true"; } else if (aBoolean(s1, "0")) { a += s1 + " in disable"; b += "false"; }
        String finalb = b;
        MYButton(x1, y, width, 20, a, BerylliumGui::onPress); MYButton(x2, y, 20, 20, b, (buttonWidget) -> save(s1, finalb, screen));
    }
}
class BoronGui extends Screen {
    private final Screen screen;
    public void MYButton(int x, int y, int widget, int height, String string, ButtonWidget.PressAction onPress) { this.addButton(new ButtonWidget(x, y, widget, height, new TranslatableText(string), onPress)); }
    protected BoronGui(Screen screen) { super(new LiteralText(""));this.screen = screen; }
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
        IFs("boron_6", e, b, e, a, screen1);IFs("boron_7", e, b, h1, a, screen1); IFs("boron_8", e, b, h2, a, screen1);
        IFs("boron_9", e, b, h3, a, screen1);IFs("boron_10", e, b, h4, a, screen1); IFs("boron_11", e, b, h5, a, screen1);
        IFs("boron_12", e, b, h6, a, screen1);IFs("boron_13", e, b, h7, a, screen1);IFs("boron_14", c, d, e, a, screen1);
        IFs("boron_15", c, d, h1, a, screen1);IFs("boron_16", c, d, h2, a, screen1);IFs("boron_17", c, d, h3, a, screen1);
        IFs("boron_18", c, d, h4, a, screen1);IFs("boron_19", c, d, h5, a, screen1);MYButton(c, h7, a, 20, "authors.back", (buttonWidget) -> OpenGui(new ItemDisable(this)));
    }
    public void IFs(String s1, int x1, int x2, int y, int width, Screen screen) {
        String a = "", b = "";
        if (aBoolean(s1, "1")) { a += s1 + " in enable"; b += "true"; } else if (aBoolean(s1, "0")) { a += s1 + " in disable"; b += "false"; }
        String finalb = b;
        MYButton(x1, y, width, 20, a, BoronGui::onPress); MYButton(x2, y, 20, 20, b, (buttonWidget) -> save(s1, finalb, screen));
    }
}
class CarbonGui extends Screen {
    private final Screen screen;
    public CarbonGui(Screen screen) {
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
        Screen screen1 = new CarbonGui(this);
        // left width for x
        int ok = this.width / 2, a = ok - 40, b = a + 10;
        // right width for x
        int c = ok + b - a, d = ok + b;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h3 = h2 + h, h4 = h3 + h, h5 = h4 + h, h6 = h5 + h, h7 = h6 + h;
        IFs("carbon_8", e, b, e, a, screen1);IFs("carbon_9", e, b, h1, a, screen1);IFs("carbon_10", e, b, h2, a, screen1);
        IFs("carbon_11", e, b, h3, a, screen1);IFs("carbon_12", e, b, h4, a, screen1);IFs("carbon_13", e, b, h5, a, screen1);
        IFs("carbon_14", e, b, h6, a, screen1);IFs("carbon_15", e, b, h7, a, screen1);IFs("carbon_16", c, d, e, a, screen1);
        IFs("carbon_17", c, d, h1, a, screen1);IFs("carbon_18", c, d, h2, a, screen1);IFs("carbon_19", c, d, h3, a, screen1);
        IFs("carbon_20", c, d, h4, a, screen1);IFs("carbon_21", c, d, h5, a, screen1);IFs("carbon_22", c, d, h6, a, screen1);
        MYButton(c, h7, a, 20, "authors.back", (buttonWidget) -> OpenGui(new ItemDisable(this)));
    }
    public void IFs(String s1, int x1, int x2, int y, int width, Screen screen) {
        String a = "", b = "";
        if (aBoolean(s1, "1")) { a += s1 + " in enable"; b += "true"; } else if (aBoolean(s1, "0")) { a += s1 + " in disable"; b += "false"; }
        String finalb = b;
        MYButton(x1, y, width, 20, a, CarbonGui::onPress); MYButton(x2, y, 20, 20, b, (buttonWidget) -> save(s1, finalb, screen));
    }
}
class NitrogenGui extends Screen {
    private final Screen screen;
    public NitrogenGui(Screen screen) {
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
        Screen screen1 = new NitrogenGui(this);
        // left width for x
        int ok = this.width / 2, a = ok - 40, b = a + 10;
        // right width for x
        int c = ok + b - a, d = ok + b;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h3 = h2 + h, h4 = h3 + h, h5 = h4 + h, h6 = h5 + h, h7 = h6 + h;
        IFs("nitrogen_10", e, b, e, a, screen1); IFs("nitrogen_11", e, b, h1, a, screen1); IFs("nitrogen_12", e, b, h2, a, screen1);
        IFs("nitrogen_13", e, b, h3, a, screen1); IFs("nitrogen_14", e, b, h4, a, screen1); IFs("nitrogen_15", e, b, h5, a, screen1);
        IFs("nitrogen_16", e, b, h6, a, screen1); IFs("nitrogen_17", e, b, h7, a, screen1); IFs("nitrogen_18", c, d, e, a, screen1);
        IFs("nitrogen_19", c, d, h1, a, screen1); IFs("nitrogen_20", c, d, h2, a, screen1); IFs("nitrogen_21", c, d, h3, a, screen1);
        IFs("nitrogen_22", c, d, h4, a, screen1); IFs("nitrogen_23", c, d, h5, a, screen1); IFs("nitrogen_24", c, d, h6, a, screen1);
        MYButton(c, h7, a, 20, "gui.next", (buttonWidget) -> OpenGui(new NitrogenGui2(this)));
    }
    public void IFs(String s1, int x1, int x2, int y, int width, Screen screen) {
        String a = "", b = "";
        if (aBoolean(s1, "1")) { a += s1 + " in enable"; b += "true"; } else if (aBoolean(s1, "0")) { a += s1 + " in disable"; b += "false"; }
        String finalb = b;
        MYButton(x1, y, width, 20, a, NitrogenGui::onPress); MYButton(x2, y, 20, 20, b, (buttonWidget) -> save(s1, finalb, screen));
    }
}
class NitrogenGui2 extends Screen {
    private final Screen screen;
    public NitrogenGui2(Screen sceen) {
        super(new LiteralText(""));
        this.screen = sceen;
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
        Screen screen1 = new NitrogenGui2(this);
        int ok = this.width / 2, a = ok - 40, b = a + 10, c = ok + b - a;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h7 = h1 + 6 * h;
        MYButton(e, e, a, 20, "gui.last", (buttonWidget) -> OpenGui(new NitrogenGui(this)));
        IFs("nitrogen_25", e, b, h1, a, screen1);
        MYButton(c, h7, a, 20, "authors.back", (buttonWidget) -> OpenGui(new ItemDisable(this)));
    }
    public void IFs(String s1, int x1, int x2, int y, int width, Screen screen) {
        String a = "", b = "";
        if (aBoolean(s1, "1")) { a += s1 + " in enable"; b += "true"; } else if (aBoolean(s1, "0")) { a += s1 + " in disable"; b += "false"; }
        String finalb = b;
        MYButton(x1, y, width, 20, a, NitrogenGui2::onPress); MYButton(x2, y, 20, 20, b, (buttonWidget) -> save(s1, finalb, screen));
    }
}
class Oxygen extends Screen {
    private final Screen screen;
    public Oxygen(Screen screen) {
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
        Screen screen1 = new NitrogenGui(this);
        // left width for x
        int ok = this.width / 2, a = ok - 40, b = a + 10;
        // right width for x
        int c = ok + b - a, d = ok + b;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h3 = h2 + h, h4 = h3 + h, h5 = h4 + h, h6 = h5 + h, h7 = h6 + h;
        IFs("oxygen_13", e, b, e, a, screen1); IFs("oxygen_14", e, b, h1, a, screen1); IFs("oxygen_15", e, b, h2, a, screen1);
        IFs("oxygen_16", e, b, h3, a, screen1); IFs("oxygen_17", e, b, h4, a, screen1); IFs("oxygen_18", e, b, h5, a, screen1);
        IFs("oxygen_19", e, b, h6, a, screen1); IFs("oxygen_20", e, b, h7, a, screen1); IFs("oxygen_21", c, d, e, a, screen1);
        IFs("oxygen_22", c, d, h1, a, screen1); IFs("oxygen_23", c, d, h2, a, screen1); IFs("oxygen_24", c, d, h3, a, screen1);
        MYButton(c, h7, a, 20, "authors.back", (buttonWidget) -> OpenGui(new ItemDisable(this)));
    }
    public void IFs(String s1, int x1, int x2, int y, int width, Screen screen) {
        String a = "", b = "";
        if (aBoolean(s1, "1")) { a += s1 + " in enable"; b += "true"; } else if (aBoolean(s1, "0")) { a += s1 + " in disable"; b += "false"; }
        String finalb = b;
        MYButton(x1, y, width, 20, a, Oxygen::onPress); MYButton(x2, y, 20, 20, b, (buttonWidget) -> save(s1, finalb, screen));
    }
}
class FluorineGui extends Screen {
    private final Screen screen;
    public FluorineGui(Screen screen) {
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
        Screen screen1 = new FluorineGui(this);
        // left width for x
        int ok = this.width / 2, a = ok - 40, b = a + 10;
        // right width for x
        int c = ok + b - a, d = ok + b;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h3 = h2 + h, h4 = h3 + h, h5 = h4 + h, h6 = h5 + h, h7 = h6 + h;
        IFs("fluorine_14", e, b, e, a, screen1); IFs("fluorine_15", e, b, h1, a, screen1); IFs("fluorine_16", e, b, h2, a, screen1);
        IFs("fluorine_17", e, b, h3, a, screen1); IFs("fluorine_18", e, b, h4, a, screen1); IFs("fluorine_19", e, b, h5, a, screen1);
        IFs("fluorine_20", e, b, h6, a, screen1); IFs("fluorine_21", e, b, h7, a, screen1); IFs("fluorine_22", c, d, e, a, screen1);
        IFs("fluorine_23", c, d, h1, a, screen1); IFs("fluorine_24", c, d, h2, a, screen1); IFs("fluorine_25", c, d, h3, a, screen1);
        IFs("fluorine_26", c, d, h4, a, screen1); IFs("fluorine_27", c, d, h5, a, screen1); IFs("fluorine_28", c, d, h6, a, screen1);
        MYButton(c, h7, a, 20, "gui.next", (buttonWidget) -> OpenGui(new FluorineGui2(this)));
    }
    public void IFs(String s1, int x1, int x2, int y, int width, Screen screen) {
        String a = "", b = "";
        if (aBoolean(s1, "1")) { a += s1 + " in enable"; b += "true"; } else if (aBoolean(s1, "0")) { a += s1 + " in disable"; b += "false"; }
        String finalb = b;
        MYButton(x1, y, width, 20, a, FluorineGui::onPress); MYButton(x2, y, 20, 20, b, (buttonWidget) -> save(s1, finalb, screen));
    }
}
class FluorineGui2 extends Screen {
    private final Screen screen;
    public FluorineGui2(Screen screen) {
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
        Screen screen1 = new FluorineGui(this);
        int ok = this.width / 2, a = ok - 40, b = a + 10, c = ok + b - a;
        // y
        int e = 10, f = this.height - 10, g = f - e, h = g / 8, h1 = e + h, h2 = h1 + h, h3 = h2 + h, h4 = h3 + h, h5 = h4 + h, h6 = h5 + h, h7 = h6 + h;
        MYButton(e, e, a, 20, "gui.last", (buttonWidget) -> OpenGui(new FluorineGui(this)));
        IFs("fluorine_29",e, b, h1, a, screen1); IFs("fluorine_30", e, b, h2, a, screen1); IFs("fluorine_31", e, b, h3, a, screen1);
        MYButton(c, h7, a, 20, "authors.back", (buttonWidget) -> OpenGui(new ItemDisable(this)));
    }
    public void IFs(String s1, int x1, int x2, int y, int width, Screen screen) {
        String a = "", b = "";
        if (aBoolean(s1, "1")) { a += s1 + " in enable"; b += "true"; } else if (aBoolean(s1, "0")) { a += s1 + " in disable"; b += "false"; }
        String finalb = b;
        MYButton(x1, y, width, 20, a, FluorineGui2::onPress); MYButton(x2, y, 20, 20, b, (buttonWidget) -> save(s1, finalb, screen));
    }
}