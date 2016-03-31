package Tron.Game;

import Engine.MouseHandler;
import Tron.Arena;
import Tron.Keybinding;
import Tron.Player;
import Tron.PlayerMover;

public class TronMouseHandler implements MouseHandler {

    private Arena arena;

    public TronMouseHandler(Arena arena) {
        this.arena = arena;
    }

    public void whenMousePressed(int mouseCode) {
        // Mouse codes are ~ 1-4 (based on # buttons), there are no KEY codes available for this ordinal value
        Player player = arena.getPlayerByKeycode(mouseCode);

        if (player != null) {
            Keybinding keybinding = arena.getKeybindingByKeycode(mouseCode);
            PlayerMover.changeDirection(player, keybinding.getType());
        }
    }
}
