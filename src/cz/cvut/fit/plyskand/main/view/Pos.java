package cz.cvut.fit.plyskand.main.view;

public class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) {
        if(x < 0 || y < 0) throw new IllegalArgumentException("Invalid Position!");
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
