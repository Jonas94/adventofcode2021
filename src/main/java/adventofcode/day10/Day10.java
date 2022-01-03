package adventofcode.day10;

import adventofcode.utils.FileHandler;

import java.util.*;

public class Day10 {

    Set<Character> openingChars = new HashSet<>(List.of('{', '(', '<', '['));
    Set<Character> closingChars = new HashSet<>(List.of('}', ')', '>', ']'));

    public long part1(String inputFile) {
        Map<Character, Integer> scoreMap = Map.of(')', 3, ']', 57, '}', 1197, '>', 25137);

        List<String> lines = FileHandler.readFileIntoList(inputFile);
        long score = 0;

        for (String line : lines) {
            List<Character> characterList = stringToCharacterList(line);
            Deque<Character> currentOpeningChars = new ArrayDeque<>();

            for (Character ch : characterList) {
                if (isOpeningChar(ch)) {
                    currentOpeningChars.add(ch);
                } else if (isClosingChar(ch) && !isMatchingCharacterType(ch, currentOpeningChars.pop())) {
                    score += scoreMap.get(ch);
                }
            }
        }

        return score;
    }

    public long part2(String inputFile) {
        Map<Character, Integer> scoreMap = Map.of(')', 1, ']', 2, '}', 3, '>', 4);

        List<String> lines = FileHandler.readFileIntoList(inputFile);
        List<String> remainingLines = new ArrayList<>(lines);

        List<Long> scoreList = new ArrayList<>();

        for (String line : lines) {
            List<Character> characterList = stringToCharacterList(line);
            Deque<Character> currentOpeningChars = new ArrayDeque<>();

            for (Character ch : characterList) {
                if (isOpeningChar(ch)) {
                    currentOpeningChars.add(ch);
                } else if (isClosingChar(ch) && !isMatchingCharacterType(ch, currentOpeningChars.pop())) {
                    remainingLines.remove(line);
                }
            }
            long lineScore = 0;

            if (remainingLines.contains(line)) {
                while (!currentOpeningChars.isEmpty()) {
                    char currentChar = getMatchingClosingCharacter(currentOpeningChars.pop());
                    lineScore = lineScore * 5;
                    lineScore += scoreMap.get(currentChar);
                }
                scoreList.add(lineScore);
            }
        }

        return scoreList.stream().sorted().skip(scoreList.size() / 2).toList().get(0);
    }

    private boolean isMatchingCharacterType(char first, char second) {
        switch (first) {
            case '}':
                return second == '{';
            case ')':
                return second == '(';
            case '>':
                return second == '<';
            case ']':
                return second == '[';
            default:
                return false;
        }
    }

    private char getMatchingClosingCharacter(char ch) {
        switch (ch) {
            case '{':
                return '}';
            case '(':
                return ')';
            case '<':
                return '>';
            case '[':
                return ']';
            default:
                return '0';
        }
    }

    private boolean isOpeningChar(Character ch) {
        return openingChars.contains(ch);
    }

    private boolean isClosingChar(Character ch) {
        return closingChars.contains(ch);
    }

    private List<Character> stringToCharacterList(String s) {
        List<Character> characterList = new LinkedList<>();
        for (char c : s.toCharArray()) {
            characterList.add(c);
        }
        return characterList;
    }
}
