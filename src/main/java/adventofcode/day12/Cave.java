package adventofcode.day12;

import java.util.ArrayList;
import java.util.List;

public class Cave {

    private String name;
    private List<Cave> adjacentCaves;
    private caveType type;

    public Cave() {
        adjacentCaves = new ArrayList<>();
    }

    public Cave(String name, List<Cave> adjacentCaves, caveType type) {
        this.name = name;
        this.adjacentCaves = adjacentCaves;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cave> getAdjacentCaves() {
        return adjacentCaves;
    }

    public void addAdjacentCave(Cave adjacentCave) {
        if (adjacentCaves == null) {
            adjacentCaves = new ArrayList<>();
        }
        adjacentCaves.add(adjacentCave);
    }

    public void setAdjacentCaves(List<Cave> adjacentCaves) {
        this.adjacentCaves = adjacentCaves;
    }

    public caveType getType() {
        return type;
    }

    public void setType(caveType type) {
        this.type = type;
    }

    public enum caveType {
        START, SMALL, LARGE, END
    }


}
