package ООП.Seminar1.Warriors;

import ООП.Seminar1.BaseCharacter;

public abstract class Warriors extends BaseCharacter implements WarSkills {
    protected int anger;

    public Warriors(String name, Integer x, Integer y) {
        super(name, x, y);
        this.anger = 30;
        this.speed = 2;
    }

    public void attac(BaseCharacter target){
        int damage = r.nextInt(5, 15);
        this.anger--;
        target.GetDamage(damage);
    }

}