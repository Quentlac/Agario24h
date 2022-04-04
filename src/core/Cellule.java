package core;

/**
 * Classe représentant une cellule d'un joueur, c'est à dire un rond comme dans agario
 */
public class Cellule extends Items2D implements Eatable {

    private Player player;

    /**
     * Création d'une cellule
     * @param posX position horizontal de départ
     * @param posY position vertical de départ
     * @param taille taille du joueur
     */
    public Cellule(Player player, float posX, float posY, float taille) {
        super(posX, posY, taille);
        this.player = player;
    }


    /**
     * Fait grandir la cellule
     * @param n taille de laquelle grandit la cellule
     */
    public void grandit(float n) {
        if(n > 0)
           setTaille(getTaille() + n);
    }

    /**
     * Modifie la position de la cellule
     * @param dX valeur de déplacement horizontal
     * @param dY valeur de déplacement vertical
     */
    public void move(float dX, float dY) {
        setPosition(getPosX() + dX, getPosY() + dY);
    }

    public int getColor() {
        return player.getColor();
    }

    /**
     * Vérifie si un joueur peut manger un item (peut être un autre joueur)
     * @param item
     * @return
     */
    public boolean canEat(Items2D item) {
        return !this.equals(item) & getDistance(item) < getTaille() / 2;
    }

    @Override
    public float seFaitManger() {
        float old_taille = getTaille();
        setTaille(0);
        return old_taille;
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * Mange un élément eatable
     * @param eatable élément à manger
     */
    public void eat(Eatable eatable) {
        grandit(eatable.seFaitManger());
    }

    public boolean isAlive() {
        return getTaille() >= 10;
    }

    @Override
    public int compareTo(Items2D o) {

        if(getTaille() == o.getTaille()) {
            return this.hashCode() - o.hashCode();
        }

        return (int) (getTaille() - o.getTaille());
    }

}