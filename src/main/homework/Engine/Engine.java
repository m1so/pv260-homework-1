package Engine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Engine implements KeyListener, MouseListener {
    private Game game;

    private KeyHandler keyHandler;

    private CanvasDrawer canvasDrawer;

    private MouseHandler mouseHandler;

    private ScreenManager screenManager;

    private boolean running;

    private static final DisplayMode modes[] = {
        new DisplayMode(1680, 1050, 32, 0),
        new DisplayMode(800, 600, 32, 0),
        new DisplayMode(800, 600, 24, 0),
        new DisplayMode(800, 600, 16, 0),
        new DisplayMode(640, 480, 32, 0),
        new DisplayMode(640, 480, 24, 0),
        new DisplayMode(640, 480, 16, 0),
    };

    public Engine(Game game) {
        initializeScreenManagement();

        game.setDimensions(screenManager.getWidth(), screenManager.getHeight());

        this.game = game;
        this.keyHandler = game.getKeyHandler();
        this.canvasDrawer = game.getCanvasDrawer();
        this.mouseHandler = game.getMouseHandler();

        bindKeyListener();

        bindMouseListener();
    }

    private void bindMouseListener() {
        Window window = screenManager.getFullScreenWindow();
        window.addMouseListener(this);
    }

    private void bindKeyListener() {
        Window window = screenManager.getFullScreenWindow();
        window.addKeyListener(this);
    }

    private void initializeScreenManagement() {
        this.screenManager = new ScreenManager();
        DisplayMode displayMode = screenManager.findFirstCompatibaleMode(modes);
        screenManager.setFullScreen(displayMode);
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public void run() {
         running = true;

         while (running) {
             game.tick();

             draw();

             fps(50);
         }
    }

    private void fps(int fps) {
        try {
            Thread.sleep(1000 / fps);
        } catch (Exception ex) {
            //
        }
    }

    private void draw() {
        Graphics2D graphics = screenManager.getGraphics();

        canvasDrawer.drawTick(graphics);

        graphics.dispose();
        screenManager.update();
    }

    public void stop() {
        running = false;
    }

    public void keyPressed(KeyEvent e) {
        keyHandler.whenKeyPressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        mouseHandler.whenMousePressed(e.getButton());
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
