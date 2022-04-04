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
        super(0, 0, 0);
        this.target = target;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public Player getTarget() {
        return target;
    }

    public float getWidth() {
        return CAMERA_WIDTH * (1f / getZoom());
    }

    public float getHeight() {
        return CAMERA_HEIGHT * (1f / getZoom());
    }

    /**
     * Calcul le taux de zoom en fonction de la taille du joueur suivis
     * @return
     */
    public float getZoom() {
        return (float) Math.max(1 - 0.001f * target.getTailleTotal(), 0.2);
    }

    /**
     * Vérifie si un item est dans le champ de la caméra
     * @param item item sur lequel testé
     * @return vrai si l'item est dans le champ de la caméra
     */
    public boolean itemIsInsideCamera(Items2D item) {
        return Math.abs(item.getPosX() - getPosX()) <= (item.getTaille() + getWidth()) / 2
            && Math.abs(item.getPosY() - getPosY()) <= (item.getTaille() + getHeight()) / 2;
    }

    @Override
    public float getPosX() {
        return target.getCentre().getPosX();
    }

    @Override
    public float getPosY() {
        return target.getCentre().getPosY();
    }
}
