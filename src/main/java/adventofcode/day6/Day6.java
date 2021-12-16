package adventofcode.day6;


import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6 {


    public long part1(String inputFile, int generations) {
        List<Integer> fishAges = parseInputToListOfNumbers(inputFile);
        for (int i = 0; i < generations; i++) {

            for (int j = 0; j < fishAges.size(); j++) {
                if (fishAges.get(j) == 0) {
                    fishAges.add(9); //because it shouldn't age the first day
                    fishAges.set(j, 6);
                } else {
                    fishAges.set(j, fishAges.get(j) - 1);
                }
            }
        }

        return fishAges.size();
    }


    public long part2(String inputFile, int generations) {
        List<Integer> fishAges = parseInputToListOfNumbers(inputFile);
        Map<Integer, Long> fishMap = new HashMap<>();

        for (Integer currentFishAge : fishAges) {
            addNewEntryOfFishAge(fishMap, currentFishAge, 1);
        }

        for (int generation = 0; generation < generations; generation++) {
            Map<Integer, Long> tempFishMap = new HashMap<>(fishMap);

            for (var entry : fishMap.entrySet()) {

                int currentFishAge = entry.getKey();

                decreaseEntriesOfFishAge(tempFishMap, currentFishAge, entry.getValue());
                if (currentFishAge - 1 < 0) {
                    addNewEntryOfFishAge(tempFishMap, 8, entry.getValue());
                    addNewEntryOfFishAge(tempFishMap, 6, entry.getValue());

                } else {
                    addNewEntryOfFishAge(tempFishMap, currentFishAge - 1, entry.getValue());

                }
            }

            fishMap = new HashMap<>(tempFishMap);
        }
        long count = 0;
        for (var entry : fishMap.entrySet()) {
            count = count + entry.getValue();
        }
        return count;
    }

    private void decreaseEntriesOfFishAge(Map<Integer, Long> fishMap, Integer entryToDecrease, long numberOfEntries) {
        long newValue = fishMap.get(entryToDecrease) - numberOfEntries;
        if (newValue >= 0) {
            fishMap.put(entryToDecrease, newValue);
        }
    }

    private void addNewEntryOfFishAge(Map<Integer, Long> fishMap, Integer newFishAge, long numberOfEntries) {
        if (fishMap.containsKey(newFishAge)) {
            long newValue = fishMap.get(newFishAge) + numberOfEntries;
            fishMap.put(newFishAge, newValue);
        } else {
            fishMap.put(newFishAge, numberOfEntries);
        }
    }

    private List<Integer> parseInputToListOfNumbers(String inputFile) {
        FileHandler fileHandler = new FileHandler();
        List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource(inputFile).getFile());

        List<Integer> fishAges = new ArrayList<>();
        String[] inputStrings = input.get(0).split(",");

        for (String number : inputStrings) {
            fishAges.add(Integer.parseInt(number));
        }

        return fishAges;
    }
}
