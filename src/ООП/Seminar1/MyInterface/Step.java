package ООП.Seminar1.MyInterface;

import java.util.ArrayList;

import ООП.Seminar1.Units.BaseCharacter;

public interface Step {

    public void step(ArrayList<BaseCharacter> targets, ArrayList<BaseCharacter> friends);
}