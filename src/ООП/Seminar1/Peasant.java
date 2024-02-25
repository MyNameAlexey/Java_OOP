package ООП.Seminar1;

import java.util.ArrayList;
import java.util.List;

public class Peasant extends BaseCharacter {
    int unity;

    public Peasant(String name, Integer x, Integer y) {
        super(name, x, y);
        this.speed = 0;
    }

    public void work(int hour) {
        stamina -= hour / 4;
    }

    @Override
    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Моя служба окончена, Господин...");
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
