package component.structure;

import java.awt.Color;
import java.awt.Graphics2D;

import component.character.Alive;
import component.game.Game;

public class Ground extends Material {

    private Game game;

    public Ground(Game game) {
        super();
        setGame(game);
        height = 10;
        width = game.getWidth();
    }

    public void draw(Graphics2D g2) {
        g2.setColor(new Color(24, 24, 24));
        g2.draw(this);
    }

    public void move() {
    }

    @Override
    public void effect(Alive vivant) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'effect'");
    }

    @Override
    public void effect(Material obstacle) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'effect'");
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
