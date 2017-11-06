package me.cleancode.gameExampleLWJGL.game;

import org.lwjgl.opengl.Display;

public class Pallet extends CollisionObject {

    public Pallet(float x, float y, float width, float height, int color) {
        super(x, y, width, height, color);
    }

    public void moveLeft() {
        if(this.getArea().getX() > 0) {
            this.setX(this.getX()-1.5f);
        }
    }

    public void moveRight() {
        if(this.getArea().getX2() < Display.getWidth()) {
            this.setX(this.getX()+1.5f);
        }
    }
}
