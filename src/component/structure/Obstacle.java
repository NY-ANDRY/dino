package component.structure;

import java.awt.Graphics2D;

public abstract class Obstacle extends Material {

    int dmg;

    public Obstacle() {
        super();
        setDmg(1);
        setValid(true);
        setValid(true);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(getColor());
        g2.fill(this);
    }

    @Override
    public void move() {
        x -= getSpeed();
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

}
