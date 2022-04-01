package client;

import core.Map;
import core.Player;
import processing.core.PApplet;

public class Application extends PApplet {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private Map map;
    private Camera camera;

    public static void main(String[] args) {
        PApplet.main("client.Application");
    }

    @Override
    public void setup() {
        background(255);

        map = new Map();

        Player player1 = new Player("Devistorm", 50, 100, 80);
        Player player2 = new Player("Cheerland", 120, 200, 45);

        map.addPlayer(player1);
        map.addPlayer(player2);

        camera = new Camera(player1);

    }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void draw() {
        background(255); // On efface l'écran

        MapUtilitaire.afficheMap(this, camera, map);

    }
}
