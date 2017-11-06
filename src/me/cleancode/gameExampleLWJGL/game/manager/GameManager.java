package me.cleancode.gameExampleLWJGL.game.manager;


import me.cleancode.gameExampleLWJGL.game.MainGameLoop;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private static GameManager gameManager;

    private MainGameLoop loop;

    private List<Class> toLoad;
    private List<Object> loaded;

    public GameManager(MainGameLoop loop) {
        this.loop = loop;
        gameManager = this;
        this.toLoad = new ArrayList<>();
        this.loaded = new ArrayList<>();
        this.register();
        this.load();
    }

    private void register() {
        this.toLoad.add(CollisionManager.class);
        this.toLoad.add(MotionManager.class);
        this.toLoad.add(RenderManager.class);
    }

    private void load() {
        for(Class c : toLoad) {
            loaded.add(load(c));
        }
    }

    private Object load(Class c) {
        try {
            return c.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static GameManager getGameManager() {
        return gameManager;
    }

    public Object get(Class c) {
        for(Object o : loaded) {
            if(o.getClass() == c) {
                return o;
            }
        }
        return null;
    }

    public CollisionManager getCollisionManager() {
        return (CollisionManager) get(CollisionManager.class);
    }

    public MotionManager getMotionManager() {
        return (MotionManager) get(MotionManager.class);
    }

    public RenderManager getRenderManager() {
        return (RenderManager) get(RenderManager.class);
    }
}
