package adventofcode;

import adventofcode.day7.Day7;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay7 {

    @Test
    public void part1() {
        Day7 day = new Day7();
        long result = day.part1("testinput7.txt");
        assertEquals(37, result);

        System.out.println(day.part1("input7.txt"));
    }

    @Test
    public void part2() {
        Day7 day = new Day7();
        long result = day.part2("testinput7.txt");
        assertEquals(168, result);

        System.out.println(day.part2("input7.txt"));
    }
}