package adventofcode;

import adventofcode.day11.Day11;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay11 {

    @Test
    public void part1() {
        Day11 day = new Day11();
        long result = day.part1("testinput11.txt");
        assertEquals(1656, result);
        System.out.println(day.part1("input11.txt"));
    }

    @Test
    public void part2() {
        Day11 day = new Day11();
        long result = day.part2("testinput11.txt");
        assertEquals(195, result);
        System.out.println(day.part2("input11.txt"));
    }
}