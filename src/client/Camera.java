package client;

import core.Items2D;
import core.Player;

/**
 * Représente la caméra, c'est à dire la partie visible de la map par le joueur
 */
public class Camera extends Items2D {

    private final int CAMERA_WIDTH = Application.WIDTH;
    private final int CAMERA_HEIGHT = Application.HEIGHT;

    private Player target;

    /**
     * Créé une caméra qui cible un joueur
     * @param target joueur à suivre
     */
    public Camera(Player target) {
        super(target.getPosX(), target.getPosY());
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public Player getTarget() {
        return target;
    }

    public float getWidth() {
        return CAMERA_WIDTH;
    }

    public float getHeight() {
        return CAMERA_HEIGHT;
    }

    /**
     * Vérifie si un joueur est dans le champ de la caméra
     * @param player joueur sur lequel testé
     * @return vrai si le joueur est dans le champ de la caméra
     */
    public boolean playerIsInsideCamera(Player player) {
        return Math.abs(player.getPosX() - getPosX()) <= (player.getTaille() + getWidth()) / 2
            && Math.abs(player.getPosY() - getPosY()) <= (player.getTaille() + getHeight()) / 2;
    }
}
