package ООП.Seminar1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


import ООП.Seminar1.Megicains.Monk;
import ООП.Seminar1.Megicains.Wizard;
import ООП.Seminar1.Shooters.Crossbowman;
import ООП.Seminar1.Shooters.Sniper;
import ООП.Seminar1.Warriors.Raider;
import ООП.Seminar1.Warriors.Spearman;

/*
Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).
Создать абстрактный класс и иерархию наследников.
 */

/*Крестьянин:      Разбойник:              Копейщик:
 - Здоровье        - ID                    - ID
 - Сила            - Имя                   - Имя
 - Ловкость        - Здоровье              - Здоровье
 - Выносливость    - Сила                  - Сила
 - Вид оружия      - Ловкость              - Выносливость
 - Уровень         - Выносливость          - Вид оружия
 - ID              - Вид оружиня           - Защита
 - Имя

 Снайпер           Арбалетчик:             Колдун:             Монах:
 - ID              - ID                    - ID                - ID
 - Имя             - Имя                   - Имя               - Имя
 - Здоровье        - Здоровье              - Здоровье          - Здоровье
 - Сила            - Выносливость          - Интеллект         - Выносливость
 - Ловкость        - Вид оружия            - Выносливость      - Вид оружия
 - Выносливость    - Меткость              - Вид оружия        - Интеллект
 - Вид оружия      - Количество стрел      - Мана              - Вера
 - Меткость        - Скорость стрельбы                         - Чакра
 - Маскировка

 Семинар 3:
 Добавить в файл интерфейса метод void step() это будет основной метод взаимодействыия с объектами.
 Добавить интерфейс в базовый абстрактный класс. Реализовать этот метод во всех классах наследниках.
 Для начала просто заглушкой.

 Доработать классы лучников. Лучник должен во первых проверить жив ли он и есть ли у него стрелы, если нет
 то завершить метод. Есль всё да, то найти ближайшего противника и выстрелить по немы и, соответственно
 потратить одну стрелу. Реализовать весь функционал лучников в методе step().

 Добавить в абстрактный класс int поле инициатива. В классах наследников инициализировать это поле.
 Крестьянин = 0, маги=1, пехота=2, лучники=3. В мэйне сделать так, чтобы сначала делали ход персонажи с наивысшей
 инициативой из обеих команд а с наименьшей в конце.

*/
public class Main {
    public static void main(String[] args) {

        List<BaseCharacter> team1 = new ArrayList<>(teamCreator(0));
        List<BaseCharacter> team2 = new ArrayList<>(teamCreator(9));

        for (BaseCharacter unit : team1) {
            System.out.printf("Имя: %s, Класс: %s, Координаты: %d,%d\n", unit.getName(), unit.getClass().getSimpleName(), unit.position.getX(), unit.position.getY());
        }
        System.out.println();
        for (BaseCharacter unit : team2) {
            System.out.printf("Имя: %s, Класс: %s, Координаты: %d,%d\n", unit.getName(), unit.getClass().getSimpleName(), unit.position.getX(), unit.position.getY());
        }
        System.out.println();

        // Проба метода getInfo
        System.out.println(team1.get(0).getInfo());
        System.out.println("------------------");

        ArrayList<BaseCharacter> all = new ArrayList<>();
        all.addAll(team1);
        all.addAll(team2);

        all.sort((o1, o2) -> o2.getSpeed() - o1.getSpeed());
        for (BaseCharacter unit : all) {
            System.out.println(unit.getInfo());
        }
        // for (BaseCharacter unit : all) {
        //     unit.step(all);
        // }
        System.out.println("-------------------------------------");

        for (BaseCharacter unit : all) {
            System.out.printf("Имя: %s, Здоровье: %d, Класс: %s, Координаты: %d,%d\n", unit.getName(), unit.getHealth(), unit.getClass().getSimpleName(), unit.position.getX(), unit.position.getY());
        }
        System.out.println();

        for (BaseCharacter element : all) {
            if (element instanceof Sniper || element instanceof Crossbowman) {
                element.step(all);
                break;
            }
        }

        for (BaseCharacter unit : all) {
            System.out.printf("Имя: %s, Здоровье: %d, Класс: %s, Координаты: %d,%d\n", unit.getName(), unit.getHealth(), unit.getClass().getSimpleName(), unit.position.getX(), unit.position.getY());
        }
        System.out.println();




    }

    private static String fillName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);
    }

    private static ArrayList<BaseCharacter> teamCreator(int y){
        ArrayList<BaseCharacter> team = new ArrayList<BaseCharacter>();
        int teamCount = 10;
        for (int i = 0; i < teamCount; i++) {
            switch (new Random().nextInt(1, 8)) {
                case 1:
                    team.add(new Monk(fillName(), i, y));
                    break;
                case 2:
                    team.add(new Wizard(fillName(), i, y));
                    break;
                case 3:
                    team.add(new Crossbowman(fillName(), i, y));
                    break;
                case 4:
                    team.add(new Sniper(fillName(), i, y));
                    break;
                case 5:
                    team.add(new Peasant(fillName(), i, y));
                    break;
                case 6:
                    team.add(new Raider(fillName(), i, y));
                    break;
                case 7:
                    team.add(new Spearman(fillName(), i, y));
                    break;
            }
        }
        return team;
    }


}
