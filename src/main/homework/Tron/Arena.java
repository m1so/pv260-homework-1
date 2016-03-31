package Tron;

import Tron.Exceptions.MultiplePlayersCannotHaveSameControls;

import java.util.*;

public class Arena {

    private Map<Player, Controls> controls;

    public Arena() {
        this.controls = new HashMap<Player, Controls>();
    }

    public void addPlayerWithControls(Player player, Controls controls) throws MultiplePlayersCannotHaveSameControls {
        List<Player> playersFound = new ArrayList<Player>();

        for (Map.Entry<Player, Controls> entry : this.controls.entrySet()) {
            Controls playerControls = entry.getValue();

            if (
                controls.getLeftKeybinding().getKeyCode() == playerControls.getLeftKeybinding().getKeyCode()
                || controls.getRightKeybinding().getKeyCode() == playerControls.getRightKeybinding().getKeyCode()
                || controls.getRightKeybinding().getKeyCode() == playerControls.getLeftKeybinding().getKeyCode()
                || controls.getLeftKeybinding().getKeyCode() == playerControls.getRightKeybinding().getKeyCode()
            ) {
                playersFound.add(entry.getKey());
            }
        }

        if (playersFound.size() > 1) {
            throw new MultiplePlayersCannotHaveSameControls();
        }

        this.controls.put(player, controls);
    }

    public Set<Player> getPlayers() {
        return controls.keySet();
    }

    public Controls getPlayerControls(Player player) {
        return controls.get(player);
    }

    public Player getPlayerByKeycode(int key) {
        List<Player> playersFound = new ArrayList<Player>();

        for (Map.Entry<Player, Controls> entry : controls.entrySet()) {
            Controls playerControls = entry.getValue();

            if (key == playerControls.getLeftKeybinding().getKeyCode() || key == playerControls.getRightKeybinding().getKeyCode()) {
                playersFound.add(entry.getKey());
            }
        }

        return playersFound.size() == 1 ? playersFound.get(0) : null;
    }

    public Keybinding getKeybindingByKeycode(int keyCode) {
        Player player = getPlayerByKeycode(keyCode);

        if (player != null) {
            Controls controls = getPlayerControls(player);

            return keyCode == controls.getLeftKeybinding().getKeyCode() ? controls.getLeftKeybinding() : controls.getRightKeybinding();
        }

        return null;
    }
}
