package component.bonus;

import java.awt.Color;
import java.awt.Graphics2D;

import component.character.Alive;
import component.structure.Ground;
import component.structure.Material;
import component.structure.Obstacle;

public class Bonus extends Obstacle {

    // public Bullet() {
    // super();
    // width = 10;
    // height = 10;
    // setSpeed(3);
    // }

    public Bonus(boolean active) {
        super();
        width = 10;
        height = 10;
        setColor(new Color(0, 200, 50));
        setSpeed(3);
        this.setActive(active);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(getColor());
        g2.fillOval(x, y, width, height);
    }

    @Override
    public void move() {
        if (isActive()) {
            x += getSpeed();
        } else {
            x -= getSpeed();
        }
    }

    @Override
    public void effect(Alive alive) {
        if (isValid()) {
            alive.addEnergy();
            this.setValid(false);
        }
    }

    public void takeDmg() {
        super.takeDmg();
        if (isDead()) {
            setValid(false);
        }
    }

    public int randomY(Ground ground) {
        int result = (int) (ground.y - this.getHeight());
        int rand = getRandom().nextInt((int) (ground.getGame().getPlayer().getHeight() * 2));
        return result - rand + 10;
    }

    @Override
    public void effect(Material obstacle) {
        if (isActive()) {
            if (getGame() != null && !obstacle.getClass().isInstance(this)) {

                // if (getGame() != null && !obstacle.getClass().isInstance(this)
                // && !obstacle.getClass().isInstance(new Heal(false))) {

                obstacle.takeDmg();
                this.takeDmg();
                getGame().increaseScore();
                getGame().increaseScore();
            }
        }
    }

}