package io.github.elementera.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.*;

import static io.github.elementera.config.RemoveItemConfig.pr;
import static io.github.elementera.gui.HydrogenGui.save;

public class HeliumGui extends Screen {
    private final Screen screen;
    protected HeliumGui(Screen screen) {
        super(new LiteralText(""));
        this.screen = screen;
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
        String MsgHelium2 = nul;
        String MsgHelium3 = nul;
        String MsgHelium4 = nul;
        String MsgHelium5 = nul;
        String MsgHelium6 = nul;
        String MsgHelium7 = nul;
        String MsgHelium8 = nul;
        String MsgHelium9 = nul;
        String MsgHelium10 = nul;
        String helium2 = nul;
        String helium3 = nul;
        String helium4 = nul;
        String helium5 = nul;
        String helium6 = nul;
        String helium7 = nul;
        String helium8 = nul;
        String helium9 = nul;
        String helium10 = nul;
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
        } else if (pr.getProperty("helium_8").equals("false")) {
            MsgHelium9 += "helium_8 in disable";
            helium9 += "false";
        }
        if (pr.getProperty("helium_10").equals("true")) {
            MsgHelium10 += "helium_10 in enable";
            helium10 += "true";
        } else if (pr.getProperty("helium_10").equals("false")) {
            MsgHelium10 += "helium_8 in disable";
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
        this.addButton(new ButtonWidget(e, e, a, 20,
                new TranslatableText(MsgHelium2),
                HeliumGui::onPress));
        this.addButton(new ButtonWidget(b, e, 20, 20, new TranslatableText(helium2),
                (butonWidget) -> save("helium_2", finalString, screen1)));
        this.addButton(new ButtonWidget(e, h1, a, 20,
                new TranslatableText(MsgHelium3),
                HeliumGui::onPress));
        this.addButton(new ButtonWidget(b, h1, 20, 20, new TranslatableText(helium3),
                (butonWidget) -> save("helium_3", finalString1, screen1)));
        this.addButton(new ButtonWidget(e, h2, a, 20,
                new TranslatableText(MsgHelium4),
                HeliumGui::onPress));
        this.addButton(new ButtonWidget(b, h2, 20, 20,
                new TranslatableText(helium4),
                (butonWidget) -> save("helium_4", finalString2, screen1)));
        this.addButton(new ButtonWidget(e, h3, a, 20,
                new TranslatableText(MsgHelium5),
                HeliumGui::onPress));
        this.addButton(new ButtonWidget(b, h3, 20, 20,
                new TranslatableText(helium5),
                (butonWidget) -> save("helium_5", finalString3, screen1)));
        this.addButton(new ButtonWidget(e, h4, a, 20,
                new TranslatableText(MsgHelium6),
                HeliumGui::onPress));
        this.addButton(new ButtonWidget( b, h4, 20, 20,
                new TranslatableText(helium6),
                (butonWidget) -> save("helium_6", finalString4, screen1)));
        this.addButton(new ButtonWidget(e, h5, a, 20,
                new TranslatableText(MsgHelium7), HeliumGui::onPress));
        this.addButton(new ButtonWidget(b, h5, 20, 20,
                new TranslatableText(helium7),
                (butonWidget) -> save("helium_7", finalString7, screen1)));
        this.addButton(new ButtonWidget(e, h6, a, 20,
                new TranslatableText(MsgHelium8),
                HeliumGui::onPress));
        this.addButton(new ButtonWidget(b, h6, 20, 20,
                new TranslatableText(helium8),
                (butonWidget) -> save("helium_8", finalString8, screen1)));

        this.addButton(new ButtonWidget(e, h7, a, 20,
                new TranslatableText(MsgHelium9),
                HeliumGui::onPress));
        this.addButton(new ButtonWidget(b, h7, 20, 20,
                new TranslatableText(helium9),
                (butonWidget) -> save("helium_9", finalString9, screen1)));
        this.addButton(new ButtonWidget(c, e, a, 20,
                new TranslatableText(MsgHelium10),
                HeliumGui::onPress));
        this.addButton(new ButtonWidget(d, e, 20, 20,
                new TranslatableText(helium10),
                (butonWidget) -> save("helium_10", finalString10, screen1)));
    }
}
