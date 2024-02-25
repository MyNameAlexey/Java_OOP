package ООП.Seminar1.Megicains;

import ООП.Seminar1.BaseCharacter;

abstract public class Wizzards extends BaseCharacter implements MagicAttac {

    public Wizzards(String name, Integer x, Integer y) {
        super(name, x, y);
        this.speed = 1;
    }

    public int getSpeed() {
        return speed;
    }

    public void attac(BaseCharacter target){
        int damage = r.nextInt(5, 15);
        target.GetDamage(damage);
    }
}
