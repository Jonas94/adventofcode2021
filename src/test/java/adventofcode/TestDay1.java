package adventofcode;

import adventofcode.day1.*;
import org.junit.*;

public class TestDay1 {

	@Test
	public void testSolveDay1Part1() {
		Day1 day1 = new Day1();
		int result = day1.solveDay1("testinput1.txt");

		Assert.assertEquals(7, result);

		System.out.println(day1.solveDay1("input1.txt"));
	}

	@Test
	public void testSolveDay1Part2() {
		Day1 day1 = new Day1();
		int result = day1.solveDay2("testinput1.txt");

		Assert.assertEquals(5, result);

		System.out.println(day1.solveDay2("input1.txt"));

	}
}