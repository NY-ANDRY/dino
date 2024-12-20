package aff;

import javax.swing.*;

import component.game.Game;
import control.*;

import java.awt.*;

public class Fenetre extends JFrame {

	Dimension dimension = new Dimension(1280, 720);

	int top = 0;

	Game game;

	double point;
	JLabel score = new JLabel();

	public Fenetre() throws Exception {

		this.setBackground(new Color(255, 255, 255));

		int w = (int) dimension.getWidth();
		int h = (int) dimension.getHeight();

		setTitle("Dino");
		setSize(w, h);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		game = new Game(this);
		add(game);

		setFocusable(true);
		// addKeyListener(new Move(this));
		addKeyListener(new Move(game));

		setVisible(true);
	}

	public void update() {

		revalidate();
		repaint();
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public JLabel getScore() {
		return score;
	}

	public void setScore(JLabel score) {
		this.score = score;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}