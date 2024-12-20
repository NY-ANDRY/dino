package component.generator;

import java.awt.event.ActionEvent;

import component.enemy.Bird;
import component.enemy.Cactus;
import component.enemy.Enemy;
import component.enemy.Rocket;
import component.game.GameTimer;

public class EnemyGenerator extends Generator {

    public EnemyGenerator(GameTimer game) {
        super(game);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getGame().getObstacles().add(getObstacle());
        int[] delay = timerDelay();
        getGameTimer().getTimerWall().setDelay(randomDelai(delay[0], delay[1]));
    }

    @Override
    public Enemy getObstacle() {
        int rand = getRandom().nextInt(10);
        Enemy enemy = null;
        if (rand < 5) {
            enemy = new Cactus();
        } else if (rand < 8) {
            enemy = new Bird();
        } else {
            enemy = new Rocket();
        }
        // enemy = new Rocket();

        int dmg = getRandom().nextInt(8);
        dmg++;
        enemy.setDmg(dmg * 10);

        enemy.x = getGame().getFenetre().getWidth();
        enemy.y = enemy.randomY(getGame().getGround());
        enemy.setSpeed(getSpeed());
        return enemy;
    }

    private int getSpeed() {
        int lvl = getGame().lvl();
        return lvl * 2 + 5;
    }

    private int[] timerDelay() {
        int lvl = getGame().lvl();
        switch (lvl) {
            case 1:
                return new int[] { 500, 1500 };
            case 2:
                return new int[] { 400, 1300 };
            case 3:
                return new int[] { 300, 1100 };
            case 4:
                return new int[] { 300, 900 };
            case 5:
                return new int[] { 200, 800 };
            default:
                return new int[] { 200, 700 };
        }
    }

    // private int randomY(Material obstacle) {
    // int result = (int) (getGame().getGround().y - obstacle.getHeight());
    // int rand = getRandom().nextInt((int) (getGame().getPlayer().getHeight() *
    // 1.5));
    // return result - rand + 10;
    // }

}
