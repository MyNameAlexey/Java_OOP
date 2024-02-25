package seminar1.characters;

public class Place {

    protected int x;
    protected int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected static double findDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public String toString() {
        return String.format("Position = (%d,%d)",x,y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
