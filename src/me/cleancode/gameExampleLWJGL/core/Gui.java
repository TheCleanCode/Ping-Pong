package me.cleancode.gameExampleLWJGL.core;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Gui {

    public static void create() {
        try {
            Display.setDisplayMode(new DisplayMode(1280, 720));
            Display.sync(80);
            Display.create();
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();
            GL11.glOrtho(0,1280,0,720,1,-1);
        } catch (LWJGLException e) {
            //e.printStackTrace();
        }
    }

    public static void update() {
        Display.update();
    }
}
