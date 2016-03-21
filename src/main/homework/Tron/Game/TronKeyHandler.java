package Tron.Game;

import Engine.KeyHandler;
import Tron.Arena;

// TODO: Clean up
public class TronKeyHandler implements KeyHandler {
    private Arena arena;

    public TronKeyHandler(Arena arena) {
        this.arena = arena;
    }

    public void whenKeyPressed(int keyCode) {
        // Match the correct player based on his key-bindings

        // If there is more than 1 player found - throw that key-bindings are unique

        // Set the player's direction based on the key

    }
}
