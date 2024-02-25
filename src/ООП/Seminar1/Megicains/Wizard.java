package ООП.Seminar1.Megicains;

import java.util.ArrayList;
import java.util.List;

import  ООП.Seminar1.BaseCharacter;

public class Wizard extends Wizzards implements MagicAttac {
    protected int mana;

    public Wizard(String name, Integer x, Integer y) {
        super(name, x, y);
    }

    @Override
    public String toString() {
        return String.format("Class: %s  Name: %s", this.getClass().getSimpleName(), getName());

    }

    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Бегите, глупцы!..");
        }
    }

    public void step(List<BaseCharacter> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'step'");
    }



}