package core;

/**
 * Classe représentant un joueur, c'est à dire un rond comme dans agario
 */
public class Player extends Items2D {

    private float taille; // Rayon du cercle
    private String nom;

    /**
     * Création d'un joueur
     * @param nom nom du joueur
     * @param posX position horizontal de départ
     * @param posY position vertical de départ
     * @param taille taille du joueur
     */
    public Player(String nom, float posX, float posY, float taille) {
        super(posX, posY);
        setTaille(taille);
        this.nom = nom;
    }

    /**
     * Modifie la taille du joueur (minimum 10)
     * @param taille taille du joueur (> 10)
     */
    public void setTaille(float taille) {
        if(taille < 10) {
            this.taille = 10;
        }
        else {
            this.taille = taille;
        }
    }

    /**
     * Fait grandir le joueur
     * @param n taille de laquelle grandit le joueur
     */
    public void grandit(float n) {
        if(n > 0)
            this.taille += n;
    }

    public float getTaille() {
        return taille;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Modifie la position du joueur
     * @param dX valeur de déplacement horizontal
     * @param dY valeur de déplacement vertical
     */
    public void move(float dX, float dY) {
        setPosition(getPosX() + dX, getPosY() + dY);
    }
}