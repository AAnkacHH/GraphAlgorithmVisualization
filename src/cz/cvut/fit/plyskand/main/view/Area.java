package cz.cvut.fit.plyskand.main.view;

import cz.cvut.fit.plyskand.main.signs.ConsoleSigns;

import java.util.ArrayList;
import java.util.List;

public class Area {

    private char[][] area;

    private int height;

    private int width;

    public Area(char[][] area, int height, int width) {
        this.area = area;
        this.height = height;
        this.width = width;
    }

    public char[][] getArea() {
        return area;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setChar(Pos pos, char ch) {
        this.area[pos.x][pos.y] = ch;
    }

    public List<Pos> getNeighborsPositions(Pos pos) {
        List<Pos> positions = new ArrayList<>();
        Pos left = new Pos(pos.x - 1, pos.y);
        Pos right = new Pos(pos.x + 1, pos.y);
        Pos top = new Pos(pos.x, pos.y - 1);
        Pos bottom = new Pos(pos.x, pos.y + 1);

        addPosNeighborIfItFresh(left, positions);
        addPosNeighborIfItFresh(right, positions);
        addPosNeighborIfItFresh(top, positions);
        addPosNeighborIfItFresh(bottom, positions);
        return positions;
    }

    public Boolean isValid(Pos pos) {
        return !(
                pos.x < 0 ||
                pos.y < 0 ||
                pos.x >= width ||
                pos.y >= height
        );
    }

    public Boolean isFresh(Pos pos){
        if (isValid(pos)) {
            return area[pos.x][pos.y] == ConsoleSigns.FRESH_NODE;
        }
        return false;
    }

    public Boolean isStart(Pos pos){
        if (isValid(pos)) {
            return (area[pos.x][pos.y] == ConsoleSigns.START);
        }
        return false;
    }

    public Boolean isEnd(Pos pos){
        if (isValid(pos)) {
            return (area[pos.x][pos.y] == ConsoleSigns.END);
        }
        return false;
    }

    public Boolean isAccessible(Pos pos) {
        if (isValid(pos)) {
            return (area[pos.x][pos.y] != ConsoleSigns.OPENED_NODE) &&
                    (area[pos.x][pos.y] != ConsoleSigns.BORDER) &&
                    (area[pos.x][pos.y] != ConsoleSigns.UNDEFINED);
        }
        return false;
    }

    public void addPosNeighborIfItFresh(Pos pos, List<Pos> list) {
        if (isFresh(pos)||isEnd(pos)) {
            list.add(pos);
        }
    }

    public char getState(Pos pos) {
       if(!isValid(pos)) {
           throw  new IllegalArgumentException("Invalid Position. getStateFunction");
       }
       return area[pos.x][pos.y];
    }

    @Override
    public String toString() {
        StringBuilder area = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height ; j++) {
                area.append(this.area[i][j]);
            }
            area.append('\n');
        }
        return area.toString();
    }
}
