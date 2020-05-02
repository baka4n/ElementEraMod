package io.github.elementera.gui;

import io.github.elementera.Loggers;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.github.elementera.config.RemoveItemConfig.pr;

public class HydrogenGui extends Screen implements Loggers {
    private final Screen screen;
    public HydrogenGui(Screen screen) {
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
        this.addButton(new ButtonWidget(10, 10, 200, 20, new TranslatableText(string1),
                HydrogenGui::onPress));
        String finalString = string;
        this.addButton(new ButtonWidget(220, 10, 20, 20, new TranslatableText(string),
                (butonWidget) -> save("protium", finalString, new HydrogenGui(this))));
        this.addButton(new ButtonWidget(10, 40, 200, 20, new TranslatableText(string3),
                HydrogenGui::onPress));
        String finalString1 = string4;
        this.addButton(new ButtonWidget(220, 40, 20, 20, new TranslatableText(string4),
                (buttonWidget) -> save("deuterium", finalString1, new HydrogenGui(this))));
        this.addButton(new ButtonWidget(10, 70, 200, 20, new TranslatableText(string5),
                HydrogenGui::onPress));
        String finalString2 = string6;
        this.addButton(new ButtonWidget(220, 70, 20, 20, new TranslatableText(string6),
                (buttonWidget) -> save("tritium", finalString2, new HydrogenGui(this))));
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
