package adventofcode.day2;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public int solveDay2Part1(String inputFile) {
        Position position = new Position(0, 0);
        List<Command> commands = readStringsToCommandList(inputFile, position, false);

        for (Command command : commands) {
            command.execute();
        }

        return position.getX() * position.getY();
    }

    public int solveDay2Part2(String inputFile) {
        Position position = new Position(0, 0);
        List<Command> commands = readStringsToCommandList(inputFile, position, true);

        for (Command command : commands) {
            command.execute();
        }

        return position.getX() * position.getY();
    }


    private List<Command> readStringsToCommandList(String inputFile, Position position, boolean part2) {
        List<String> inputStrings = FileHandler.readFileIntoList(inputFile);
        List<Command> commands = new ArrayList<>();

        for (String row : inputStrings) {
            try {
                String[] movementInstructions = row.split(" ");

                Command command = null;

                if (movementInstructions[0].equalsIgnoreCase("FORWARD")) {
                    command = new MoveForward(position, Integer.parseInt(movementInstructions[1]));
                } else if (movementInstructions[0].equalsIgnoreCase("UP")) {
                    if (part2) {
                        command = new AdjustAim(position, Math.negateExact(Integer.parseInt(movementInstructions[1])));

                    } else {
                        command = new MoveUp(position, Integer.parseInt(movementInstructions[1]));
                    }
                } else if (movementInstructions[0].equalsIgnoreCase("DOWN")) {
                    if (part2) {
                        command = new AdjustAim(position, Integer.parseInt(movementInstructions[1]));
                    } else {
                        command = new MoveDown(position, Integer.parseInt(movementInstructions[1]));
                    }
                }


                commands.add(command);

            } catch (NumberFormatException e) {
                System.out.println("Something went wrong parsing number");
            }
        }
        return commands;
    }
}
