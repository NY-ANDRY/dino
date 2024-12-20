package component.character;

import java.awt.Color;
import java.awt.Graphics2D;

import component.bonus.Bonus;
import component.game.Game;
import component.structure.Ground;
import component.structure.Material;

public class Alive extends Material {

    private Ground ground;
    private double velocity;

    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;

    private boolean jump;
    private boolean dowwn;
    private boolean lyingDown;
    private int energy;

    public Alive() {
        super();
        setSpeed(1);
        setLife(1);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(new Color(160, 160, 160));
        g2.draw(this);
    }

    // public void oneStep() {
    // if (steps < 30) {
    // steps++;
    // return;
    // }
    // steps = 0;
    // }

    public void animate() {
    }

    public void move() {
        basicMove();
        jumpControl();
        animate();
        check();
    }

    public void printState() {
        System.out.println("y = " + getY() + ", height = " + height);
    }

    public void basicMove() {
        if (right) {
            x += getSpeed();
        }
        if (left) {
            x -= getSpeed();
        }
        if (up) {
            y -= getSpeed();
        }
        if (down) {
            y += getSpeed();
        }
    }

    public void jump() {
        if (!isJump()) {
            setJump(true);
            setVelocity(-18);
        }
    }

    private void jumpControl() {
        if (isJump()) {
            velocity += 0.8;
            y += velocity;
            if (isDowwn()) {
                if (velocity <= 5) {
                    velocity = 5;
                }
                velocity += 0.8;
                y += velocity;
            }
            if (y + height >= getGround().y) {
                y = (int) getGround().getY() - height;
                setJump(false);
                velocity = 0;
            }
        }
    }

    public void down() {
        if (((getY() + height) >= getGround().y)) {
            downPosition();
        }
        setDowwn(true);
    }

    public void up() {
        if (isDowwn()) {
            upPosition();
        }
        setDowwn(false);
    }

    private void check() {
        if (isDowwn()) {
            down();
        }
    }

    private void downPosition() {
        if (!isLyingDown()) {
            y = y + (height / 2);
            int oldHeight = height;
            int oldWidth = width;

            width = oldHeight;
            height = oldWidth;
            setLyingDown(true);
        }
    }

    private void upPosition() {
        if (isLyingDown()) {
            y = y - height;
            int oldHeight = height;
            int oldWidth = width;

            width = oldHeight;
            height = oldWidth;
            setLyingDown(false);
        }
    }

    private boolean useEnergy() {
        if (energy > 0) {
            energy--;
            return true;
        }
        return false;
    }

    public void fire(Game game) {
        if (useEnergy()) {
            Bonus bullet = new Bonus(true);
            bullet.setGame(game);
            bullet.setSpeed(10);
            bullet.x = (int) (this.x + this.getWidth());
            bullet.y = (int) this.y;
            game.getObstacles().add(bullet);
        }
    }

    public void addEnergy() {
        energy++;
    }

    public void takeDmg() {
        super.takeDmg();
    }

    @Override
    public void effect(Alive valid) {
    }

    @Override
    public void effect(Material obstacle) {
    }

    public boolean isJump() {
        return jump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int bullet) {
        this.energy = bullet;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public boolean isDowwn() {
        return dowwn;
    }

    public void setDowwn(boolean dowwn) {
        this.dowwn = dowwn;
    }

    public boolean isLyingDown() {
        return lyingDown;
    }

    public void setLyingDown(boolean lying) {
        this.lyingDown = lying;
    }

}
