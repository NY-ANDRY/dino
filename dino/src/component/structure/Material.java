package component.structure;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import component.character.Alive;
import component.game.Game;

public abstract class Material extends Rectangle {

    private String name;
    private int life;
    private Color color;

    private boolean valid;
    private boolean active;
    private double speed;

    private Game game;
    private static Random random;

    // img
    private BufferedImage image;
    private int steps;
    //

    public Material() {
        super();
        setLife(1);
        setSpeed(1);

        setValid(true);
        setValid(true);
    }

    public abstract void move();

    public abstract void effect(Alive valid);

    public abstract void effect(Material obstacle);

    public void animate() {
    }

    public void draw(Graphics2D g2) {
        g2.setColor(getColor());
        g2.fill(this);
    }

    public void oneStep() {
        if (steps < 30) {
            steps++;
            return;
        }
        steps = 0;
    }

    public boolean isDead() {
        return life <= 0;
    }

    public Color getColor() {
        if (color == null) {
            color = randColor();
        }
        return color;
    }

    public void takeDmg() {
        life--;
    }

    public void heal() {
        life++;
    }

    public static Color randColor() {
        return new Color((getRandom().nextInt(256)), (getRandom().nextInt(256)), (getRandom().nextInt(256)));
    }

    public BufferedImage getImage() {
        return image;
    }

    public static Random getRandom() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static void setRandom(Random random) {
        Obstacle.setRandom(random);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
