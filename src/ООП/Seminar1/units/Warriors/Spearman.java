package ООП.Seminar1.Units.Warriors;

public class Spearman extends Warriors{
    protected int resistance;

    public Spearman() {
    }

    public Spearman(String name, Integer x, Integer y) {
        super(name, x, y);
    }

    @Override
    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Моё копье сломано... Я пал...");
        }
    }

    public String getInfo() {
        return "Копейщик";
    }


}