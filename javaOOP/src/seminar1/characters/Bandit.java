package seminar1.characters;

import java.util.ArrayList;

public class Bandit extends Character {
    protected int strength;
    protected int agility;
    protected int stamina;
    public Bandit(String name, int x, int y) {
        super(name, x, y);
        this.priority = 2;
        this.health = 60;
        this.protection = 25;
        this.strength = 6;
        this.agility = 6;
        this.stamina = 40;
        this.id = Character.getCount();
    }
    @Override
    protected int dealDamage(int damage, Character target) {
        if (this.stamina < 0 || (this.stamina -= this.strength / 2) < 0) {
            System.out.printf("Игроку %s не хватает ресурсов нанести удар", this.name);
        } else {
            this.stamina -= this.strength / 2;
            setStamina(this.stamina);
            if (target.getProtection() > 0) {
                target.protection -= damage * this.strength;
                target.setProtection(target.protection);
                target.health -= (damage * this.agility) / 2;
                target.setHealth(target.health);
                return (damage * this.agility) / 2;
            } else {
                target.health -= damage * this.strength;
                target.setHealth(target.health);
                return damage * this.strength;
            }
        }
        return 0;
    }
    @Override
    public void Attack(Character target) {super.Attack(target);}
    @Override
    public String toInfo() {
        return String.format(" %s Strength = %d; Agility = %d; Stamina = %d", super.toInfo(), strength, agility, stamina);
    }
    @Override
    public String toString() {return super.toString();}
    public int getStrength() {return strength;}
    public int getAgility() {return agility;}
    public int getStamina() {return stamina;}
    protected void setStrength(int strength) {this.strength = strength;}
    protected void setAgility(int agility) {this.agility = agility;}
    protected void setStamina(int stamina) {this.stamina = stamina;}

    @Override
    public void step(ArrayList<Character> targetTeam) {

    }
}
