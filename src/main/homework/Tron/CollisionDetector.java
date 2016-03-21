package Tron;

import java.awt.*;
import java.util.List;

public class CollisionDetector {

    /**
     * Checks collisions between all given players (also accounts for self-collision)
     */
    public static boolean checkCollistions(List<Player> players) {
        for (Player collidee : players) {
            for (Player collider : players) {
                if (betweenPlayers(collidee, collider)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean betweenPlayers(Player collidee, Player collider) {
        for (Point point : collidee.getPath()) {
            if (collider.getPath().contains(point)) {
                return true;
            }
        }

        return false;
    }
}
