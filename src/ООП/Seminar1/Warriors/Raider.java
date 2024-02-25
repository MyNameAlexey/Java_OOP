package ООП.Seminar1.Warriors;

import java.util.ArrayList;
import java.util.List;

import ООП.Seminar1.BaseCharacter;

public class Raider extends Warriors {
    protected int fortune;

    public Raider(String name, Integer x, Integer y) {
        super(name, x, y);
    }

    @Override
    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Загубили пацана...");
        }
    }

    @Override
    public String toString() {
        return String.format("Class: %s  Name: %s", this.getClass().getSimpleName(), getName());

    }

    public void step(List<BaseCharacter> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'step'");
    }

}
