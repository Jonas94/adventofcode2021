package adventofcode;

import adventofcode.day3.Day3;
import org.junit.Assert;
import org.junit.Test;

public class TestDay3 {

	@Test
	public void part1() {
		Day3 day3 = new Day3();
		long result = day3.solveDay3Part1("testinput3.txt");

		Assert.assertEquals(198, result);

		System.out.println(day3.solveDay3Part1("input3.txt"));
	}

	@Test
	public void part2() {
		Day3 day3 = new Day3();
		int result = day3.solveDay3Part2("testinput3.txt");

		Assert.assertEquals(230, result);

		System.out.println(day3.solveDay3Part2("input3.txt"));

	}
}