package ООП.Seminar1.Units.Shooters;

public class Crossbowman extends Shooters{

    public Crossbowman(String name, Integer x, Integer y) {
        super(name, x, y);
        this.maxArrows = arrows = 50;
    }

    public Crossbowman (){

    }

    public String getInfo() {
        return "Арбалетчик";
    }

    @Override
    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Мой арбалет больше никого не прикроет, прощай...");
        }
    }






}