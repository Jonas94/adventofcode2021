package adventofcode;

import adventofcode.day12.Day12;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay12 {

    @Test
    public void part1() {
        Day12 day = new Day12();
        long result = day.part1("testinput12.txt");
        assertEquals(10, result);
          System.out.println(day.part1("input12.txt"));
    }

    @Test
    public void part2() {
        Day12 day = new Day12();
        long result = day.part2("testinput12.txt");
        assertEquals(36, result);
        System.out.println(day.part2("input12.txt"));
    }
}