package adventofcode;

import adventofcode.day8.Day8;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay8 {

    @Test
    public void part1() {
        Day8 day = new Day8();
        long result = day.part1("testinput8.txt");
        assertEquals(26, result);

        System.out.println(day.part1("input8.txt"));
    }

    @Test
    public void part2() {
        Day8 day = new Day8();
        long result = day.part2("testinput8.txt");
        assertEquals(61229, result);

        System.out.println(day.part2("input8.txt"));
    }
}