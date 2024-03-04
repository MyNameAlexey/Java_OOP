package ООП.Seminar1.Core;

import java.util.ArrayList;

import ООП.Seminar1.Units.BaseCharacter;
import ООП.Seminar1.Units.Model;

import java.util.Scanner;

public class Presenter {
    View v;
    Model m1;
    Model m2;
    Model m3;
    Model m4;
    Model m5;
    Model m6;
    Model m7;
    ArrayList<BaseCharacter> holyTeam;
    ArrayList<BaseCharacter> darkTeam;
    ArrayList<BaseCharacter> allTeam;


    public Presenter(View view, Model model1,Model model2, Model model3, Model model4,
                     Model model5, Model model6, Model model7, ArrayList<BaseCharacter> holyTeam,
                     ArrayList<BaseCharacter> darkTeam, ArrayList<BaseCharacter> allTeam) {
        this.v = view;
        this.m1 = model1;
        this.m1 = model2;
        this.m1 = model3;
        this.m1 = model4;
        this.m1 = model5;
        this.m1 = model6;
        this.m1 = model7;
        this.holyTeam = holyTeam;
        this.darkTeam = darkTeam;
        this.allTeam = allTeam;
    }

    public void startGame (){


        System.out.println("Команда №1: ");
        for (BaseCharacter unit : holyTeam) {
            System.out.printf("Имя: %s, Класс: %s, Здоровье: %d, Координаты: %d,%d\n", unit.getName(),
                    unit.getClass().getSimpleName(), unit.getHealth(), unit.position.getX(), unit.position.getY());
        }
        System.out.println();

        System.out.println("Команда №2: ");
        for (BaseCharacter unit : darkTeam) {
            System.out.printf("Имя: %s, Класс: %s, Здоровье: %d, Координаты: %d,%d\n", unit.getName(),
                    unit.getClass().getSimpleName(), unit.getHealth(), unit.position.getX(), unit.position.getY());
        }
        System.out.println();

        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);
        allTeam.sort((o1, o2) -> o2.getSpeed() - o1.getSpeed());

        System.out.println("-".repeat(56));

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (true) {

            View.view();
            scanner.nextLine();
            int summ1HP = 0;
            int summ2HP = 0;
            for (BaseCharacter unit : holyTeam){
                summ1HP += unit.getHealth();
            }
            System.out.println(summ1HP);
            for (BaseCharacter unit : darkTeam){
                summ2HP += unit.getHealth();
            }
            System.out.println(summ2HP);
            if (summ1HP == 0){
                System.out.println("Победила команда darkTeam");
                flag = false;
                break;
            }
            if (summ2HP == 0){
                System.out.println("Победила команда holyTeam");
                flag = false;
                break;
            }
            for (BaseCharacter unit : allTeam) {
                if (holyTeam.contains(unit)) unit.step(darkTeam, holyTeam);
                else unit.step(holyTeam, darkTeam);
            }
        }
    }


}