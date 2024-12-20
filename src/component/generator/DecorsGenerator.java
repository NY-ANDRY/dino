package component.generator;

import java.awt.event.ActionEvent;

import component.game.GameTimer;
import component.structure.Decors;
import component.structure.Material;
import component.structure.Obstacle;

public class DecorsGenerator extends Generator {

    public DecorsGenerator(GameTimer game) {
        super(game);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        getGame().getObstacles().add(getObstacle());

        getGameTimer().getTimerDecors().setDelay(randomDelai(200, 400));
    }

    private int randomY(Material obstacle) {
        int result = (int) (getGame().getGround().y + getRandom().nextInt(30));
        return result;
    }

    @Override
    public Obstacle getObstacle() {
        Obstacle obstacle = new Decors();
        obstacle.x = getGame().getFenetre().getWidth();
        obstacle.y = randomY(obstacle);
        return obstacle;
    }

}
