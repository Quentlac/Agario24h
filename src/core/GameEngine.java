package core;

import java.util.Iterator;

public class GameEngine {

    private Map map;

    public GameEngine(Map map) {
        this.map = map;
    }

    public void run() {
        for(Iterator it = map.getPlayers().iterator(); it.hasNext();) {
            Player player = (Player) it.next();
            for(Cellule cell : player.getCellules()) {
                for (Iterator it2 = map.getEatables().iterator(); it2.hasNext(); ) {
                    Eatable eatable = (Eatable) it2.next();

                    if (cell.canEat((Items2D) eatable)) {
                        cell.eat(eatable);
                        map.removeItem((Items2D) eatable);
                    }
                }
            }
        }
    }
}
