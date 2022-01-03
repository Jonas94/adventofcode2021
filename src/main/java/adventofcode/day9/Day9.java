package adventofcode.day9;

import adventofcode.utils.FileHandler;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Day9 {

    public long part1(String inputFile) {
        List<String> lines = parseInputToList(inputFile);
        int[][] grid = initGrid(lines);
        int sumOfLowestPoints = 0;
        List<Point> lowestPoints = findLowestPoints(grid);

        for (Point point : lowestPoints) {
            sumOfLowestPoints += grid[(int) point.getX()][(int) point.getY()] + 1;
        }

        return sumOfLowestPoints;
    }

    public long part2(String inputFile) {
        List<String> lines = parseInputToList(inputFile);

        List<Integer> basinSizes = new ArrayList<>();
        int[][] grid = initGrid(lines);
        List<Point> initialPoints = findLowestPoints(grid);

        for (Point point : initialPoints) {
            Set<Point> pointsAlreadyChecked = new HashSet<>();
            Queue<Point> pointQueue = new LinkedList<>();
            pointQueue.add(point);
            while (!pointQueue.isEmpty()) {
                Point currentPoint = pointQueue.poll();
                pointsAlreadyChecked.add(currentPoint);
                pointQueue.addAll(findBasinNeighboursBelowNine(grid, currentPoint, pointsAlreadyChecked));
            }
            basinSizes.add(pointsAlreadyChecked.size());
        }

        return basinSizes.stream().sorted(Comparator.reverseOrder()).limit(3).reduce(1, (a, b) -> a * b);
    }

    private List<Point> findBasinNeighboursBelowNine(int[][] grid, Point point, Set<Point> pointsAlreadyChecked) {
        List<Point> neigboursBelowNine = new ArrayList<>();
        int pointX = (int) point.getX();
        int pointY = (int) point.getY();

        //Check above
        if (pointX > 0 && grid[pointX - 1][pointY] < 9) {
            neigboursBelowNine.add(new Point(pointX - 1, pointY));
        }

        //check left
        if (pointY > 0 && grid[pointX][pointY - 1] < 9) {
            neigboursBelowNine.add(new Point(pointX, pointY - 1));
        }

        //check right
        if (pointY < grid[0].length - 1 && grid[pointX][pointY + 1] < 9) {
            neigboursBelowNine.add(new Point(pointX, pointY + 1));
        }

        //check below
        if (pointX < grid.length - 1 && grid[pointX + 1][pointY] < 9) {
            neigboursBelowNine.add(new Point(pointX + 1, pointY));
        }

        neigboursBelowNine.removeAll(pointsAlreadyChecked);

        return neigboursBelowNine;
    }

    private List<Point> findLowestPoints(int[][] grid) {
        List<Point> lowestPoints = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                boolean[] lowestPoint = {true, true, true, true}; //LEFT, TOP, RIGHT, BOTTOM

                int currentPoint = grid[i][j];

                lowestPoint[0] = !(j > 0 && currentPoint >= grid[i][j - 1]);
                lowestPoint[1] = !(i > 0 && currentPoint >= grid[i - 1][j]);
                lowestPoint[2] = !(j < grid[i].length - 1 && currentPoint >= grid[i][j + 1]);
                lowestPoint[3] = !(i < grid.length - 1 && currentPoint >= grid[i + 1][j]);

                if (isAllTrue(lowestPoint)) {
                    lowestPoints.add(new Point(i, j));
                }
            }
        }
        return lowestPoints;
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

    private List<String> parseInputToList(String inputFile) {
        FileHandler fileHandler = new FileHandler();
        return fileHandler.readFile(getClass().getClassLoader().getResource(inputFile).getFile());
    }

    private static boolean isAllTrue(boolean[] array) {
        for (boolean b : array) if (!b) return false;
        return true;
    }
}
