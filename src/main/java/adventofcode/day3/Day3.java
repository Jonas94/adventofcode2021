package adventofcode.day3;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class Day3 {
    public long solveDay3Part1(String inputFile) {
        List<String> binaryStrings = FileHandler.readFileIntoList(inputFile);

        int gammaRate = findRate(binaryStrings, false);
        int epsilonRate = findRate(binaryStrings, true);

        return (long) gammaRate * epsilonRate;
    }

    protected int findRate(List<String> binaryStrings, boolean findEpsilon) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < binaryStrings.get(0).length(); i++) {
            int numberOfOnes = 0;
            int numberOfZeroes = 0;
            for (String binaryString : binaryStrings) {

                if (binaryString.charAt(i) == '0') {
                    numberOfZeroes++;
                } else {
                    numberOfOnes++;
                }
            }
            if (findEpsilon) {
                if (numberOfOnes < numberOfZeroes) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            } else {
                if (numberOfOnes > numberOfZeroes) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public int solveDay3Part2(String inputFile) {
        List<String> allBinaryNumbers = FileHandler.readFileIntoList(inputFile);

        int oxygenGeneratorRating = findOxygenGeneratorRating(new ArrayList<>(allBinaryNumbers));
        int co2ScrubberRating = findCo2ScrubberRating(new ArrayList<>(allBinaryNumbers));

        return oxygenGeneratorRating * co2ScrubberRating;
    }

    private int findOxygenGeneratorRating(List<String> binaryNumbers) {
        for (int i = 0; i < binaryNumbers.get(0).length(); i++) {
            if (binaryNumbers.size() == 1) {
                break;
            }
            int numberOfOnes = 0;
            int numberOfZeroes = 0;
            for (String binaryString : binaryNumbers) {
                if (binaryString.charAt(i) == '0') {
                    numberOfZeroes++;
                } else {
                    numberOfOnes++;
                }
            }

            if (numberOfOnes < numberOfZeroes) {
                binaryNumbers.removeAll(findAllEntriesWithoutGivenValueAtCertainPositionInList(binaryNumbers, i, '1'));
            } else {
                binaryNumbers.removeAll(findAllEntriesWithoutGivenValueAtCertainPositionInList(binaryNumbers, i, '0'));
            }
        }
        return Integer.parseInt(binaryNumbers.get(0), 2);
    }

    private int findCo2ScrubberRating(List<String> binaryNumbers) {
        for (int i = 0; i < binaryNumbers.get(0).length(); i++) {
            if (binaryNumbers.size() == 1) {
                break;
            }
            int numberOfOnes = 0;
            int numberOfZeroes = 0;
            for (String binaryString : binaryNumbers) {
                if (binaryString.charAt(i) == '0') {
                    numberOfZeroes++;
                } else {
                    numberOfOnes++;
                }
            }

            if (numberOfOnes < numberOfZeroes) {
                binaryNumbers.removeAll(findAllEntriesWithoutGivenValueAtCertainPositionInList(binaryNumbers, i, '0'));
            } else {
                binaryNumbers.removeAll(findAllEntriesWithoutGivenValueAtCertainPositionInList(binaryNumbers, i, '1')); //Potentiell bugg här
            }
        }
        return Integer.parseInt(binaryNumbers.get(0), 2);
    }

    public List<String> findAllEntriesWithoutGivenValueAtCertainPositionInList(List<String> binaryNumbers, int position, char value) {
        List<String> entriesToRemove = new ArrayList<>();
        for (String binaryNumber : binaryNumbers) {
            if (binaryNumber.charAt(position) == value) {
                entriesToRemove.add(binaryNumber);
            }
        }
        return entriesToRemove;
    }
}
