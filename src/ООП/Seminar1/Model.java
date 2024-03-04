package ООП.Seminar1.Units;

import java.util.ArrayList;

public interface Model {

    String getName();

    int getSpeed();

    int getHealth();

    int getMaxHealth();

    int getStamina();

    String toString();

    String getInfo();

    BaseCharacter nearestEnemy (ArrayList<BaseCharacter> targets);

    void step(ArrayList<BaseCharacter> targets, ArrayList<BaseCharacter> friends);

}