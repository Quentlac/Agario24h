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
        afficheGrille(s, camera);
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

    /**
     * Permet d'afficher la grille en arrière plan
     * @param s contexte processing
     * @param c camera
     */
    private static void afficheGrille(PApplet s, Camera c) {

        int dX = Application.WIDTH / 30;
        s.stroke(240);
        s.strokeWeight(2);

        for(int i = 0; i <= 30 ; i++) {
            float offset_x = - c.getPosX() % dX;
            float offset_y = - c.getPosY() % dX;

            s.line(i * dX + offset_x, 0, i * dX + offset_x, Application.HEIGHT);
            s.line(0, i * dX + offset_y, Application.WIDTH, i * dX + offset_y);
        }

    }

}
