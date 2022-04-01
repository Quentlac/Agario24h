package client;

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
     * @param player joueur à afficher
     */
    public static void affichePlayer(PApplet s, Camera camera, Player player) {
        s.fill(255, 0, 0);
        s.stroke(0);
        s.ellipse(player.getPosX() - camera.getPosX(), player.getPosY() - camera.getPosY(), player.getTaille(), player.getTaille());
    }

}
