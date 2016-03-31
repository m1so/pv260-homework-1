package Tron;

public class Keybinding {
    private MoveKey type;

    private int keyCode;

    public Keybinding(MoveKey type, int keyCode) {
        this.type = type;
        this.keyCode = keyCode;
    }

    public MoveKey getType() {
        return type;
    }

    public int getKeyCode() {
        return keyCode;
    }
}
