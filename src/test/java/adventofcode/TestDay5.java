package adventofcode;

import adventofcode.day5.Day5;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay5 {

    @Test
    public void part1() {
        Day5 day = new Day5();
        long result = day.part1("testinput5.txt");

        assertEquals(5, result);

        System.out.println(day.part1("input5.txt"));
    }

    @Test
    public void part2() {
        Day5 day = new Day5();
        long result = day.part2("testinput5.txt");

        	Assert.assertEquals(12, result);

        System.out.println(day.part2("input5.txt"));

    }
}