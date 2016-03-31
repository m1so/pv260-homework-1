package Tron;

import java.awt.event.MouseEvent;

public class Controls {
    private Keybinding[] keybindings = new Keybinding[2];

    /**
     * Mouse constructor
     */
    public Controls() {
        keybindings[0] = new Keybinding(MoveKey.LEFT, MouseEvent.BUTTON1);
        keybindings[1] = new Keybinding(MoveKey.RIGHT, MouseEvent.BUTTON3);
    }

    /**
     * Keys constructor
     */
    public Controls(int leftKey, int rightKey) {
        keybindings[0] = new Keybinding(MoveKey.LEFT, leftKey);
        keybindings[1] = new Keybinding(MoveKey.RIGHT, rightKey);
    }

    public Keybinding getLeftKeybinding() {
        return keybindings[0];
    }

    public Keybinding getRightKeybinding() {
        return keybindings[1];
    }
}
