package ООП.Seminar1.Megicains;

import java.util.ArrayList;
import java.util.List;

import  ООП.Seminar1.BaseCharacter;

public class Monk extends Wizzards {
    protected int faith;

    public Monk(String name, Integer x, Integer y) {
        super(name, x, y);
    }

    @Override
    public String toString() {
        return String.format("Class: %s  Name: %s", this.getClass().getSimpleName(), getName());

    }

    public void toHeal (BaseCharacter target){
        int heal = BaseCharacter.r.nextInt(5, 16);
        while (target.getHealth() < target.getMaxHealth()) {
            target.getHealing(heal);
            faith -= heal / 2;
            if (target.getHealth() == target.getMaxHealth()) {
                break;
            }
        }
    }

    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Да балгослословит Господь врагов моих. Аминь!..");
        }
    }

    public void step(List<BaseCharacter> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'step'");
    }



}
