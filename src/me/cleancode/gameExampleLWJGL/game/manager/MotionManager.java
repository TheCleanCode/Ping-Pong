package me.cleancode.gameExampleLWJGL.game.manager;

import me.cleancode.gameExampleLWJGL.game.RigidBody;

import java.util.ArrayList;
import java.util.List;

public class MotionManager {

    private List<RigidBody> rigidBodies;

    public MotionManager() {
        rigidBodies = new ArrayList<>();
    }

    public void update() {
        int size = rigidBodies.size();
     //   System.out.println(size);
        for(int i = 0; i < size; i++) {
            RigidBody rigidBody = null;
            try {
                rigidBody = rigidBodies.get(i);
            }catch (Exception ignored) { }
            if(rigidBody != null) {
                rigidBody.update();
            }
        }
    }

    public void register(RigidBody rigidBody) {
        rigidBodies.add(rigidBody);
    }

    public void destroy(RigidBody rigidBody) {
        this.rigidBodies.remove(rigidBody);
    }
}
