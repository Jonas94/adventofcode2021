package adventofcode.day13;

import adventofcode.utils.FileHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Day13 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        List<String> pointInstructions = new ArrayList<>();
        List<String> folds = new ArrayList<>();
        for (String line : lines) {
            if (line.contains(",")) {
                pointInstructions.add(line);
            } else if (line.contains("fold")) {
                folds.add(line);
            }
        }

        List<Point> points = new ArrayList<>();
        for (String pointInstruction : pointInstructions) {
            points.add(new Point(Integer.parseInt(pointInstruction.substring(0, pointInstruction.indexOf(","))),
                    Integer.parseInt(pointInstruction.substring(pointInstruction.indexOf(",") + 1))));
        }

        System.out.println();

        List<String> onlyFirstFold = folds.subList(0, 1);
        for (String fold : onlyFirstFold) {
            String[] instruction = fold.split(" ")[2].split("=");
            String direction = instruction[0];
            int line = Integer.parseInt(instruction[1]);

            for (Point p : points) {
                if (direction.equals("x")) {
                    if (p.x > line) {
                        int difference = p.x - line;
                        p.x = line - difference;
                    }
                } else {
                    if (p.y > line) {
                        int difference = p.y - line;
                        p.y = line - difference;
                    }
                }
            }
            System.out.println();

        }
        return countVisiblePoints(points);
    }

    private String visiblePointsAsString(List<Point> points) {
        Point endPoint = findLargestPosition(points);

        String[][] grid = new String[endPoint.y + 1][endPoint.x + 1];
        for (int y = 0; y <= endPoint.y; y++) {
            for (int x = 0; x <= endPoint.x; x++) {
                grid[y][x] = ".";
            }
        }

        for (Point p : points) {
            grid[p.y][p.x] = "#";
        }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y <= endPoint.y; y++) {
            for (int x = 0; x <= endPoint.x; x++) {
                sb.append(grid[y][x]);
            }
            if (y < endPoint.y) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private void printPointsAsGrid(List<Point> points) {
        Point endPoint = findLargestPosition(points);

        String[][] grid = new String[endPoint.y + 1][endPoint.x + 1];
        for (int y = 0; y <= endPoint.y; y++) {
            for (int x = 0; x <= endPoint.x; x++) {
                grid[y][x] = ".";
            }
        }

        for (Point p : points) {
            grid[p.y][p.x] = "#";

        }

        for (int y = 0; y <= endPoint.y; y++) {
            for (int x = 0; x <= endPoint.x; x++) {
                System.out.print(grid[y][x]);
            }
            System.out.println();

        }
    }

    private int countVisiblePoints(List<Point> points) {

        List<Point> tempList = new ArrayList<>();

        for (Point p1 : points) {

            boolean existsInList = false;

            for (Point p2 : tempList) {
                if (p1.x == p2.x && p1.y == p2.y) {
                    existsInList = true;
                    break;
                }
            }
            if (!existsInList) {
                tempList.add(p1);
            }
        }

        return tempList.size();
    }


    private Point findLargestPosition(List<Point> points) {
        int largestX = 0;
        int largestY = 0;
        for (Point p : points) {
            if (p.x > largestX) {
                largestX = p.x;
            }

            if (p.y > largestY) {
                largestY = p.y;
            }
        }

        return new Point(largestX, largestY);
    }

    public String part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        List<String> pointInstructions = new ArrayList<>();
        List<String> folds = new ArrayList<>();
        for (String line : lines) {
            if (line.contains(",")) {
                pointInstructions.add(line);
            } else if (line.contains("fold")) {
                folds.add(line);
            }
        }

        List<Point> points = new ArrayList<>();
        for (String pointInstruction : pointInstructions) {
            points.add(new Point(Integer.parseInt(pointInstruction.substring(0, pointInstruction.indexOf(","))),
                    Integer.parseInt(pointInstruction.substring(pointInstruction.indexOf(",") + 1))));
        }

        for (String fold : folds) {
            String[] instruction = fold.split(" ")[2].split("=");
            String direction = instruction[0];
            int line = Integer.parseInt(instruction[1]);

            for (Point p : points) {
                if (direction.equals("x")) {
                    if (p.x > line) {
                        int difference = p.x - line;
                        p.x = line - difference;
                    }
                } else {
                    if (p.y > line) {
                        int difference = p.y - line;
                        p.y = line - difference;
                    }
                }
            }

        }

        printPointsAsGrid(points);

        return visiblePointsAsString(points);
    }


}
