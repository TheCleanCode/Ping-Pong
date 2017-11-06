package me.cleancode.gameExampleLWJGL.game;

public class Area {
    private float x;
    private float y;
    private float x2;
    private float y2;

    public Area(float x, float y, float x2, float y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean isColliding(Area area) {
        if(this.x < area.x2 && this.x2 > area.x) {
            if(this.y < area.y2 && this.y2 > area.y) {
                return true;
            }
        }
        return false;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getX2() {
        return x2;
    }

    public float getY2() {
        return y2;
    }
}
