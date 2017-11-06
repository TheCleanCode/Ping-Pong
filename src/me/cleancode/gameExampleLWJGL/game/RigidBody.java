package me.cleancode.gameExampleLWJGL.game;


import org.lwjgl.opengl.Display;

public class RigidBody extends CollisionObject {

    private float velocity;
    private float angle;

    public RigidBody(float x, float y, float width, float height, int color) {
        super(x, y, width, height, color);
        velocity = 1.4f;
        angle = 90;
    }

    public void update() {
        moveForward();
    }

    private void moveForward() {
      //  this.angle+=0.1;
        float x = this.getX();
        float y = this.getY();

        x += velocity * Math.sin(angle);
        y += velocity * Math.cos(angle);

        if(this.getX() < 0) {
            if(x < this.getX()) {
                this.angle = -this.angle;
            }
        }

        if(this.getX() > Display.getWidth()) {
            if(x > this.getX()) {
                this.angle = -this.angle;
            }
        }

        if(y < 0 || y > 720.0f) {
            y = Display.getHeight() /2;
            this.angle = -this.angle;
        }

        if(this.isColliding()) {
            if(this.angle == 45) {
                this.angle = 90;
            }else if(this.angle == -45) {
                this.angle = -90;
            }else if(this.angle == -90) {
                this.angle = -45;
            }else if(this.angle == 90) {
                this.angle = 45;
            }
        }

        this.setColliding(false);

        this.setX(x);
        this.setY(y);
    }

    private float wrapAngle(float angle) {
        if(angle < 0) {
            angle = 45.0f;
        }else if(angle > 360 || angle+45.0f > 360) {
            angle = (360-angle)+45;
        }
        return angle;
    }

    public float getAngle() {
        return angle;
    }
}
