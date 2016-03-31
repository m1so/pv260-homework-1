package Tron.Game;

import Engine.CanvasDrawer;
import Engine.Game;
import Engine.KeyHandler;
import Engine.MouseHandler;
import Tron.*;

public class TronGame implements Game {
    public Arena arena;

    public KeyHandler keyHandler;

    public CanvasDrawer canvasDrawer;

    public MouseHandler mouseHandler;

    int width;

    int height;

    public TronGame() {
        arena = new Arena();

        keyHandler = new TronKeyHandler(arena);

        canvasDrawer = new TronDrawer(arena);

        mouseHandler = new TronMouseHandler(arena);
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public CanvasDrawer getCanvasDrawer() {
        return canvasDrawer;
    }

    public MouseHandler getMouseHandler() {
        return mouseHandler;
    }

    public Arena getArena() {
        return arena;
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void tick() {
        for (Player player : arena.getPlayers()) {
            // Move player in a line according to his current direction in the screen's bounds
            PlayerMover.keepMoving(player, width, height);

            // Check collisions
            if (CollisionDetector.checkForPlayer(player, arena.getPlayers())) {
                System.exit(0);
            }

            // Save path
            PlayerPath.save(player);
        }
    }
}
