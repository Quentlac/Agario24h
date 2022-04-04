package client;

import core.GameEngine;
import core.Map;
import core.Player;
import processing.core.*;


public class Application extends PApplet {

    // Ceci est un test

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private Map map;
    private Camera camera;
    private GameEngine gameEngine;

    private Player main_player;
    private Player player1;
    private Player player2;

    public static void main(String[] args) {
        PApplet.main("client.Application");
    }

    @Override
    public void setup() {
        background(255);
        frameRate(60);

        map = new Map();
        gameEngine = new GameEngine(map);

        main_player = new Player("Salut", 100, 400, 50);

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

        float dX = 0;
        float dY = 0;

        dX = map(mouseX, 0, WIDTH, -5, 5);
        dY = map(mouseY, 0, HEIGHT, -5, 5);

        gameEngine.run();


    }

}
