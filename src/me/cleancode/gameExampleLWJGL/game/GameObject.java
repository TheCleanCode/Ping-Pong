package me.cleancode.gameExampleLWJGL.game;

import org.lwjgl.opengl.GL11;

import java.awt.*;

public class GameObject {

    public GameObject(float x, float y, float width, float height, int color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    private float x;
    private float y;

    private float width;
    private float height;

    private int color;

    public Area getArea() {
        return new Area(x-width,y-height,x+width,y+height);
    }

    public void render() {
        Color color_ = new Color(color);
        GL11.glColor4f(color_.getRed() / 255.0F, color_.getGreen() / 255.0F, color_.getBlue() / 255.0F, color_.getAlpha() / 255.0F);

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(getArea().getX(),getArea().getY());
        GL11.glVertex2f(getArea().getX2(),getArea().getY());
        GL11.glVertex2f(getArea().getX2(),getArea().getY2());
        GL11.glVertex2f(getArea().getX(),getArea().getY2());
        GL11.glEnd();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
