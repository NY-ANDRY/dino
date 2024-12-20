package component.game;

import java.awt.*;

import javax.swing.*;
import java.util.*;

import aff.*;
import component.character.Alive;
import component.character.Dino;
import component.structure.Ground;
import component.structure.Material;
import component.structure.Obstacle;
import control.Save;

public class Game extends JPanel {

	private Fenetre fenetre;

	private boolean play;
	private int score;

	private ArrayList<Integer> scoreHistory;
	private int best;
	private Save save;

	private Alive player;
	private Ground ground;
	private ArrayList<Obstacle> obstacles;
	private GameTimer gameTimer;

	public Game(Fenetre f) {
		setFenetre(f);
		setSave(new Save("data/dino.csv"));
		setScoreHistory(getSave().getData());
		init();
	}

	private void init() {
		play = true;
		saveScore();
		score = 0;
		Ground ground = new Ground(this);
		ground.setFrame(0, fenetre.getHeight() - 60, fenetre.getWidth(), 100);

		Dino dino = new Dino();
		dino.x = 50;
		dino.y = (ground.y - dino.height);
		dino.setGround(ground);

		setGameTimer(new GameTimer(this));

		setObstacles(new ArrayList<Obstacle>());
		setGround(ground);
		setPlayer(dino);
		getGameTimer().initTimer();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = style(g);

		run();
		fillObstacle(g2);

		player.draw(g2);
		ground.draw(g2);

		writePlayerInfo(g2);
		writeScore(g2);
		writeControl(g2);

		// System.out.println(materials.size());

		sleeep(10);
		repaint();
	}

	private void saveScore() {
		getSave().write(score);
		getScoreHistory().add(score);
		best = best();
	}

	private void checkScore(Material obstacle) {
		if ((obstacle.getX() + obstacle.getWidth()) <= player.getX() && obstacle.isActive()) {
			increaseScore();
			obstacle.setActive(false);
		}
	}

	public void increaseScore() {
		score++;
	}

	private void run() {
		if (play && !player.isDead()) {
			this.player.move();
			for (Material obstacle : obstacles) {
				obstacle.move();
				checkScore(obstacle);
				if (obstacle.intersects(player)) {
					obstacle.effect(player);
				}
				checkCollision(obstacle);
			}
		} else {
			checkGame();
		}
		// lvl();
	}

	private void checkCollision(Material obstacle) {
		for (Material otherObstacle : obstacles) {
			if (obstacle != otherObstacle && obstacle.intersects(otherObstacle)) {
				obstacle.effect(otherObstacle);
			}
		}
	}

	private void checkGame() {
		if (player.isDead()) {
			play = false;
			getGameTimer().stop();
		}
	}

	public int lvl() {
		int result = (int) Math.ceil(((double) getScore()) / 10);
		if (result <= 0) {
			return 1;
		}
		return result;
	}

	private void fillObstacle(Graphics2D g2) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g2);
			if (outOfScreen(obstacles.get(i)) || !obstacles.get(i).isValid()) {
				obstacles.remove(i);
				i--;
			}
		}
	}

	private boolean outOfScreen(Rectangle rect) {
		return rect.x + rect.width <= 0 || rect.x > fenetre.getWidth() + 100;
	}

	private void sleeep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
			System.out.println("can't sleep");
		}
	}

	private Graphics2D style(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setFont(new Font("pixelify sanss", Font.TYPE1_FONT, 26));
		g2.setColor(new Color(100, 100, 100));
		return g2;
	}

	private void writePlayerInfo(Graphics2D g2) {
		g2.drawString(String.format("%02d", player.getLife()), 20, 40);
		g2.drawString(String.format("%02d", player.getEnergy()), 20, 70);
	}

	private void writeScore(Graphics2D g2) {
		g2.drawString(String.format("%05d", getScore()), getFenetre().getWidth() - 96, 40);
		g2.setFont(new Font("pixelify sanss", Font.TYPE1_FONT, 16));
		g2.setColor(new Color(80, 80, 80));
		g2.drawString(String.format("%05d", getBest()), getFenetre().getWidth() - 68, 80);
	}

	private void writeControl(Graphics2D g2) {
		g2.setFont(new Font("pixelify sanss", Font.TYPE1_FONT, 16));
		g2.setColor(new Color(80, 80, 80));
		g2.drawString("sauter : w", 20, 100);
		g2.drawString("accroupi : s", 20, 120);
		g2.drawString("tirer : e", 20, 140);
		g2.drawString("* recommencer : r", 20, 160);
	}

	public void begin() {
		if (!play) {
			init();
		}
	}

	private int best() {
		int result = 0;
		for (Integer history : scoreHistory) {
			if (history > result) {
				result = history;
			}
		}
		return result;
	}

	public Fenetre getFenetre() {
		return fenetre;
	}

	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public Alive getPlayer() {
		return player;
	}

	public void setPlayer(Alive player) {
		this.player = player;
	}

	public Ground getGround() {
		return ground;
	}

	public void setGround(Ground ground) {
		this.ground = ground;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArrayList<Integer> getScoreHistory() {
		return scoreHistory;
	}

	public void setScoreHistory(ArrayList<Integer> scoreHistory) {
		this.scoreHistory = scoreHistory;
	}

	public int getBest() {
		return best;
	}

	public void setBest(int best) {
		this.best = best;
	}

	public GameTimer getGameTimer() {
		return gameTimer;
	}

	public void setGameTimer(GameTimer gameTimer) {
		this.gameTimer = gameTimer;
	}

	public Save getSave() {
		return save;
	}

	public void setSave(Save save) {
		this.save = save;
	}

}