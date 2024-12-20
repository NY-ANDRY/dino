package component.enemy;

import java.awt.Color;
import java.awt.Graphics2D;

import component.character.Alive;
import component.structure.Ground;
import component.structure.Material;
import component.structure.Obstacle;

public class Enemy extends Obstacle {

    public Enemy() {
        super();
        width = 50;
        height = 50;
        setColor(new Color(255, 60, 60));
        setSpeed(10);
        setActive(true);
        loadImages();
        setDmg(10);
    }

    private void loadImages() {
    }

    @Override
    public void animate() {
    }

    public int randomY(Ground ground) {
        return (int) (ground.getY() - getHeight());
    }

    public void takeDmg() {
        super.takeDmg();
        if (isDead()) {
            setValid(false);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        if (getImage() != null) {
            g2.drawImage(getImage(), x, y, width, height, null);
        } else {
            g2.setColor(getColor());
            g2.fill(this);
        }
        animate();
    }

    @Override
    public void effect(Alive vivant) {
        if (this.isActive()) {
            for (int i = 0; i < getDmg(); i++) {
                vivant.takeDmg();
            }
            setActive(false);
            if (!vivant.isDead()) {
                setValid(false);
            }
        }
    }

    @Override
    public void effect(Material obstacle) {
    }

}
