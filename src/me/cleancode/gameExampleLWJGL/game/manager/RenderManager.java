package me.cleancode.gameExampleLWJGL.game.manager;


import me.cleancode.gameExampleLWJGL.game.GameObject;

import java.util.ArrayList;
import java.util.List;

public class RenderManager {
    private List<GameObject> gameObjects;

    public RenderManager() {
        gameObjects = new ArrayList<>();
    }

    public void update() {
        int size = gameObjects.size();
        for(int i = 0; i < size; i++) {
            GameObject gameObject = null;
            try {
                gameObject = gameObjects.get(i);
            }catch (Exception ignored) { }
            if(gameObject != null) {
                gameObject.render();
            }
        }
    }

    public void register(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void destroy(GameObject gameObject) {
        this.gameObjects.remove(gameObject);
    }
}
