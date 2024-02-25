package seminar1.characters.forClientCode;

import seminar1.characters.*;
import seminar1.characters.Character;
import seminar1.characters.enums.Names;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class FillTeam {
    public static void FillTeamRandomChar(ArrayList<Character> team1, ArrayList<Character> team2) {
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            switch (rnd.nextInt(0, 7)) {
                case 0:
                    team1.add(new Peasant(getName(), i, 0));
                    break;
                case 1:
                    team1.add(new Bandit(getName(), i, 0));
                    break;
                case 2:
                    team1.add(new Crossbowman(getName(), i, 0));
                    break;
                case 3:
                    team1.add(new Magician(getName(), i, 0));
                    break;
                case 4:
                    team1.add(new Monk(getName(), i, 0));
                    break;
                case 5:
                    team1.add(new Sniper(getName(), i, 0));
                    break;
                case 6:
                    team1.add(new Spearman(getName(), i, 0));
                    break;
            }

        }
        for (int i = 0; i < 10; i++) {
            switch (rnd.nextInt(0, 7)) {
                case 0:
                    team2.add(new Peasant(getName(), i, 9));
                    break;
                case 1:
                    team2.add(new Bandit(getName(), i, 9));
                    break;
                case 2:
                    team2.add(new Crossbowman(getName(), i, 9));
                    break;
                case 3:
                    team2.add(new Magician(getName(), i, 9));
                    break;
                case 4:
                    team2.add(new Monk(getName(), i, 9));
                    break;
                case 5:
                    team2.add(new Sniper(getName(), i, 9));
                    break;
                case 6:
                    team2.add(new Spearman(getName(), i, 9));
                    break;
            }

        }

    }

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }
}
