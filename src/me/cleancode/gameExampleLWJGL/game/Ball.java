package me.cleancode.gameExampleLWJGL.game;

public class Ball extends RigidBody {

    public Ball(float x, float y, float size, int color) {
        super(x, y, size, size, color);
    }

    @Override
    public void update() {
      //  System.out.println(this.getX() +" : "+this.getY());
        System.out.println(this.getAngle());
        //if(this.isColliding()) System.out.println(this.isColliding());
        super.update();
    }

    @Override
    public void render() {
        super.render();
    }
}
