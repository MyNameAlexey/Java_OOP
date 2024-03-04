package ООП.Seminar1.Units.Warriors;


public class Raider extends Warriors {
    protected int fortune;

    public Raider() {
    }

    public Raider(String name, Integer x, Integer y) {
        super(name, x, y);
    }

    @Override
    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Загубили пацана...");
        }
    }

    public String getInfo() {
        return "Разбойник";
    }


}