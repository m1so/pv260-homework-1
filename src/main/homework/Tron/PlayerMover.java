package Tron;

import java.awt.*;

public class PlayerMover {
    /**
     *        ^ 0 (UP)
     *        |
     * 3 <---   ---> 1 (RIGHT)
     * (LEFT) |
     *        v 2 (DOWN)
     */
    public static void changeDirection(Player player, MoveKey type) {
        Direction direction = player.getDirection();

        // Set direction
        int turn = type.getDirection();
        Direction newDirection = Direction.values()[Math.floorMod(direction.ordinal() + turn, 4)];
        player.setDirection(newDirection);
    }

    /**
     *        ^ 0 (UP)
     *        |
     * 3 <---   ---> 1 (RIGHT)
     * (LEFT) |
     *        v 2 (DOWN)
     *
     * Keep moving the player in current direction and handle bounds portal
     */
    public static void keepMoving(Player player, int xBound, int yBound) {
        Direction direction = player.getDirection();

        // Project direction into axis' difference and set direction
        Point point = player.getCurrentLocation().getLocation();
        int projectDirectionToYaxisChange = - Math.floorMod(-direction.ordinal() + 1, 2) * (-direction.ordinal() + 1) * Player.MOVEMENT_SPEED;
        int projectDirectionToXaxisChange = Math.floorMod(-direction.ordinal() + 2, 2) * (-direction.ordinal() + 2) * Player.MOVEMENT_SPEED;
        point.translate(projectDirectionToXaxisChange, projectDirectionToYaxisChange);
        point.setLocation(Math.floorMod((int) point.getX(), xBound), Math.floorMod((int) point.getY(), yBound));

        player.setLocation(point);
    }
}
