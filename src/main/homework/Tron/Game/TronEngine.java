package Tron.Game;

import Engine.Engine;
import Tron.Arena;
import Tron.CollisionDetector;

public class TronEngine extends Engine {

    private Arena arena;

    public TronEngine(Arena arena) {
        super(new TronKeyHandler(arena), new TronDrawer());

        this.arena = arena;
    }

    public void eachTick() {
        // Check collisions
        if (CollisionDetector.checkCollistions(arena.getPlayers())) {
            stop();
        }

        // Move players ???
    }
}
