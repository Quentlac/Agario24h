package client;

import core.Map;
import core.Player;
import processing.core.PApplet;

public class Application extends PApplet {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private Map map;
    private Camera camera;

    private Player main_player;
    private Player player1;
    private Player player2;

    public static void main(String[] args) {
        PApplet.main("client.Application");
    }

    @Override
    public void setup() {
        background(255);

        map = new Map();

        main_player = new Player("Salut", 100, 400, 50);
        player1 = new Player("Devistorm", 50, 100, 80);
        player2 = new Player("Cheerland", 120, 200, 45);

        map.addPlayer(player1);
        map.addPlayer(player2);
        map.addPlayer(main_player);

        camera = new Camera(main_player);

    }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void draw() {
        background(255); // On efface l'écran

        MapUtilitaire.afficheMap(this, camera, map);

        main_player.move(0.5f, 0.2f);
        player1.move(0.2f, 1);


    }
}
