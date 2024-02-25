package seminar1.characters;

import java.util.ArrayList;

public class Monk extends Character {
    protected int faith;
    protected int chakra;
    protected int mana;
    public Monk(String name, int x, int y) {
        super(name, x, y);
        this.priority = 1;
        this.health = 80;
        this.protection = 35;
        this.faith = 4;
        this.chakra = 3;
        this.mana = 80;
        this.id = Character.getCount();
    }
    @Override
    protected int dealDamage(int damage, Character target) {
        if (this.mana < 0 || (this.mana -= this.faith / 2) < 0) {
            System.out.printf("Игроку %s не хватает ресурсов нанести удар", this.name);
        }else {
            this.mana -= this.faith / 2;
            setMana(this.mana);
            if (target.getProtection() > 0) {
                target.protection -= damage * this.faith;
                target.setProtection(target.protection);
                target.health -= (damage * this.chakra) / 2;
                target.setHealth(target.health);
                return (damage * this.chakra) / 2;
            } else {
                target.health -= damage * this.chakra;
                target.setHealth(target.health);
                return damage * this.chakra;
            }
        }
        return 0;
    }
    @Override
    public void Attack(Character target) {super.Attack(target);}
    @Override
    public String toString() {return super.toString();}
    @Override
    public String toInfo() {
        return String.format("%s ; Faith = %d; Chakra = %d; " +
                " Mana = %d;", super.toInfo(), faith,chakra,mana);
    }

    @Override
    public void step(ArrayList<Character> targetTeam) {

    }
    public int getFaith() {return faith;}
    public int getChakra() {return chakra;}
    public int getMana() {return mana;}
    protected void setFaith(int faith) {this.faith = faith;}
    protected void setChakra(int chakra) {this.chakra = chakra;}
    protected void setMana(int mana) {this.mana = mana;}


}
