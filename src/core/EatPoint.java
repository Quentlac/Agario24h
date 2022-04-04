package core;

/**
 * Ce sont les points que l'on peut manger
 */
public class EatPoint extends Items2D implements Eatable {

    private int color;

    public EatPoint(float posX, float posY, int color) {
        super(posX, posY, 5);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    @Override
    public float seFaitManger() {
        return getTaille();
    }
}
