package component.bonus;

import java.awt.Color;
import java.awt.Graphics2D;

import component.character.Alive;
import component.structure.Ground;
import component.structure.Material;

public class Heal extends Bonus {

    // public Bullet() {
    // super();
    // width = 10;
    // height = 10;
    // setSpeed(3);
    // }

    public Heal(boolean active) {
        super(active);
        width = 20;
        height = 10;
        // setLife(100);
        setColor(new Color(0, 200, 50));
        setSpeed(3);
        this.setActive(active);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(getColor());
        g2.fillRect(x, y, width, height);

        g2.drawString(String.valueOf(getDmg()), ((int) (x + getWidth())), ((int) (y + getHeight())));

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
            for (int i = 0; i < getDmg(); i++) {
                alive.heal();
            }
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
        // if (isActive()) {
        // if (getGame() != null && !obstacle.getClass().isInstance(this)) {
        // obstacle.takeDmg();
        // this.takeDmg();
        // getGame().increaseScore();
        // getGame().increaseScore();
        // }
        // }
        super.effect(obstacle);
    }
}
