package seminar1;

import com.sun.source.tree.IfTree;
import seminar1.characters.*;
import seminar1.characters.Character;
import seminar1.characters.forClientCode.FillTeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
/*    public static ArrayList<Character> team1 = new ArrayList<>();
    public static ArrayList<Character> team2 = new ArrayList<>();
     FillTeam.FillTeamRandomChar(team1, team2);
    */ // То что я хотел бы реализовать
    public static void main(String[] args) {
        ArrayList<Character> team1 = new ArrayList<>();
        ArrayList<Character> team2 = new ArrayList<>();
        FillTeam.FillTeamRandomChar(team1, team2);
        for (Character character : team1) {
            System.out.println(character.toInfo());
        }
        System.out.println();
        for (Character character : team2) {
            System.out.println(character.toInfo());
        }
        System.out.println("-".repeat(16));

        ArrayList<Character> all = new ArrayList<>(); /* Объединение команд и создание сортировщика */
        all.addAll(team1);
        all.addAll(team2);

        all.sort((o1, o2) -> o2.getPriority()- o1.getPriority());

        all.forEach(n->System.out.println(n.toInfo()));


    }

}
