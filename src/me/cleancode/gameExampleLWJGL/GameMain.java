package me.cleancode.gameExampleLWJGL;

import me.cleancode.gameExampleLWJGL.core.Gui;
import me.cleancode.gameExampleLWJGL.game.Ball;
import me.cleancode.gameExampleLWJGL.game.MainGameLoop;
import me.cleancode.gameExampleLWJGL.game.manager.GameManager;
import org.lwjgl.opengl.Display;

import java.awt.*;

public class GameMain {

    private Thread gameThread;

    private static GameMain instance;

    private GameMain() {
        instance = this;
        gameThread = new Thread(this::run);
        start();
    }

    private void start() {
        gameThread.start();
    }

    public void stop() {
        gameThread.stop();
        System.exit(0);
    }

    private void run() {
        Gui.create();
        new MainGameLoop().startLoop();
    }

    public static void main(String[] args) {
        new GameMain();
    }

    public static GameMain getInstance() {
        return instance;
    }
}
