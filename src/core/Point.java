package core;

public class Point {

    private float posX;
    private float posY;


    public Point() {
        this(0, 0);
    }

    public Point(float posX, float posY) {
        setPosition(posX, posY);
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public void setPosition(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
    }

}
