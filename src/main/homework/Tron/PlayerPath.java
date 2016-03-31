package Tron;

import java.util.List;

public class PlayerPath {

    public static void save(Player player) {
        player.addToPath(player.getCurrentLocation());
    }


    public static void saveAll(List<Player> players) {
        for (Player player : players) {
            PlayerPath.save(player);
        }
    }
}
