package core;

import java.util.ArrayList;

public class Player {
    private final static float DEFAULT_TAILLE = 60;

    private String nom;
    private ArrayList<Cellule> cellules;
    private Attracteur attracteur;

    private int color;


    public Player(String nom, float posX, float posY, int color) {
        attracteur = new Attracteur(posX, posY);
        cellules = new ArrayList<>();
        cellules.add(new Cellule(this, posX - DEFAULT_TAILLE / 2, posY, DEFAULT_TAILLE));
        cellules.add(new Cellule(this, posX + DEFAULT_TAILLE / 2, posY, DEFAULT_TAILLE));
        this.nom = nom;
    }

    public void setColor(int color) {
        if(color > 255) {
            this.color = 255;
        }
        if(color < 0) {
            this.color = 0;
        }
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public ArrayList<Cellule> getCellules() {
        return cellules;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Retourne la taille total d'un joueur
     * @return
     */
    public float getTailleTotal() {
        float total = 0;

        for(Cellule cellule : getCellules()) {
            total += cellule.getTaille();
        }

        return total;
    }

    /**
     * Retourne le centre de gravité du joueur
     * @return
     */
    public Point getCentre() {

        float moyenneX = 0;
        float moyenneY = 0;

        for(Cellule cell : getCellules()) {
            moyenneX += cell.getPosX();
            moyenneY += cell.getPosY();
        }

        moyenneX /= getCellules().size();
        moyenneY /= getCellules().size();

        return new Point(moyenneX, moyenneY);

    }

    /**
     * Vérifie si le jour est encore vivant
     * @return Vrai si il est toujours en vie
     */
    public boolean isAlive() {
        return getTailleTotal() > 0;
    }

    public void move() {

    }
}

