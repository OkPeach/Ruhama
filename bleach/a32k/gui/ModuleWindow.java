package bleach.a32k.gui;

import bleach.a32k.module.Module;
import net.minecraft.client.gui.FontRenderer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class ModuleWindow
{
    public FontRenderer font;
    public List<Module> modList = new ArrayList();
    public LinkedHashMap<Module, Boolean> mods = new LinkedHashMap();
    public String name;
    public int len;
    public int posX;
    public int posY;
    public int mouseX;
    public int mouseY;
    public int prevmX;
    public int prevmY;
    public int keyDown;
    public boolean lmDown;
    public boolean rmDown;
    public boolean lmHeld;
    public boolean dragging;

    public ModuleWindow(List<Module> mods, String name, int len, int posX, int posY)
    {
        this.modList = mods;
        Iterator var6 = mods.iterator();

        while (var6.hasNext())
        {
            Module m = (Module) var6.next();
            this.mods.put(m, false);
        }

        this.name = name;
        this.len = len;
        this.posX = posX;
        this.posY = posY;
    }

    public abstract void draw(int var1, int var2, int var3);

    public void setPos(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }

    public int[] getPos()
    {
        return new int[] {this.posX, this.posY};
    }

    public void onLmPressed()
    {
        this.lmDown = true;
        this.lmHeld = true;
    }

    public void onLmReleased()
    {
        this.lmHeld = false;
    }

    public void onRmPressed()
    {
        this.rmDown = true;
    }

    public void onKeyPressed(int key)
    {
        this.keyDown = key;
    }

    protected boolean mouseOver(int minX, int minY, int maxX, int maxY)
    {
        return this.mouseX > minX && this.mouseX < maxX && this.mouseY > minY && this.mouseY < maxY;
    }

    protected String cutText(String text, int leng)
    {
        String text1 = text;

        for (int i = 0; i < text.length(); ++i)
        {
            if (this.font.getStringWidth(text1) < this.len - 2)
            {
                return text1;
            }

            text1 = text1.replaceAll(".$", "");
        }

        return "";
    }
}
