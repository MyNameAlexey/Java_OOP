package ООП.Seminar1;

import java.util.ArrayList;
import java.util.Random;

import ООП.Seminar1.Core.View;
import ООП.Seminar1.MyInterface.Names;
import ООП.Seminar1.Units.BaseCharacter;
import ООП.Seminar1.Units.Peasant;
import ООП.Seminar1.Units.Megicains.Monk;
import ООП.Seminar1.Units.Megicains.Wizard;
import ООП.Seminar1.Units.Shooters.Crossbowman;
import ООП.Seminar1.Units.Shooters.Sniper;
import ООП.Seminar1.Units.Warriors.Raider;
import ООП.Seminar1.Units.Warriors.Spearman;
import ООП.Seminar1.Core.Presenter;

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

 Семинар 4:
 Реализовать метод step() пехоты. Первое проверяем живы ли мы, потом ищем ближайшего противника. Если противник в
 соседней клетке, наносим повреждение. Иначе двигаемся в сторну противника. Алгоритм движения, если dX>dY двигаемся
 по x иначе по y. dX и dY (разница наших координат и ближайшего противника) знаковые, от знака зависит направление.
 По своим не ходить!

*/
public class Main {
    public static ArrayList<BaseCharacter> holyTeam = new ArrayList<BaseCharacter>(teamCreator(1));
    public static ArrayList<BaseCharacter> darkTeam = new ArrayList<BaseCharacter>(teamCreator(10));
    public static ArrayList<BaseCharacter> allTeam = new ArrayList<BaseCharacter>();

    public static void main(String[] args) {

        Presenter myPresenter = new Presenter(new View(), new Crossbowman(), new Sniper(),
                new Raider(), new Spearman(), new Peasant(),
                new Monk(), new Wizard(), holyTeam, darkTeam, allTeam);

        myPresenter.startGame();


    }
    private static String fillName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }

    private static ArrayList<BaseCharacter> teamCreator(int y) {
        ArrayList<BaseCharacter> team = new ArrayList<BaseCharacter>();
        int teamCount = 10;
        for (int i = 1; i < teamCount+1; i++) {
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