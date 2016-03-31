package Tron;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Player {
    // Direction to changeDirection
    private Direction direction;

    // Current position x,y
    private Point location;

    // Movement speed
    public static int MOVEMENT_SPEED = 5;

    // Path which player moved on
    private List<Point> path;

    // Player's color
    private Color color;

    public Player(Direction direction, Point location, Color color) {
        this.direction = direction;
        this.location = location;
        this.color = color;

        this.path = new ArrayList<Point>();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Point getCurrentLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public List<Point> getPath() {
        return path;
    }

    public void addToPath(Point point) {
        path.add(point);
    }

    public Color getColor() {
        return color;
    }

    // Set players keys for moving right, left

}

