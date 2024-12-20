package component.character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Dino extends Alive {

    private static BufferedImage image11;
    private static BufferedImage image12;
    private static BufferedImage image13;
    private static BufferedImage image21;
    private static BufferedImage image22;
    private static BufferedImage image23;

    public Dino() {
        super();
        height = 100;
        width = 50;
        setLife(100);
        setEnergy(5);
        setSpeed(10);
        loadImages();
    }

    private void loadImages() {
        if (getImage11() != null) {
            return;
        }
        try {
            File imageFile11 = new File("assets/dino/11.png");
            File imageFile12 = new File("assets/dino/12.png");
            File imageFile13 = new File("assets/dino/13.png");
            File imageFile21 = new File("assets/dino/21.png");
            File imageFile22 = new File("assets/dino/22.png");
            File imageFile23 = new File("assets/dino/23.png");
            setImage11(ImageIO.read(imageFile11));
            setImage12(ImageIO.read(imageFile12));
            setImage13(ImageIO.read(imageFile13));
            setImage21(ImageIO.read(imageFile21));
            setImage22(ImageIO.read(imageFile22));
            setImage23(ImageIO.read(imageFile23));
            setImage(ImageIO.read(imageFile11));
        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("Impossible de charger les images !");
        }
    }

    @Override
    public void animate() {
        oneStep();
        if (isJump() && isLyingDown()) {
            setImage(image21);
        } else if (isJump()) {
            setImage(image11);
        } else if (isLyingDown() && getSteps() <= 15) {
            setImage(image22);
        } else if (isLyingDown() && getSteps() > 15) {
            setImage(image23);
        } else if (getSteps() <= 15) {
            setImage(image12);
        } else {
            setImage(image13);
        }
    }

    public void heal() {
        super.heal();
        if (getLife() > 100) {
            setLife(100);
        }
    }

    public void takeDmg() {
        super.takeDmg();
        if (getLife() < 0) {
            setLife(0);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        if (isDead()) {
            g2.setColor(new Color(100, 100, 100));
            g2.draw(this);
        }
        if (getImage() != null) {
            g2.drawImage(getImage(), x, y, width, height, null);
        } else {
            g2.setColor(new Color(160, 160, 160));
            g2.draw(this);
        }
    }

    public BufferedImage getImage11() {
        return image11;
    }

    public void setImage11(BufferedImage image11) {
        Dino.image11 = image11;
    }

    public BufferedImage getImage12() {
        return image12;
    }

    public void setImage12(BufferedImage image12) {
        Dino.image12 = image12;
    }

    public BufferedImage getImage13() {
        return image13;
    }

    public void setImage13(BufferedImage image13) {
        Dino.image13 = image13;
    }

    public BufferedImage getImage21() {
        return image21;
    }

    public void setImage21(BufferedImage image21) {
        Dino.image21 = image21;
    }

    public BufferedImage getImage22() {
        return image22;
    }

    public void setImage22(BufferedImage image22) {
        Dino.image22 = image22;
    }

    public BufferedImage getImage23() {
        return image23;
    }

    public void setImage23(BufferedImage image23) {
        Dino.image23 = image23;
    }

    @Override
    public void effect(Alive valid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'effect'");
    }

}