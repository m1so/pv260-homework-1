package Tron;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class CollisionDetector {

    /**
     * Checks collisions between all given players (also accounts for self-collision)
     */
    public static boolean checkCollistions(Set<Player> players) {
        for (Player collidee : players) {
            for (Player collider : players) {
                if (betweenPlayers(collidee, collider)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Check collisions for given players with all other provided players
     */
    public static boolean checkForPlayer(Player player, Set<Player> players) {
        for (Player colidee : players) {
            if (betweenPlayers(colidee, player)) {
                return true;
            }
        }

        return false;
    }

    private static boolean betweenPlayers(Player collidee, Player collider) {
        if (collidee == null || collider == null) {
            return false;
        }

        for (Point point : collidee.getPath()) {
            if (point.equals(collider.getCurrentLocation())) {
                System.out.println("Collision between " + collidee.getColor() + " and " + collider.getColor() + ": " + point);

                return true;
            }
        }

        return false;
    }
}
