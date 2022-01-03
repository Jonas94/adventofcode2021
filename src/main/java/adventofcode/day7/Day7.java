package adventofcode.day7;


import adventofcode.utils.FileHandler;
import java.util.List;

public class Day7 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        String[] positions = lines.get(0).split(",");

        int highestPosition = findHighestPosition(positions);

        int cheapest = Integer.MAX_VALUE;


        for (int i = 0; i <= highestPosition; i++) {
            int currentConsumption = 0;

            for (String position : positions) {
                currentConsumption += Math.abs(i - Integer.parseInt(position));
            }
            if (currentConsumption < cheapest) {
                cheapest = currentConsumption;
            }
        }

        return cheapest;
    }

    private int findHighestPosition(String[] positions) {
        int highestPosition = 0;

        for (String position : positions) {
            int currentPosition = Integer.parseInt(position);

            if (currentPosition > highestPosition) {
                highestPosition = currentPosition;
            }
        }
        return highestPosition;
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        String[] positions = lines.get(0).split(",");
        int highestPosition = findHighestPosition(positions);
        int cheapest = Integer.MAX_VALUE;

        for (int i = 0; i <= highestPosition; i++) {
            int currentConsumption = 0;

            for (String position : positions) {
                int steps = Math.abs(i - Integer.parseInt(position));
                for (int j = 1; j <= steps; j++) {
                    currentConsumption += j;
                }
            }
            if (currentConsumption < cheapest) {
                cheapest = currentConsumption;
            }
        }

        return cheapest;
    }
}
