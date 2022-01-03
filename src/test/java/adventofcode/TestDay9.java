package adventofcode;

import adventofcode.day9.Day9;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay9 {

    @Test
    public void part1() {
        Day9 day = new Day9();
        long result = day.part1("testinput9.txt");
        assertEquals(15, result);

        System.out.println(day.part1("input9.txt"));
    }

    @Test
    public void part2() {
        Day9 day = new Day9();
        long result = day.part2("testinput9.txt");
        assertEquals(1134, result);

        System.out.println(day.part2("input9.txt"));
    }
}