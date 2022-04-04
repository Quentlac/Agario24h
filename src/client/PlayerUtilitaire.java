package client;

import core.Cellule;
import core.Player;
import processing.core.PApplet;

/**
 * Classe utilitaire pour les joueurs
 */
public class PlayerUtilitaire {

    /**
     * Affiche un joueur
     * @param s contexte processing pour utiliser les fonctions graphiques
     * @param camera caméra à utiliser pour afficher le joueur (calcul des positions relatives)
     * @param cellule cellule à afficher
     */
    public static void afficheCellule(PApplet s, Camera camera, Cellule cellule) {
        s.stroke(0);
        s.colorMode(PApplet.HSB);
        s.fill(cellule.getColor(), 255, 255);
        s.ellipse(cellule.getPosX() - camera.getPosX(), cellule.getPosY() - camera.getPosY(), cellule.getTaille(), cellule.getTaille());
        s.colorMode(PApplet.RGB);
        s.fill(0);
        s.textSize(cellule.getTaille() / 3);
        s.textAlign(PApplet.CENTER);
        s.text(cellule.getPlayer().getNom(), cellule.getPosX() - camera.getPosX(), cellule.getPosY() - camera.getPosY() + 5);
    }

}
