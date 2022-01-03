package adventofcode.day8;


import adventofcode.utils.FileHandler;

import java.util.*;

public class Day8 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        int numberOfOccurrences = 0;

        for (String line : lines) {
            String[] strings = line.split(" \\| ");

            String[] outputs = strings[1].split(" ");

            for (String output : outputs) {
                if (output.length() == 2 || output.length() == 3 || output.length() == 4 || output.length() == 7) {
                    numberOfOccurrences++;
                }
            }
        }
        return numberOfOccurrences;
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        int outputValue = 0;

        for (String line : lines) {
            Map<Integer, String> knownSignals = new HashMap<>();

            StringBuilder sb = new StringBuilder();
            String[] strings = line.split(" \\| ");

            String[] signals = strings[0].split(" ");
            String[] outputs = strings[1].split(" ");

            List<String> sortedOutputs = sortStringsToList(outputs);
            List<String> sortedSignals = sortStringsToList(signals);

            for (String signal : sortedSignals) {
                if (signal.length() == 2) {
                    knownSignals.put(1, signal);
                } else if (signal.length() == 3) {
                    knownSignals.put(7, signal);
                } else if (signal.length() == 4) {
                    knownSignals.put(4, signal);
                } else if (signal.length() == 7) {
                    knownSignals.put(8, signal);
                }
            }

            //Find 3
            List<String> temporarySignals = sortedSignals.stream().filter(signal -> signal.length() == 5).toList();
            for (String signal : temporarySignals) {
                String signal1 = knownSignals.get(1);

                if (containsAllChars(signal, signal1)) {
                    //we know this is 3
                    knownSignals.put(3, signal);
                    break;
                }
            }

            //Find 6
            temporarySignals = sortedSignals.stream().filter(signal -> signal.length() == 6).toList();
            for (String signal : temporarySignals) {
                String signal1 = knownSignals.get(1);

                if (!containsAllChars(signal, signal1)) {
                    //we know this is 6
                    knownSignals.put(6, signal);
                    break;
                }
            }
            List<String> containsMiddleSegment = new ArrayList<>();
            containsMiddleSegment.add(knownSignals.get(3));
            containsMiddleSegment.add(knownSignals.get(4));
            containsMiddleSegment.add(knownSignals.get(6));
            containsMiddleSegment.add(knownSignals.get(8));

            List<Character> possibleMiddleSegment = findCommonSegments(containsMiddleSegment);

            char middleSegment = findNotMatchingSegment(possibleMiddleSegment, new ArrayList<>(stringToCharacterSet(knownSignals.get(1)))).get(0);

            //Find 0
            List<String> currentlyUnknownSignals = findCurrentlyUnknownSignals(sortedSignals, 6, knownSignals);

            for (String unknownSignal : currentlyUnknownSignals) {
                if (!stringContainsChar(unknownSignal, middleSegment)) {
                    knownSignals.put(0, unknownSignal);
                    break;
                }
            }

            //find 9
            currentlyUnknownSignals = findCurrentlyUnknownSignals(sortedSignals, 6, knownSignals);
            for (String signal : currentlyUnknownSignals) {
                String signal1 = knownSignals.get(1);

                if (containsAllChars(signal, signal1)) {
                    //we know this is 9
                    knownSignals.put(9, signal);
                    break;
                }
            }

            List<String> containsBottomRight = new ArrayList<>();
            containsBottomRight.add(knownSignals.get(0));
            containsBottomRight.add(knownSignals.get(1));
            containsBottomRight.add(knownSignals.get(3));
            containsBottomRight.add(knownSignals.get(4));
            containsBottomRight.add(knownSignals.get(6));
            containsBottomRight.add(knownSignals.get(7));
            containsBottomRight.add(knownSignals.get(8));
            containsBottomRight.add(knownSignals.get(9));

            List<Character> possibleBottomRightSegment = findCommonSegments(containsBottomRight);

            char bottomRightSegment = possibleBottomRightSegment.get(0);

            //Find 2 & 5
            currentlyUnknownSignals = findCurrentlyUnknownSignals(sortedSignals, 5, knownSignals);
            for (String signal : currentlyUnknownSignals) {

                if (stringContainsChar(signal, bottomRightSegment)) {
                    //we know this is 5
                    knownSignals.put(5, signal);
                } else {
                    //we know this is 2
                    knownSignals.put(2, signal);
                }
            }

            for (String output : sortedOutputs) {
                knownSignals.forEach((key, value) -> {
                    if (value.equalsIgnoreCase(output)) {
                        sb.append(key);
                    }
                });
            }
            outputValue += Integer.parseInt(sb.toString());
            sb.setLength(0);
        }

        return outputValue;
    }

    private List<String> sortStringsToList(String[] input) {
        List<String> sortedList = new ArrayList<>();
        for (String string : input) {
            sortedList.add(sortString(string));
        }
        return sortedList;
    }

    private boolean stringContainsChar(String string, char ch) {
        return string.indexOf(ch) > -1;
    }

    private List<String> findCurrentlyUnknownSignals(List<String> signals, int numberOfSegments, Map<Integer, String> knownSignals) {
        List<String> currentlyUnknownSignals = signals.stream().filter(signal -> signal.length() == numberOfSegments).toList();

        currentlyUnknownSignals = currentlyUnknownSignals.stream().filter(signal -> !knownSignals.containsValue(signal)).toList();
        return currentlyUnknownSignals;
    }

    private List<Character> findNotMatchingSegment(List<Character> signalA, List<Character> signalB) {
        signalA.removeAll(signalB);
        return signalA;

    }

    private List<Character> findCommonSegments(List<String> signals) {
        Set<Character> commonSegments = stringToCharacterSet(signals.get(0));

        for (String signal : signals) {
            Set<Character> signalSegments = stringToCharacterSet(signal);

            Set<Character> tempSegments = new HashSet<>(commonSegments);

            for (Character segment : tempSegments) {
                if (!signalSegments.contains(segment)) {
                    commonSegments.remove(segment);
                }
            }
        }
        return new ArrayList<>(commonSegments);
    }

    private Set<Character> stringToCharacterSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    private boolean containsAllChars(String container, String containee) {
        return stringToCharacterSet(container).containsAll(stringToCharacterSet(containee));
    }

    private static String sortString(String inputString) {
        char[] tempArray = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
