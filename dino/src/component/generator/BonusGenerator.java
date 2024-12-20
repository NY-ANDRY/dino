package component.generator;

import java.awt.event.ActionEvent;

import component.bonus.Bonus;
import component.bonus.Heal;
import component.game.GameTimer;
import component.structure.Obstacle;

public class BonusGenerator extends Generator {

    public BonusGenerator(GameTimer game) {
        super(game);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getGame().getObstacles().add(getObstacle());
        getGameTimer().getTimerBullet().setDelay(randomDelai(2000, 5000));
    }

    @Override
    public Obstacle getObstacle() {
        int rand = getRandom().nextInt(10);
        Bonus obstacle = new Bonus(false);
        if (rand < 5) {
            obstacle = new Heal(false);
        }
        int dmg = getRandom().nextInt(10);
        dmg++;
        obstacle.setDmg(dmg * 10);

        obstacle.x = getGame().getFenetre().getWidth();
        obstacle.y = obstacle.randomY(getGame().getGround());
        return obstacle;
    }

}
