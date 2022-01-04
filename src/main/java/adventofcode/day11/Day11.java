package adventofcode.day11;

import adventofcode.utils.FileHandler;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Day11 {

    public final static int GRID_SIZE = 10;
    public final static int STEPS = 100;

    public long part1(String inputFile) {
        int numberOfFlashes = 0;

        List<String> lines = FileHandler.readFileIntoList(inputFile);
        int[][] grid = initGrid(lines);


        for (int i = 0; i < STEPS; i++) {
            increaseAllByOne(grid);


            List<Point> currentGlowingPoints = findAllGlowing(grid);
            Set<Point> alreadyFlashed = new HashSet<>(currentGlowingPoints);

            ConcurrentLinkedQueue<Point> pointQueue = new ConcurrentLinkedQueue<>();

            for (Point glowingPoint : currentGlowingPoints) {
                List<Point> adjacents = findAdjacents(glowingPoint);
                for (Point adjacent : adjacents) {
                    if (!alreadyFlashed.contains(adjacent)) {
                        if (increasePointByOneAndCheckIfFlashed(grid, adjacent)) {
                            alreadyFlashed.add(adjacent);
                            pointQueue.add(adjacent);
                        }
                    }
                }
            }

            while (!pointQueue.isEmpty()) {
                List<Point> adjacents = findAdjacents(pointQueue.poll());
                for (Point adjacent : adjacents) {
                    if (!alreadyFlashed.contains(adjacent)) {
                        if (increasePointByOneAndCheckIfFlashed(grid, adjacent)) {
                            alreadyFlashed.add(adjacent);
                            pointQueue.add(adjacent);

                        }
                    }
                }
            }
            numberOfFlashes += alreadyFlashed.size();
        }

        return numberOfFlashes;
    }


    private List<Point> findAllGlowing(int[][] grid) {
        List<Point> glowingPoints = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 9) {
                    glowingPoints.add(new Point(i, j));
                    grid[i][j] = 0;
                }
            }
        }
        return glowingPoints;
    }


    private List<Point> findAdjacents(Point point) {
        List<Point> potentialAdjacents = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                potentialAdjacents.add(new Point((int) point.getX() + i, (int) point.getY() + j));
            }
        }
        List<Point> actualAdjacents = new ArrayList<>(potentialAdjacents);

        for (Point adjacent : potentialAdjacents) {
            boolean nonRealAdjacent = false;
            if (adjacent.getX() < 0 || adjacent.getX() > GRID_SIZE - 1) {
                nonRealAdjacent = true;
            } else if (adjacent.getY() < 0 || adjacent.getY() > GRID_SIZE - 1) {
                nonRealAdjacent = true;
            }
            if (nonRealAdjacent) {
                actualAdjacents.remove(adjacent);
            }
        }
        return actualAdjacents;
    }


    private boolean increasePointByOneAndCheckIfFlashed(int[][] grid, Point point) {
        if (++grid[point.x][point.y] > 9) {
            grid[point.x][point.y] = 0;
            return true;
        }
        return false;
    }

    private void increaseAllByOne(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j]++;
            }
        }
    }


    private int[][] initGrid(List<String> lines) {
        int[][] grid = new int[lines.size()][lines.get(0).length()];

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            for (int j = 0; j < lines.get(0).length(); j++) {
                grid[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        return grid;
    }


    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        int[][] grid = initGrid(lines);

        int steps = 0;
        boolean entireGridFlashing = false;
        while (!entireGridFlashing) {
            steps++;
            increaseAllByOne(grid);

            List<Point> currentGlowingPoints = findAllGlowing(grid);
            Set<Point> alreadyFlashed = new HashSet<>(currentGlowingPoints);

            ConcurrentLinkedQueue<Point> pointQueue = new ConcurrentLinkedQueue<>();

            for (Point glowingPoint : currentGlowingPoints) {
                List<Point> adjacents = findAdjacents(glowingPoint);
                for (Point adjacent : adjacents) {
                    if (!alreadyFlashed.contains(adjacent)) {
                        if (increasePointByOneAndCheckIfFlashed(grid, adjacent)) {
                            alreadyFlashed.add(adjacent);
                            pointQueue.add(adjacent);
                        }
                    }
                }
            }

            while (!pointQueue.isEmpty()) {
                List<Point> adjacents = findAdjacents(pointQueue.poll());
                for (Point adjacent : adjacents) {
                    if (!alreadyFlashed.contains(adjacent)) {
                        if (increasePointByOneAndCheckIfFlashed(grid, adjacent)) {
                            alreadyFlashed.add(adjacent);
                            pointQueue.add(adjacent);

                        }
                    }
                }
            }
            entireGridFlashing = isEntireGridFlashing(grid);

        }

        return steps;

    }

    public boolean isEntireGridFlashing(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    return false;
                }

            }
        }
        return true;
    }


}
