package ООП.Seminar1.Units.Shooters;


import java.util.ArrayList;

import ООП.Seminar1.Units.BaseCharacter;
import ООП.Seminar1.Units.Peasant;

abstract public class Shooters extends BaseCharacter {
    protected int arrows;
    protected int maxArrows;

    public Shooters(String name, int x, int y) {
        super(name, x, y);
        this.speed = 3;
    }

    public Shooters() {
    }

    public int getArrows() {return arrows;}

    public void setArrows(int arrows) {this.arrows = arrows;}

    public void attac(BaseCharacter target){
        int damage = r.nextInt(5, 15);
        target.GetDamage(damage);
    }

    @Override
    public String toString() {return name +  ", Hp: " + health + ", St: " + strength + ", Arrows: " + arrows;}

    public void step(ArrayList<BaseCharacter> targets, ArrayList<BaseCharacter> friends) {

        if (getHealth() <= 0 || getArrows() <= 0) return;
        attac(nearestEnemy(targets));
        //System.out.printf("%s %s %s %s\n", name, getClass().getSimpleName(), "Стреляю в", nearestEnemy(targets).getName());
        if (getArrows() < maxArrows){

            for (BaseCharacter unit : friends) {
                if (unit.getInfo().equals("Фермер") && !((Peasant)unit).flag) {
                    ((Peasant)unit).flag = true;
                    arrows++;
                    return;
                }
            }
        }
        arrows--;
    }



}