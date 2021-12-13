package adventofcode;

import adventofcode.day3.Day3;
import adventofcode.day4.Day4;
import org.junit.Assert;
import org.junit.Test;

public class TestDay4 {

	@Test
	public void part1() {
		Day4 day4 = new Day4();
		long result = day4.part1("testinput4.txt");

		Assert.assertEquals(4512, result);

		System.out.println(day4.part1("input4.txt"));
	}

	@Test
	public void part2() {
		Day4 day4 = new Day4();
		long result = day4.part2("testinput4.txt");

		Assert.assertEquals(1924, result);

		System.out.println(day4.part2("input4.txt"));

	}
}