package Tron.Game;

import Engine.KeyHandler;
import Tron.*;

public class TronKeyHandler implements KeyHandler {

    private Arena arena;

    public TronKeyHandler(Arena arena) {
        this.arena = arena;
    }

    public void whenKeyPressed(int keyCode) {
        // Match the correct player based on his key-bindings
        Player player = arena.getPlayerByKeycode(keyCode);

        if (player != null) {
            Keybinding keybinding = arena.getKeybindingByKeycode(keyCode);
            PlayerMover.changeDirection(player, keybinding.getType());
        }
    }
}
