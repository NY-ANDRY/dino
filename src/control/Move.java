package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import component.game.Game;

public class Move implements KeyListener {

    // private Fenetre f;
    private Game game;

    public Move() {
    }

    // public Move(Fenetre f) {
    // this.f = f;
    // game = f.getGame();
    // }

    public Move(Game g) {
        game = g;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // if (e.getKeyChar() == 'w') {
        // game.getPlayer().jump();
        // }
        // if (e.getKeyChar() == 's') {
        // game.getPlayer().down();
        // }
        if (e.getKeyChar() == 'r') {
            game.begin();
        }
        if (e.getKeyChar() == 'e') {
            game.getPlayer().fire(game);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            game.getPlayer().jump();
        }
        if (e.getKeyChar() == 's') {
            game.getPlayer().down();
        }
        /// avant - arriere
        // if (e.getKeyChar() == 'a') {
        // game.getPlayer().setLeft(true);
        // }
        // if (e.getKeyChar() == 'd') {
        // game.getPlayer().setRight(true);
        // }
        //
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 's') {
            game.getPlayer().up();
        }

        /// avant - arriere
        // if (e.getKeyChar() == 'a') {
        // game.getPlayer().setLeft(false);
        // }
        // if (e.getKeyChar() == 'd') {
        // game.getPlayer().setRight(false);
        // }
        //
    }
}