package core;

/**
 * Représente un objet en 2D avec des coordonnées
 */
public abstract class Items2D extends Point implements Comparable<Items2D> {

    private float taille; // Rayon du cercle

    public Items2D() {
        this(0, 0, 0);
    }

    public Items2D(float posX, float posY, float taille) {
        super(posX, posY);
        setTaille(taille);
    }


    /**
     * Modifie la taille de l'item
     * @param taille taille
     */
    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getTaille() {
        return taille;
    }


    /**
     * Retourne la distance avec un autre item
     * @param item
     * @return
     */
    public double getDistance(Items2D item) {
        return Math.sqrt(Math.pow(getPosX() - item.getPosX(), 2) + Math.pow(getPosY() - item.getPosY(), 2));
    }

    @Override
    public int compareTo(Items2D o) {
        return (int) (getTaille() - o.getTaille());
    }
}
