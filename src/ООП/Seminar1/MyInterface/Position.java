package ООП.Seminar1.MyInterface;

import java.util.ArrayList;
import java.util.List;

import ООП.Seminar1.Units.BaseCharacter;

public class Position {
    protected int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Integer> getPosition (){
        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        return list;
    }

    public int getX() {return x;}

    public int getY() {return y;}

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param position - координаты персонажа
     * @return - Возвращает расстояние до цели
     */

    public double getDistanse (Position target) {
        double targetDistanse = Math.sqrt(Math.pow(target.x - x, 2)) + (Math.pow(target.y - y, 2));
        return targetDistanse;
    }

    public Position getDiff (Position targetPos) {
        Position diff = new Position(x - targetPos.x, y - targetPos.y);
        return diff;
    }

    public boolean equals(Position target) {
        return x == target.x && y == target.y;
    }

}