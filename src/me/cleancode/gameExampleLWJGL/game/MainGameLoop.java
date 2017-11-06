package me.cleancode.gameExampleLWJGL.game;

import me.cleancode.gameExampleLWJGL.GameMain;
import me.cleancode.gameExampleLWJGL.core.Gui;
import me.cleancode.gameExampleLWJGL.game.manager.GameManager;
import me.cleancode.gameExampleLWJGL.utils.Timer;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class MainGameLoop {

    private boolean loaded = false;
    private boolean running = false;

    private Pallet pallet1;
    private Pallet pallet2;



    private Timer tickTimer;

    public void startLoop() {
        if(!loaded) {
            load();
        }else {
            tickTimer = new Timer();
            while (running) {
                if(tickTimer.hasMSPassed(1000/250)) {
                    tickTimer.subtract(1000/250);
                    loop();
                }
            }
        }
    }

    private void loop() {

        if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            this.pallet1.moveLeft();
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            this.pallet1.moveRight();
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
            this.pallet2.moveLeft();
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
            this.pallet2.moveRight();
        }

        if(Display.isCloseRequested()) {
            GameMain.getInstance().stop();
        }

        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GameManager.getGameManager().getMotionManager().update();
        GameManager.getGameManager().getRenderManager().update();
        GameManager.getGameManager().getCollisionManager().update();
        Gui.update();
    }

    private void load() {
        new GameManager(this);
        running = true;
        loaded = true;
        Ball ball = new Ball(Display.getWidth() / 2, Display.getHeight() / 2, 15, new Color(1, 198, 255).getRGB());
        GameManager.getGameManager().getMotionManager().register(ball);
        GameManager.getGameManager().getRenderManager().register(ball);
        GameManager.getGameManager().getCollisionManager().register(ball);
        Pallet pallet1 = new Pallet(Display.getWidth() / 2,0,70,10,new Color(117, 117, 117).getRGB());
        Pallet pallet2 = new Pallet(Display.getWidth() / 2,Display.getHeight(),70,10,new Color(117, 117, 117).getRGB());
        this.pallet1 = pallet1;
        this.pallet2 = pallet2;
        GameManager.getGameManager().getRenderManager().register(pallet1);
        GameManager.getGameManager().getCollisionManager().register(pallet1);
        GameManager.getGameManager().getRenderManager().register(pallet2);
        GameManager.getGameManager().getCollisionManager().register(pallet2);

        startLoop();
    }
}
