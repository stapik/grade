package x5;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SupplierTest {

    @Test
    public void test1() {
        assertEquals(
                Supplier.getResult(
                        1000,
                        Arrays.asList(100, 200, 300, 400),
                        Arrays.asList(50, 100, 500, 100),
                        Arrays.asList(4, 5, 7, 3),
                        Arrays.asList(0, 100, 5000, 1000)
                ),
                "0,1,3"
        );
    }

    @Test
    public void test2() {
        assertEquals(
                Supplier.getResult(
                        1000,
                        Arrays.asList(100, 200, 300, 400),
                        Arrays.asList(50, 100, 500, 100),
                        Arrays.asList(4, 5, 7, 3),
                        Arrays.asList(1000, 100, 5000, 1000)
                ),
                "1,0,3"
        );
    }

    @Test
    public void test3() {
        assertEquals(
                Supplier.getResult(
                        80000,
                        Arrays.asList(100, 200, 300, 400),
                        Arrays.asList(50, 100, 500, 100),
                        Arrays.asList(17, 36, 70, 45),
                        Arrays.asList(1000, 500, 5000, 1000)
                ),
                "2,1,0,3"
        );
    }

    @Test
    public void test4() {
        assertEquals(
                Supplier.getResult(
                        28000,
                        Arrays.asList(100, 200, 3000, 400),
                        Arrays.asList(50, 100, 500, 100),
                        Arrays.asList(17, 36, 70, 45),
                        Arrays.asList(1000, 500, 5000, 1000)
                ),
                "1,0,3,2"
        );
    }

    @Test
    public void test5() {
        assertEquals(
                Supplier.getResult(
                        28000,
                        Arrays.asList(500, 200, 3000, 400),
                        Arrays.asList(50, 100, 500, 100),
                        Arrays.asList(17, 36, 70, 45),
                        Arrays.asList(1000, 500, 5000, 0)
                ),
                "1,3,2"
        );
    }

    @Test
    public void test6() {
        assertEquals(
                Supplier.getResult(
                        8000,
                        Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1),
                        Arrays.asList(50, 100, 500, 100, 50, 100, 500, 100, 50),
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                        Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90)
                ),
                "6,2,7,5,3,1,8,4,0"
        );
    }

}
