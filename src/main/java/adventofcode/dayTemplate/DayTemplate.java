package adventofcode.dayTemplate;

import adventofcode.utils.FileHandler;

import java.util.List;

public class DayTemplate {

    public long part1(String inputFile) {


        return 0;
    }

    public long part2(String inputFile) {


        return 0;
    }


    private List<String> parseInputToList(String inputFile) {
        FileHandler fileHandler = new FileHandler();
        return fileHandler.readFile(getClass().getClassLoader().getResource(inputFile).getFile());
    }

}
