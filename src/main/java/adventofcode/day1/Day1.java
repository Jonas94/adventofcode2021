package adventofcode.day1;

import adventofcode.utils.*;

import java.util.*;

public class Day1 {
    public int solveDay1(String inputFile) {
        List<Integer> numbers = readStringsToNumbers(inputFile);


        return calculateNumbersOfIncreasement(numbers);
    }

    public int solveDay2(String inputFile) {
        List<Integer> numbers = readStringsToNumbers(inputFile);
        List<Integer> summedNumbers = new ArrayList<>();
        for (int i = 1; i < numbers.size() - 1; i++) {
            summedNumbers.add(numbers.get(i - 1) + numbers.get(i) + numbers.get(i + 1));
        }
        return calculateNumbersOfIncreasement(summedNumbers);
    }

    private int calculateNumbersOfIncreasement(List<Integer> numbers) {
        int numbersOfIncreasement = 0;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(i - 1)) {
                numbersOfIncreasement++;
            }
        }
        return numbersOfIncreasement;
    }

    private List<Integer> readStringsToNumbers(String inputFile) {
        List<String> numberStrings = FileHandler.readFileIntoList(inputFile);
        List<Integer> numbers = new ArrayList<>();

        for (String number : numberStrings) {
            try {
                numbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                System.out.println("Something went wrong parsing number");
            }
        }
        return numbers;
    }
}
