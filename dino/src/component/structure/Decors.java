package component.structure;

import java.awt.Color;

import component.bonus.Bonus;
import component.character.Alive;

public class Decors extends Bonus {

    public Decors() {
        super(false);
        width = 10;
        height = 1;
        setColor(new Color(20, 20, 20));
        setSpeed(5);
        setActive(false);
    }

    @Override
    public void effect(Alive valid) {
    }

    @Override
    public void effect(Material obstacle) {
    }

}
