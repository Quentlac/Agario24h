package core;

import core.exceptions.MaxPlayerException;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Classe représentant la map de agario
 */
public class Map {

    private final static int MAP_WIDTH = 10000;
    private final static int MAP_HEIGHT = 5000;

    private final static int NB_PLAYER_MAX = 10;

    private ArrayList<Player> players;
    private ArrayList<EatPoint> eatPoints;

    public Map() {
        players = new ArrayList<>();
        eatPoints = new ArrayList<>();

        // On génère des eats points au hasard
        for(int i = 0; i < 800; i++) {
            genereRandomEatPoint();
        }
    }

    /**
     * Ajoute un joueur sur la map
     * @param player joueur a ajouté
     */
    public void addPlayer(Player player){
        players.add(player);
    }

    /**
     * Retourne tout les joueurs en vie
     * @return liste des joueurs en vie
     */
    public ArrayList<Player> getPlayers() {
        ArrayList players_alive = new ArrayList();

        for(Player p : players) {
            if(p.isAlive()) {
                players_alive.add(p);
            }
        }

        return players_alive;
    }

    public ArrayList<EatPoint> getEatPoints() {
        return eatPoints;
    }

    /**
     * Retoune toutes les cellules de la map trié par taille
     * @return toutes les cellules de la map
     */
    public TreeSet<Cellule> getCellules() {
        TreeSet<Cellule> cellules = new TreeSet<>();

        for(Player p : getPlayers()) {
            for(Cellule cellule : p.getCellules()) {
                cellules.add(cellule);
            }
        }

        return cellules;
    }


    /**
     * Retourne l'ensemble des objets
     * @return
     */
    public ArrayList<Eatable> getEatables() {
        ArrayList<Eatable> items = new ArrayList<>();

        for(Player p : players) {
            for(Cellule cellule: p.getCellules()) {
                items.add(cellule);
            }
        }

        items.addAll(getEatPoints());
        return items;
    }

    /**
     * Cette fonction va générer un nouvel eat point
     */
    public void genereRandomEatPoint() {
        float posX = (float) Math.random() * MAP_WIDTH - MAP_WIDTH / 2;
        float posY = (float) Math.random() * MAP_HEIGHT - MAP_HEIGHT / 2;
        int color = (int) (Math.random()*255);

        eatPoints.add(new EatPoint(posX, posY, color));
    }


    /**
     * Supprime un item sur la map
     * @param item item à supprimer
     */
    public void removeItem(Items2D item) {
        if(eatPoints.contains((Eatable) item))
            eatPoints.remove(item);

        if(players.contains((Eatable) item))
            players.remove(item);
    }
}
