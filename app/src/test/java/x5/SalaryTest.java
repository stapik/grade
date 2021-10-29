package x5;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SalaryTest {

    @Test
    public void testDefaultOne() {
        assertEquals(Salary.getResult(Arrays.asList(51, 48, 62), 11), 2);
    }

    @Test
    public void testDefaultTwo() {
        assertEquals(Salary.getResult(Arrays.asList(51, 48, 54, 48), 14), 1);
    }

    @Test
    public void testManyOne() {
        assertEquals(Salary.getResult(Arrays.asList(57, 45, 54, 48, 23, 46, 89, 67, 25, 78, 59, 71), 99), 11);
    }

    @Test
    public void testManyTwo() {
        assertEquals(Salary.getResult(Arrays.asList(57, 45, 54, 48, 23, 46, 89, 67, 25, 78, 59, 71), 611), 11);
    }

    @Test
    public void testOne() {
        assertEquals(Salary.getResult(Arrays.asList(100), 1000), 0);
    }

    @Test
    public void testHundredOne() {
        assertEquals(Salary.getResult(Arrays.asList(100, 100, 100, 100, 100), 15), 0);
    }

    @Test
    public void testHundredTwo() {
        assertEquals(Salary.getResult(Arrays.asList(100, 100, 100, 100, 100), 999), 2);
    }

    @Test
    public void testLast() {
        assertEquals(Salary.getResult(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16), 100), 12);
    }

}
