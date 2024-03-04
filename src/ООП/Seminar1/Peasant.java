package ООП.Seminar1.Units;

import java.util.ArrayList;

public class Peasant extends BaseCharacter {
    int arrow;
    public boolean flag;

    public Peasant() {
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public int getArrow() {
        return arrow;
    }

    public Peasant(String name, int x, int y) {
        super(name, x, y);
        this.speed = 0;
        this.arrow = 5;
        this.flag = false;
    }

    public String getInfo() {
        return "Фермер";
    }

    @Override
    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Моя служба окончена, Господин...");
        }
    }



    public void step(ArrayList<BaseCharacter> targets, ArrayList<BaseCharacter> friends) {

        if (getHealth() <= 0) return;
        flag = false;

    }


}