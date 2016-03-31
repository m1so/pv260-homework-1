import Engine.Engine;
import Tron.Controls;
import Tron.Direction;
import Tron.Exceptions.MultiplePlayersCannotHaveSameControls;
import Tron.Game.TronGame;
import Tron.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tron {
    public static void main(String[] args) {
        // Bootstrap the world
        TronGame tron = new TronGame();

        try {
            // Key controls - A, S
            tron.getArena().addPlayerWithControls(
                    new Player(Direction.DOWN, new Point(20, 20), Color.BLUE),
                    new Controls(KeyEvent.VK_A, KeyEvent.VK_S)
            );
            // Key controls - Right Arrow, Left Arrow
            tron.getArena().addPlayerWithControls(
                    new Player(Direction.LEFT, new Point(700, 700), Color.RED),
                    new Controls(KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT)
            );
            // Mouse controls
            tron.getArena().addPlayerWithControls(
                    new Player(Direction.UP, new Point(300, 300), Color.GREEN),
                    new Controls()
            );
        } catch (MultiplePlayersCannotHaveSameControls e) {
            System.out.println("Multiple players cannot have the same controls");
        }

        // Run the game
        Engine engine = new Engine(tron);
        engine.run();
    }
}
