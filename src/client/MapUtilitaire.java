package client;

import core.Cellule;
import core.EatPoint;
import core.Map;
import core.Player;
import processing.core.PApplet;

import java.util.Iterator;

public class MapUtilitaire {

    /**
     * Affichage de la map
     * @param s contexte processing
     * @param camera caméra à utiliser pour afficher la map
     * @param map map à afficher
     */
    public static void afficheMap(PApplet s, Camera camera, Map map) {


        s.pushMatrix();
        s.translate(Application.WIDTH / 2, Application.HEIGHT / 2);
        s.scale(camera.getZoom());

        afficheGrille(s, camera);

        // on définit le point d'origine au milieu de l'écran

        afficheEatPoint(s, camera, map);

        // On affiche toutes les cellules qui sont dans le champ de vision
        for(Iterator it = map.getCellules().iterator(); it.hasNext();) {
            Cellule cellule = (Cellule) it.next();

            if(camera.itemIsInsideCamera(cellule)) {
                PlayerUtilitaire.afficheCellule(s, camera, cellule);
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

        float dX = c.getWidth() / 30;
        dX *= c.getZoom();

        s.stroke(240);
        s.strokeWeight(2);

        for(int i = 0; i <= 30 * (1 / c.getZoom()) ; i++) {
            float offset_x = - c.getPosX() % dX - c.getWidth() / 2;
            float offset_y = - c.getPosY() % dX - c.getWidth() / 2;

            s.line(i * dX + offset_x, - c.getHeight() / 2, i * dX + offset_x, c.getHeight() / 2);
            s.line(- c.getWidth() / 2, i * dX + offset_y, c.getWidth() / 2, i * dX + offset_y);
        }

    }

    private static void afficheEatPoint(PApplet s, Camera c, Map map) {
        for(EatPoint eatPoint : map.getEatPoints()) {
            if(c.itemIsInsideCamera(eatPoint)) {
                s.stroke(0);
                s.colorMode(PApplet.HSB);
                s.fill(eatPoint.getColor(), 255, 255);
                s.ellipse(eatPoint.getPosX() - c.getPosX(), eatPoint.getPosY() - c.getPosY(), 20, 20);
                s.colorMode(PApplet.RGB);
            }
        }
    }

}
