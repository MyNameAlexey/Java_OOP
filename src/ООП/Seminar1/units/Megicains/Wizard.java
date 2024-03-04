package ООП.Seminar1.units.Megicains;

public class Wizard extends Wizzards {

    public Wizard(String name, Integer x, Integer y) {
        super(name, x, y);
    }

    public Wizard() {
    }

    public String getInfo() {
        return "Волшебник";
    }

    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Бегите, глупцы!..");
        }
    }




}