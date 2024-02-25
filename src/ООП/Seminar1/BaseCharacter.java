package ООП.Seminar1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;


public abstract class BaseCharacter implements Step{

    protected static Random r;

    protected int level;
    protected String name;
    protected int health;
    protected int strength;
    protected int agility;
    protected int stamina;
    protected Boolean status;
    protected int maxHealth;
    protected int speed;



    protected Position position;

    public List<BaseCharacter> units;

    static {BaseCharacter.r = new Random();    }

    public BaseCharacter(String name, Integer x, Integer y) {
        this.level = 1;
        this.name = name;
        this.health = 50;
        this.strength = 30;
        this.agility = 20;
        this.stamina = 30;
        this.maxHealth = health;
        this.speed = speed;
        this.status = true;
        this.position = new Position(x, y);
    }

    public String getName(){
        String str = new String(this.name);
        return str;
    }

    public int getSpeed() {return speed;}

    public int getHealth() {return health;}

    public void setHealth(int health) {this.health = health;}

    public int getMaxHealth () {return maxHealth;}

    public int getStamina() {return stamina;}

    public Boolean getStatus() {return status;}

    public void print() {System.out.println("Уровень: " + level + " Имя: " + name);}

    public void GetDamage(int damage) {
        if (this.health - damage > maxHealth) {
            this.health -= damage;
            this.setHealth(this.health);
        } else {
            this.death();
        }
    }

    public void death(){
        if (this.getHealth() < 1) {
            System.out.println("Ваш персонаж мертв");
        }
    }
    /**
     * @return Этот метод сообщает Имя, Уровень здоровья, Координаты и Статус персонажа
     */
    public String getInfo() {
        String resStr = new String(this.getName() + this.getHealth() + this.position.getPosition() + this.getStatus());
        return resStr;
    }

    public BaseCharacter nearestEnemy (List<BaseCharacter> targets) {
        Queue<BaseCharacter> target = new LinkedList<>();
        double minDistance = 10;
        for (BaseCharacter hero : targets) {
            if (position.getDistanse(hero) < minDistance) {
                minDistance = position.getDistanse(hero);
                target.add(hero);
            }
        }
        return target.peek();
    }

    public void getHealing (int heal){
        if (this.health < maxHealth) {
            if (this.health + heal > maxHealth) {
                this.health = maxHealth;
            }else {
                this.health += heal;
            }

        }
    }

    public boolean isDead(){
        if (this.getHealth() <= 0) {
            return false;
        }
        return true;
    }

    public void attac(BaseCharacter target) {    }
}
