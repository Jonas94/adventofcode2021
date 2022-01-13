package adventofcode;

import adventofcode.day13.Day13;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDay13 {

    @Test
    public void part1() {
        Day13 day = new Day13();
        long result = day.part1("testinput13.txt");
        assertEquals(17, result);
        System.out.println(day.part1("input13.txt"));
    }

    @Test
    public void part2() {
        Day13 day = new Day13();
        String expectedResult = "..##.###..####..##..#..#..##..#..#.###.\n" +
                "...#.#..#....#.#..#.#..#.#..#.#..#.#..#\n" +
                "...#.#..#...#..#....#..#.#..#.#..#.#..#\n" +
                "...#.###...#...#....#..#.####.#..#.###.\n" +
                "#..#.#....#....#..#.#..#.#..#.#..#.#.#.\n" +
                ".##..#....####..##...##..#..#..##..#..#";

        assertEquals(expectedResult, day.part2("input13.txt"));

    }
}