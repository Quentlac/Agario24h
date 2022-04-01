package client;

import core.Map;
import core.Player;
import processing.core.PApplet;

public class MapUtilitaire {

    /**
     * Affichage de la map
     * @param s contexte processing
     * @param camera caméra à utiliser pour afficher la map
     * @param map map à afficher
     */
    public static void afficheMap(PApplet s, Camera camera, Map map) {
        s.pushMatrix();

        // on définit le point d'origine au milieu de l'écran
        s.translate(Application.WIDTH / 2, Application.HEIGHT / 2);

        // On affiche tout les joueurs qui sont dans le champ de la caméra
        for(Player p : map.getPlayers()) {
            if(camera.playerIsInsideCamera(p)) {
                PlayerUtilitaire.affichePlayer(s, camera, p);
            }
        }

        s.popMatrix();

    }

}
