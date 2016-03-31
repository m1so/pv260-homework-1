package Tron.Game;

import Engine.CanvasDrawer;
import Tron.Arena;
import Tron.Player;

import java.awt.*;

public class TronDrawer implements CanvasDrawer {
    private Arena arena;

    public TronDrawer(Arena arena) {
        this.arena = arena;
    }

    public void drawTick(Graphics2D graphics) {
        // Color background
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, 9999, 9999);


        // Draw the path traveled for all players
        for (Player player : arena.getPlayers()) {
            // System.out.println("Drawing player: " + player.getColor().toString());

            for (Point point : player.getPath()) {
                // System.out.println("Drawing point: " + point.toString());
                graphics.setColor(player.getColor());
                graphics.fillRect((int) point.getX(), (int) point.getY(), 10, 10);
            }
        }
    }
}
