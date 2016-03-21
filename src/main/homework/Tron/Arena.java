package Tron;

import java.util.List;
import java.util.Map;

public class Arena {
    private List<Player> players;

    private Map<Player, Controls> controls;

    private int width;

    private int height;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addControls(Player player, Controls controls) {
        this.controls.put(player, controls);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Controls getPlayerControls(Player player) {
        return controls.get(player);
    }
}
