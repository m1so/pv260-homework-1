package Tron;

public enum MoveKey {
    LEFT(1),

    RIGHT(-1);

    private int direction;

    MoveKey(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
