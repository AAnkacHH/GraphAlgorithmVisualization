package cz.cvut.fit.plyskand.main.view;

import cz.cvut.fit.plyskand.main.signs.ConsoleSigns;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class AreaBuilder {

    private Area area = null;
    private List<String> lines;

    public AreaBuilder(@NotNull List<String> lines) throws IllegalArgumentException {
        if (lines.isEmpty()) throw new IllegalArgumentException("Input is empty!");
        this.lines = lines;
        int areaHeight = lines.size() - 2;
        int areaWidth = lines.get(0).length();
        this.area = new Area(new char[areaWidth][areaHeight], areaHeight, areaWidth);
    }

    /**
     * Create an area with all parameters
     * */
    public Area build() {
        int height = area.getHeight();
        int width = area.getWidth();
        for (int i = 0; i < height; i++) {
            char [] chars = lines.get(i).toCharArray();
            for (int j = 0; j < width; j++) {
                area.setChar(new Pos(j, i), chars[j]);
            }
        }
        setDestination(height);
        return this.area;
    }

    /**
     * Set start and end point into the map
     * */
    private void setDestination(int height) {
        // I can do this because the input is always valid
        String start = lines.get(height).replace("start ","");
        List<String> startPositions = Arrays.asList(start.split("\\s*,\\s*"));
        int stX = Integer.parseInt(startPositions.get(0));
        int stY = Integer.parseInt(startPositions.get(1));

        String end = lines.get(height + 1).replace("end ","");
        List<String> endPositions = Arrays.asList(end.split("\\s*,\\s*"));
        int enX = Integer.parseInt(endPositions.get(0));
        int enY = Integer.parseInt(endPositions.get(1));

        area.setChar(new Pos(stX, stY), ConsoleSigns.START);
        area.setChar(new Pos(enX, enY), ConsoleSigns.END);
    }
}
