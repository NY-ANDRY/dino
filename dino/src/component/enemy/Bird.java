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

public class Bird extends Enemy {

    private static BufferedImage image11;
    private static BufferedImage image12;

    public Bird() {
        super();
        init();
        loadImages();
    }

    private void init() {
        width = 50;
        height = 30;
        setColor(new Color(120, 120, 120));
        setSpeed(10);
        setActive(true);
    }

    private void loadImages() {
        if (getImage11() == null || getImage12() == null) {
            try {
                File imageFile11 = new File("assets/obstacle/31.png");
                File imageFile12 = new File("assets/obstacle/32.png");
                setImage11(ImageIO.read(imageFile11));
                setImage12(ImageIO.read(imageFile12));
                setImage(ImageIO.read(imageFile11));
            } catch (IOException e) {
                // e.printStackTrace();
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
        int result = (int) (ground.getY() - ground.getGame().getPlayer().getHeight());
        // System.out.println(result);
        return result;
    }

    @Override
    public void draw(Graphics2D g2) {
        // super.draw(g2);
        if (getImage() != null) {
            g2.drawImage(getImage(), x, y, width, height, null);
        } else {
            g2.draw(this);
            g2.drawString("bird", x, (int) (y + getHeight()));
        }

        g2.drawString(String.valueOf(getDmg()), ((int) (x + getWidth())), ((int) (y + getHeight())));
        animate();
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
        Bird.image11 = image11;
    }

    public BufferedImage getImage12() {
        return image12;
    }

    public void setImage12(BufferedImage image12) {
        Bird.image12 = image12;
    }
}
