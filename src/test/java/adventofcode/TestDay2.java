package adventofcode;

import adventofcode.day2.Day2;
import org.junit.Assert;
import org.junit.Test;

public class TestDay2 {

	@Test
	public void testSolveDay2Part1() {
		Day2 day2 = new Day2();
		int result = day2.solveDay2Part1("testinput2.txt");

		Assert.assertEquals(150, result);

		System.out.println(day2.solveDay2Part1("input2.txt"));
	}

	@Test
	public void testSolveDay2Part2() {
		Day2 day2 = new Day2();
		int result = day2.solveDay2Part2("testinput2.txt");

		Assert.assertEquals(900, result);

		System.out.println(day2.solveDay2Part2("input2.txt"));

	}
}