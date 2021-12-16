package adventofcode;

import adventofcode.day6.Day6;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay6 {

    @Test
    public void part1() {
        Day6 day = new Day6();
        long result = day.part1("testinput6.txt", 18);

        assertEquals(26, result);
        result = day.part1("testinput6.txt", 80);
        assertEquals(5934, result);
        System.out.println(day.part1("input6.txt", 80));
    }


    @Test
    public void part2() {
        Day6 day = new Day6();
        long result = day.part2("testinput6.txt", 18);

        assertEquals(26, result);

        result = day.part2("testinput6.txt", 80);
        assertEquals(5934, result);

        result = day.part2("testinput6.txt", 256);
        assertEquals(26984457539L, result);

        System.out.println(day.part2("input6.txt", 256));
    }
}