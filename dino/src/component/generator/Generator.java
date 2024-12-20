package component.generator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import component.game.Game;
import component.game.GameTimer;
import component.structure.Material;

public abstract class Generator implements ActionListener {

    private GameTimer gameTimer;
    private static Random random;

    public Generator(GameTimer gameTimer) {
        this.gameTimer = gameTimer;
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);

    protected int randomDelai(int debut, int fin) {
        int result = random.nextInt(fin - debut) + debut;
        // System.out.println(result);
        return result;
    }

    public abstract Material getObstacle();

    public Game getGame() {
        return this.getGameTimer().getGame();
    }

    public GameTimer getGameTimer() {
        return gameTimer;
    }

    public void setGameTimer(GameTimer gameTimer) {
        this.gameTimer = gameTimer;
    }

    public Random getRandom() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }

    public static void setRandom(Random random) {
        Generator.random = random;
    }

}
