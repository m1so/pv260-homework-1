package Engine;

public interface Game {
    KeyHandler getKeyHandler();

    CanvasDrawer getCanvasDrawer();

    MouseHandler getMouseHandler();

    void setDimensions(int width, int height);

    void tick();
}
