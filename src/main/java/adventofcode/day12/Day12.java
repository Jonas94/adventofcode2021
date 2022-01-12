package adventofcode.day12;

import adventofcode.utils.FileHandler;

import java.util.*;

public class Day12 {
    Map<String, Cave> caveMap;
    List<String> paths;

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        paths = new ArrayList<>();
        caveMap = initCaveMap(lines);
        Set<Cave> visitedCaves = new HashSet<>(); // To avoid walking them twice

        Cave startCave = caveMap.get("start");
        findPathsPart1(startCave, visitedCaves, "");

        return paths.size();
    }

    public void findPathsPart1(Cave node, Set<Cave> visitedCaves, String currentPath) {
        Cave element = node;
        currentPath += element.getName() + ",";
        if (currentPath.contains("end")) {
            System.out.println(currentPath.substring(0, currentPath.length() - 1));
            paths.add(currentPath.substring(0, currentPath.length() - 1));
            return;
        }

        visitedCaves.add(element);

        List<Cave> neighbours = element.getAdjacentCaves();
        for (int i = 0; i < neighbours.size(); i++) {
            Cave n = neighbours.get(i);
            if (n != null && !visitedCaves.contains(n) || n.getType().equals(Cave.caveType.LARGE)) {
                if (!n.getType().equals(Cave.caveType.START)) {
                    findPathsPart1(n, new HashSet<>(visitedCaves), currentPath);
                }
            }
        }
    }

    public void findPathsPart2(Cave node, Map<String, Integer> visitedCaves, String currentPath) {
        Cave element = node;
        currentPath += element.getName() + ",";
        if (currentPath.contains("end")) {
            System.out.println(currentPath.substring(0, currentPath.length() - 1));
            paths.add(currentPath.substring(0, currentPath.length() - 1));
            return;
        }


        int visits = visitedCaves.containsKey(element.getName()) ? visitedCaves.get(element.getName()) : 0;
        if (element.getType().equals(Cave.caveType.SMALL)) {
            visitedCaves.put(element.getName(), visits + 1);
        }

        List<Cave> neighbours = element.getAdjacentCaves();
        for (int i = 0; i < neighbours.size(); i++) {
            Cave n = neighbours.get(i);
            if (n != null && !hasAnySmallCaveBeenVisitedTwice(visitedCaves) || n.getType().equals(Cave.caveType.LARGE)) {
                if (!n.getType().equals(Cave.caveType.START)) {
                    findPathsPart2(n, new HashMap<>(visitedCaves), currentPath);
                }
            }
        }
    }

    private boolean hasAnySmallCaveBeenVisitedTwice(Map<String, Integer> visitedCaves) {
        return visitedCaves.values().stream().filter(value -> value > 1).toList().size() > 1 || !visitedCaves.values().stream().filter(value -> value > 2).toList().isEmpty();
    }

    public Map<String, Cave> initCaveMap(List<String> lines) {
        Map<String, Cave> caveMap = new HashMap<>();

        for (String line : lines) {
            String[] caveArray = line.split("-");
            String firstCaveStr = caveArray[0];
            String secondCaveStr = caveArray[1];

            Cave firstCave = caveMap.get(firstCaveStr);
            if (firstCave == null) {
                firstCave = new Cave();
                firstCave.setName(firstCaveStr);
                firstCave.setType(getCaveTypeFromName(firstCaveStr));
                caveMap.put(firstCaveStr, firstCave);
            }

            Cave secondCave = caveMap.get(secondCaveStr);
            if (secondCave == null) {
                secondCave = new Cave();
                secondCave.setName(secondCaveStr);
                secondCave.setType(getCaveTypeFromName(secondCaveStr));
                caveMap.put(secondCaveStr, secondCave);
            }

            firstCave.addAdjacentCave(secondCave);
            secondCave.addAdjacentCave(firstCave);
        }
        return caveMap;
    }


    public Cave.caveType getCaveTypeFromName(String caveName) {
        switch (caveName) {
            case "start":
                return Cave.caveType.START;
            case "end":
                return Cave.caveType.END;
            default:
                if (Character.isUpperCase(caveName.charAt(0))) {
                    return Cave.caveType.LARGE;
                } else {
                    return Cave.caveType.SMALL;
                }
        }
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        paths = new ArrayList<>();
        caveMap = initCaveMap(lines);
        Map<String, Integer> visitCountMap = new HashMap<>(); // To avoid walking them twice

        Cave startCave = caveMap.get("start");
        findPathsPart2(startCave, visitCountMap, "");

        return paths.size();
    }

}
