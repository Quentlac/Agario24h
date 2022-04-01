package core;

import core.exceptions.MaxPlayerException;

import java.util.ArrayList;

/**
 * Classe représentant la map de agario
 */
public class Map {

    private final static int MAP_WIDTH = 5000;
    private final static int MAP_HEIGHT = 3000;

    private final static int NB_PLAYER_MAX = 10;

    private ArrayList<Player> players;

    public Map() {
        players = new ArrayList<>();
    }

    /**
     * Ajoute un joueur sur la map
     * @param player joueur a ajouté
     */
    public void addPlayer(Player player){

        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }



}
