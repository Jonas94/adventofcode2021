package adventofcode.day5;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {

    private int[][] grid;

    public long part1(String inputFile) {
        List<Line> lines = parseInputToLines(inputFile);
        lines = lines.stream().filter(line -> line.getFromX() == line.getToX() || line.getFromY() == line.getToY()).collect(Collectors.toList());

        initGrid();

        for (Line line : lines) {
            if (line.getFromX() > line.getToX()) {
                int tempX = line.getFromX();
                line.setFromX(line.getToX());
                line.setToX(tempX);
            }

            if (line.getFromY() > line.getToY()) {
                int tempY = line.getFromY();
                line.setFromY(line.getToY());
                line.setToY(tempY);
            }


            for (int i = line.getFromX(); i <= line.getToX(); i++) {
                for (int j = line.getFromY(); j <= line.getToY(); j++) {
                    grid[i][j]++;
                }
            }
        }

        return calculateNumbersOfAtLeastTwoOverlappingLinesInGrid();
    }

    private void initGrid() {
        grid = new int[1000][1000];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = 0;
            }
        }
    }


    public long part2(String inputFile) {
        List<Line> lines = parseInputToLines(inputFile);

        lines.stream().forEach(line -> {
            if (line.getFromX() != line.getToX() && line.getFromY() != line.getToY()) {
                line.setDiagonal(true);
            }
        });
        initGrid();

        for (Line line : lines) {
            if (line.isDiagonal()) {
                continue;
            }
            if (line.getFromX() < line.getToX()) {
                for (int i = line.getFromX(); i <= line.getToX(); i++) {
                    if (line.getFromY() < line.getToY()) {
                        for (int j = line.getFromY(); j <= line.getToY(); j++) {
                            grid[j][i]++;
                        }
                    } else {
                        for (int j = line.getFromY(); j >= line.getToY(); j--) {
                            grid[j][i]++;
                        }
                    }
                }
            } else {
                for (int i = line.getFromX(); i >= line.getToX(); i--) {
                    if (line.getFromY() < line.getToY()) {
                        for (int j = line.getFromY(); j <= line.getToY(); j++) {
                            grid[j][i]++;
                        }
                    } else {
                        for (int j = line.getFromY(); j >= line.getToY(); j--) {
                            grid[j][i]++;
                        }
                    }
                }
            }
        }


        lines = lines.stream().filter(Line::isDiagonal).collect(Collectors.toList());


        for (Line line : lines) {

            if (line.getFromX() > line.getToX()) {
                for (int i = line.getFromX(); i >= line.getToX(); i--) {
                    if (line.getFromY() > line.getToY()) {
                        for (int j = line.getFromY(); j >= line.getToY(); j--) {
                            grid[j][i]++;
                            if (line.isDiagonal()) {
                                i--;
                            }
                            //
                        }
                    } else {
                        for (int j = line.getFromY(); j <= line.getToY(); j++) {
                            grid[j][i]++;
                            if (line.isDiagonal()) {
                                i--;
                            }
                        }
                    }
                }
            } else {
                for (int i = line.getFromX(); i <= line.getToX(); i++) {
                    if (line.getFromY() > line.getToY()) {
                        for (int j = line.getFromY(); j >= line.getToY(); j--) {
                            grid[j][i]++;
                            if (line.isDiagonal()) {

                                i++;
                            }
                        }
                    } else {
                        for (int j = line.getFromY(); j <= line.getToY(); j++) {
                            grid[j][i]++;
                            if (line.isDiagonal()) {
                                i++;
                            }
                        }
                    }
                }

            }
        }

        printGrid();

        return calculateNumbersOfAtLeastTwoOverlappingLinesInGrid();
    }


    private int calculateNumbersOfAtLeastTwoOverlappingLinesInGrid() {
        int numbersOfOverlappingLines = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 1) {
                    numbersOfOverlappingLines++;
                }
            }
        }
        return numbersOfOverlappingLines;
    }


    private void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private List<Line> parseInputToLines(String inputFile) {
        List<String> inputStrings = FileHandler.readFileIntoList(inputFile);

        List<Line> lines = new ArrayList<>();
        for (String input : inputStrings) {
            String[] points = input.split(" -> ");
            lines.add(new Line(points));
        }

        return lines;
    }


}
