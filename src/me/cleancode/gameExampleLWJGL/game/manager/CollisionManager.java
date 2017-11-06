package me.cleancode.gameExampleLWJGL.game.manager;

import me.cleancode.gameExampleLWJGL.game.CollisionObject;
import me.cleancode.gameExampleLWJGL.game.GameObject;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager {
    private List<CollisionObject> collisionObjects;

    public CollisionManager() {
        collisionObjects = new ArrayList<>();
    }

    public void update() {
        int size = collisionObjects.size();
        List<CollisionObject> tmp = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            CollisionObject collisionObject = null;
            try {
                collisionObject = collisionObjects.get(i);
            }catch (Exception ignored) { }
            if(collisionObject != null) {
                tmp.add(collisionObject);
            }
        }
        for(CollisionObject collisionObject : tmp) {
            boolean col = false;
            for (CollisionObject collisionObject1 : tmp) {
                if(collisionObject == collisionObject1) continue;
                if(collisionObject.getArea().isColliding(collisionObject1.getArea())) {
                    if(System.currentTimeMillis()-collisionObject.getLastCollision() < 600) continue;
                    collisionObject.setLastCollision(System.currentTimeMillis());
                    collisionObject.setColliding(true);
                    collisionObject1.setColliding(true);
                    col = true;
                }
            }
            if(!col) collisionObject.setColliding(false);
        }
    }

    public void register(CollisionObject collisionObject) {
        collisionObjects.add(collisionObject);
    }

    public void destroy(CollisionObject collisionObject) {
        this.collisionObjects.remove(collisionObject);
    }
}
