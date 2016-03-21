package Engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Engine implements KeyListener {
    private KeyHandler keyHandler;

    private CanvasDrawer canvasDrawer;

    private boolean running;

    public Engine(KeyHandler keyHandler, CanvasDrawer canvasDrawer) {
        this.keyHandler = keyHandler;
        this.canvasDrawer = canvasDrawer;
    }

    public void run() {
         running = true;

         while (running) {
             eachTick();
             // get graphics - pass to draw tick
             // canvasDrawer.drawTick();
         }
    }

    public void stop() {
        running = false;
    }

    abstract public void eachTick();

    public void keyPressed(KeyEvent e) {
        keyHandler.whenKeyPressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}
