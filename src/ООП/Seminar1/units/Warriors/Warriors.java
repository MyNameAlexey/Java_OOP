package ООП.Seminar1.Units.Warriors;

import java.util.ArrayList;

import ООП.Seminar1.MyInterface.Position;
import ООП.Seminar1.Units.BaseCharacter;

public abstract class Warriors extends BaseCharacter {
    protected int anger;
    protected Position position;

    public Warriors(String name, Integer x, Integer y) {
        super(name, x, y);
        this.anger = 30;
        this.speed = 2;
        this.position = new Position(x, y);
    }

    public Warriors() {
    }

    public void setAnger(int anger) {this.anger = anger;}

    public int getAnger() {return anger;}

    public void attac(BaseCharacter target){
        int damage = r.nextInt(5, 15);
        anger--;
        target.GetDamage(damage);
    }

    public void step(ArrayList<BaseCharacter> targets, ArrayList<BaseCharacter> friends) {

        if (getHealth() < 0) return;
        BaseCharacter unit = nearestEnemy(targets);
        if (position.getDistanse(unit.position) < 2 && getAnger() > 0) {
            attac(unit);
            return;
        }
        Position diff = this.position.getDiff(unit.position);
        Position currentPos = new Position(position.getX(), position.getY());
        if (Math.abs(diff.getX()) <  Math.abs(diff.getY())){
            position.setX(position.getX() + (diff.getX() < 0 ? 1 : -1));
        } else position.setY(position.getY() + (diff.getY() < 0 ? 1 : -1));
        boolean flag = false;
        for (BaseCharacter n : friends) {
            if (n.position.equals(position) && n.getHealth() > 0) {
                flag = true;
                break;
            }
        }
        if (flag) position = currentPos;


    }

    @Override
    public String toString() {return name +  ", Hp: " + health + ", St: " + strength + ", Anger: " + anger;}

}