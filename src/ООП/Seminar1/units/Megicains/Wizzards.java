package ООП.Seminar1.units.Megicains;

import java.util.ArrayList;

import ООП.Seminar1.Units.BaseCharacter;

public abstract class Wizzards extends BaseCharacter {
    protected int mana;
    protected int maxMana;
    protected boolean flag;

    public Wizzards() {
    }

    public Wizzards(String name, int x, int y) {
        super(name, x, y);
        speed = 1;
        maxMana = mana = 5;
        flag = false;
    }

    public int getSpeed() {
        return speed;
    }

    public void attac(BaseCharacter target) {
        int damage = r.nextInt(5, 15);
        target.GetDamage(-damage);
    }

    public void step(ArrayList<BaseCharacter> targets, ArrayList<BaseCharacter> friends) {
        if (getHealth() <= 0)
            return;
        ArrayList<BaseCharacter> list = new ArrayList<BaseCharacter>(friends);
        ArrayList<BaseCharacter> listOfDeads = new ArrayList<BaseCharacter>();
        int count = 0;
        list.sort((u1, u2) -> u1.getHealth() - u2.getHealth());

        for (BaseCharacter unit : list) {
            if (unit.isDead()) {
                listOfDeads.add(unit);
                count++;
            }
        }
        if (count > 3) {
            flag = true;
            //System.out.println("Флаг устанволен!");
        }
        if (flag && mana == maxMana) {
            listOfDeads.sort((u1, u2) -> u2.getSpeed() - u1.getSpeed());
            list.getFirst().setHealth(maxHealth/2);
            mana = 0;
            flag = false;
            //System.out.printf("%s %s %s %s\n", name, getClass().getSimpleName(), "Воскресил", list.getFirst().getName());
            return;
        }

        if (flag) {
            mana++;
            //System.out.printf("%s %s %s\n", name, getClass().getSimpleName(), "Жду ману...");
            return;
        }
        if (mana < 2) {
            mana++;
            //System.out.printf("%s %s %s\n", name, getClass().getSimpleName(), "Жду ману...");
            return;
        }
        attac(list.getFirst());
        //System.out.printf("%s %s %s %s\n", name, getClass().getSimpleName(), "Лечу", list.getFirst().getName());
        mana -= 2;

    }

    @Override
    public String toString() {return name +  ", Hp: " + health + ", St: " + strength + ", Mana: " + mana;}


}