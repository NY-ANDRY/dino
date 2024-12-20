package component.enemy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import component.character.Alive;
import component.structure.Material;

public class Cactus extends Enemy {

    private static BufferedImage image11;
    private static BufferedImage image12;
    private static BufferedImage image13;

    public Cactus() {
        super();
        init();
        loadImages();
    }

    private void init() {
        int rand = getRandom().nextInt(15);
        width = 40;
        if (rand >= 5) {
            width = 80;
        } else if (rand >= 10) {
            width = 120;
        }
        height = 100;
        setColor(new Color(100, 100, 100));
        setSpeed(10);
        setActive(true);
    }

    private void loadImages() {
        if (getImage11() == null) {
            try {
                File imageFile11 = new File("assets/obstacle/21.png");
                File imageFile12 = new File("assets/obstacle/22.png");
                File imageFile13 = new File("assets/obstacle/23.png");
                setImage11(ImageIO.read(imageFile11));
                setImage12(ImageIO.read(imageFile12));
                setImage13(ImageIO.read(imageFile13));
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
    }

    @Override
    public void draw(Graphics2D g2) {
        // super.draw(g2);
        if (getImage11() != null) {
            if (width <= 40) {
                g2.drawImage(getImage11(), x, y, width, height, null);
            } else if (width <= 80) {
                g2.drawImage(getImage12(), x, y, width, height, null);
            } else {
                g2.drawImage(getImage13(), x, y, width, height, null);
            }
        } else {
            g2.setColor(getColor());
            g2.draw(this);
            g2.drawString("cactus", x, (int) (y + getHeight()));
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
        Cactus.image11 = image11;
    }

    public BufferedImage getImage12() {
        return image12;
    }

    public void setImage12(BufferedImage image12) {
        Cactus.image12 = image12;
    }

    public static BufferedImage getImage13() {
        return image13;
    }

    public static void setImage13(BufferedImage image13) {
        Cactus.image13 = image13;
    }

}
