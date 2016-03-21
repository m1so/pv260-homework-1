import Tron.Arena;
import Tron.Game.TronEngine;
import Tron.Player;

public class TronGame {
    public static void main(String[] args) {
        // Bootstrap the world
        Arena arena = new Arena();

        // TODO: Add player colors and controls
        Player rick = new Player();
        arena.addPlayer(rick);

        TronEngine engine = new TronEngine(arena);

        // Run the game
        engine.run();
    }
}
