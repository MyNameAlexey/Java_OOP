package seminar1.characters;

import java.util.ArrayList;

public class Magician extends Character {
    protected int intelligence;
    protected int mana;
    protected int spellAmplification;
    public Magician(String name, int x, int y) {
        super(name, x, y);
        this.priority = 1;
        this.health = 60;
        this.protection = 20;
        this.intelligence = 5;
        this.spellAmplification = 3;
        this.mana = 50;
        this.id = Character.getCount();
    }
    @Override
    protected int dealDamage(int damage, Character target) {
        if (this.mana < 0 || (this.mana -= this.intelligence / 2) < 0) {
            System.out.printf("Игроку %s не хватает ресурсов нанести удар", this.name);
        }else {
            this.mana -= this.intelligence / 2;
            setMana(this.mana);
            if (target.getProtection() > 0) {
                target.protection -= damage * this.intelligence;
                target.setProtection(target.protection);
                target.health -= (damage * this.spellAmplification) / 2;
                target.setHealth(target.health);
                return (damage * this.spellAmplification) / 2;
            } else {
                target.health -= damage * this.spellAmplification;
                target.setHealth(target.health);
                return damage * this.spellAmplification;
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
        return String.format("%s ; Intelligence = %d; SpellAmplification = %d; " +
                "Mana = %d;", super.toInfo(), intelligence, spellAmplification, mana);
    }

    @Override
    public void step(ArrayList<Character> targetTeam) {

    }
    public int getIntelligence() {return intelligence;}
    public int getMana() {return mana;}
    public int getSpellAmplification() {return spellAmplification;}
    protected void setIntelligence(int intelligence) {this.intelligence = intelligence;}
    protected void setMana(int mana) {this.mana = mana;}
    protected void setSpellAmplification(int spellAmplification) {this.spellAmplification = spellAmplification;}


}

