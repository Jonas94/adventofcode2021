package adventofcode;

import adventofcode.day10.Day10;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay10 {

    @Test
    public void part1() {
        Day10 day = new Day10();
        long result = day.part1("testinput10.txt");
        assertEquals(26397, result);
        System.out.println(day.part1("input10.txt"));
    }

    @Test
    public void part2() {
        Day10 day = new Day10();
        long result = day.part2("testinput10.txt");
        assertEquals(288957, result);
        System.out.println(day.part2("input10.txt"));
    }
}