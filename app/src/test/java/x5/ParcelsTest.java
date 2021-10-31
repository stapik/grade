package x5;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ParcelsTest {

    @Test
    public void test1() {
        assertEquals(Parcels.getResult(Arrays.asList(2, 4, 3, 6, 1), 5), 2);
    }

    @Test
    public void test2() {
        assertEquals(Parcels.getResult(Arrays.asList(1, 3, 2, 3), 6), 1);
    }

    @Test
    public void test3() {
        assertEquals(Parcels.getResult(Arrays.asList(5), 8), 0);
    }

    @Test
    public void test4() {
        assertEquals(Parcels.getResult(Arrays.asList(5), 5), 0);
    }

    @Test
    public void test5() {
        assertEquals(Parcels.getResult(Arrays.asList(2, 2), 4), 1);
    }

    @Test
    public void test6() {
        assertEquals(Parcels.getResult(Arrays.asList(1, 2, 1, 5, 1, 3, 5, 2, 5, 5), 6), 3);
    }
}
