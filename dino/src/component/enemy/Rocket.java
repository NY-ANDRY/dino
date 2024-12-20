package component.enemy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import component.character.Alive;
import component.structure.Ground;
import component.structure.Material;

public class Rocket extends Enemy {

    private static BufferedImage image11;
    private static BufferedImage image12;

    public Rocket() {
        super();
        init();
        loadImages();
    }

    private void init() {
        int form = getRandom().nextInt(10);
        width = 50;
        if (form > 7) {
            width = 100;
            // setLife(2);
        }
        height = 50;
        setColor(new Color(255, 60, 60));
        setSpeed(10);
        setActive(true);
    }

    private void loadImages() {
        if (getImage11() == null || getImage12() == null) {
            try {
                File imageFile11 = new File("assets/obstacle/11.png");
                File imageFile12 = new File("assets/obstacle/12.png");
                setImage11(ImageIO.read(imageFile11));
                setImage12(ImageIO.read(imageFile12));
                setImage(ImageIO.read(imageFile11));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Impossible de charger les images !");
            }
        }
    }

    @Override
    public void animate() {
        oneStep();
        if (getSteps() > 15) {
            setImage(image11);
        } else {
            setImage(image12);
        }
    }

    public int randomY(Ground ground) {
        int result = (int) (ground.y - this.getHeight());
        int rand = getRandom().nextInt((int) (ground.getGame().getPlayer().getHeight() * 1.5));
        return result - rand + 10;
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        g2.drawString(String.valueOf(getDmg()), ((int) (x + getWidth())), ((int) (y + getHeight())));

        // if (getImage() != null) {
        // g2.drawImage(getImage(), x, y, width, height, null);
        // } else {
        // g2.setColor(getColor());
        // g2.fill(this);
        // }
        // animate();
    }

    @Override
    public void effect(Alive vivant) {
        // if (this.isActive()) {
        // vivant.takeDmg();
        // setActive(false);
        // if (!vivant.isDead()) {
        // setValid(false);
        // }
        // }
        super.effect(vivant);
    }

    @Override
    public void effect(Material obstacle) {
    }

    public BufferedImage getImage11() {
        return image11;
    }

    public void setImage11(BufferedImage image11) {
        Rocket.image11 = image11;
    }

    public BufferedImage getImage12() {
        return image12;
    }

    public void setImage12(BufferedImage image12) {
        Rocket.image12 = image12;
    }

}
