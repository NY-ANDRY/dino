package component.game;

import java.awt.event.ActionListener;

import javax.swing.Timer;

import component.generator.BonusGenerator;
import component.generator.DecorsGenerator;
import component.generator.EnemyGenerator;

public class GameTimer {

    private Game game;
    private Timer timerWall;
    private Timer timerBullet;
    private Timer timerDecors;

    public GameTimer(Game game) {
        setGame(game);
    }

    public void initTimer() {
        timerWall = reloadTimer(timerWall, new EnemyGenerator(this), 1000);
        timerBullet = reloadTimer(timerBullet, new BonusGenerator(this), 2000);
        timerDecors = reloadTimer(timerDecors, new DecorsGenerator(this), 200);
    }

    private Timer reloadTimer(Timer timer, ActionListener listner, int firstDelai) {
        if (timer != null) {
            try {
                timer.stop();
            } catch (Exception e) {
            }
        }
        timer = new Timer(firstDelai, listner);
        timer.setRepeats(true);
        timer.start();
        return timer;
    }

    public void stop() {
        getTimerWall().stop();
        getTimerBullet().stop();
        getTimerDecors().stop();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Timer getTimerWall() {
        return timerWall;
    }

    public void setTimerWall(Timer timerWall) {
        this.timerWall = timerWall;
    }

    public Timer getTimerBullet() {
        return timerBullet;
    }

    public void setTimerBullet(Timer timerBullet) {
        this.timerBullet = timerBullet;
    }

    public Timer getTimerDecors() {
        return timerDecors;
    }

    public void setTimerDecors(Timer timerDecors) {
        this.timerDecors = timerDecors;
    }

}
