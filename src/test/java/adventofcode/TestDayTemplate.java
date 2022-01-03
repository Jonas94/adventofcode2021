package adventofcode;

import adventofcode.dayTemplate.DayTemplate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDayTemplate {

    @Test
    public void part1() {
        DayTemplate day = new DayTemplate();
        long result = day.part1("testinputTemplate.txt");
        assertEquals(0, result);
        System.out.println(day.part1("inputTemplate.txt"));
    }

    @Test
    public void part2() {
        DayTemplate day = new DayTemplate();
        long result = day.part2("testinputTemplate.txt");
        assertEquals(0, result);
        System.out.println(day.part2("inputTemplate.txt"));
    }
}