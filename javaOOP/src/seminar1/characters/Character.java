package seminar1.characters;

import seminar1.characters.interfaces.ActionsOfChar;
import seminar1.characters.interfaces.Step;

import java.util.ArrayList;
import java.util.Random;

/*Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).
Создать абстрактный класс и иерархию наследников. Расположить классы в пакет так, чтобы в основной программе небыло видно их полей.
В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя.
Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.

Формат сдачи:*/
abstract public class Character implements ActionsOfChar, Step {
    private static int count;
    protected String name;
    protected int health;
    protected int protection;
    protected Place position;
    protected int id;
    protected int priority;

    static {count =0;}
    private static Random rnd = new Random();


    public Character(String name, int x, int y) {
        count++;
        this.priority =0;
        this.position = new Place(x,y);
        this.name = name;
        this.health = 1;
        this.protection = 1;
    }

    public int findNearestEnemy(ArrayList<Character> targetTeam){
        double minDistanse = Double.MAX_VALUE;
        int id = -1;
        for (Character character : targetTeam) {
            if (Place.findDistance(Character.this.getPosition().getX(), Character.this.getPosition().getY(),
                    character.getPosition().getX(),character.getPosition().getY()) < minDistanse){
                minDistanse = Place.findDistance(Character.this.getPosition().getX(), Character.this.getPosition().getY(),
                        character.getPosition().getX(),character.getPosition().getY());
                id = character.getId();
            }
        }
        return id;
    }
    public String toInfo() {
        return String.format("Type = %s; ID = %d; Name = %s; %s; Health = %d; Protection = %d",
                this.getClass().getSimpleName(),id, name, position.toString(),health, protection);
    }
    @Override
    public String toString() {return String.format("Type = %s; Name = %s", this.getClass().getSimpleName(), name);}
    public boolean heroIsDead(Character target) {
        if (target.getHealth() <= 0) {
            System.out.printf("%s dead.", target.getName());
            return false;
        } else System.out.printf("%s is life left %d, protection left %d\n",target.getName(), target.getHealth(),
                target.getProtection());
        return true;
    }

    protected int dealDamage(int damage, Character target) {
        if (target.protection>0){
            target.protection -= damage*2;
            if (target.protection <= 0){
                target.health -= damage+10;
                setHealth(target.health);
                return damage+10;
            }
            setProtection(target.protection);
            target.health -= damage/2;
            setHealth(target.health);
            return damage/2;
        }else {
            target.health -= damage+10;
            setHealth(target.health);
            return damage+10;
        }

    }
    public void Attack(Character target) {
        int damage = Character.rnd.nextInt(2, 4);
        System.out.printf("%s caused damage %d to %s!\n",this.getName(),Character.this.dealDamage(damage, target), target.getName());
        heroIsDead(target);

    }

    public void setName(String name) {this.name = name;}

    public void setHealth(int health) {this.health = health;}

    public void setProtection(int protection) {this.protection = protection;}

    public String getName() {return name;}

    public int getHealth() {return health;}

    public int getProtection() {return protection;}

    public int getId() {return id;}

    public Place getPosition() {return position;}

    public static int getCount(){return count;}
    public int getPriority() {return priority;}



}
