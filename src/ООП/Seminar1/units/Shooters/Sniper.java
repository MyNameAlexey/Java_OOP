package ООП.Seminar1.Units.Shooters;

public class Sniper extends Shooters{

    public Sniper(String name, Integer x, Integer y) {
        super(name, x, y);
        this.maxArrows = arrows = 50;
    }

    public Sniper() {
    }

    public String getInfo() {
        return "Снайпер";
    }

    @Override
    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Неточность - вежливость снайперов и это моя последняя...");
        }
    }



}