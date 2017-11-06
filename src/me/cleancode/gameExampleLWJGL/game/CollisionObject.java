package me.cleancode.gameExampleLWJGL.game;

public class CollisionObject extends GameObject {

    private boolean colliding;

    private long lastCollision;

    public CollisionObject(float x, float y, float width, float height, int color) {
        super(x, y, width, height, color);
        this.colliding = false;
    }

    public boolean isColliding() {
        return colliding;
    }

    public void setColliding(boolean colliding) {
        this.colliding = colliding;
    }

    public long getLastCollision() {
        return lastCollision;
    }

    public void setLastCollision(long lastCollision) {
        this.lastCollision = lastCollision;
    }
}
