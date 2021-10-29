package x5;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BloggerTest {

    @Test
    public void test1() {
        assertEquals(Blogger.closestSum(Arrays.asList(-1, 2, 1, -4), 1), 2);
    }

    @Test
    public void test2() {
        assertEquals(Blogger.closestSum(Arrays.asList(0, 0, 0), 1), 0);
    }

    @Test
    public void test3() {
        assertEquals(Blogger.closestSum(Arrays.asList(0, 1, 2), 3), 3);
    }

    @Test
    public void test4() {
        assertEquals(Blogger.closestSum(Arrays.asList(1, 1, 1, 1), 4), 3);
    }

    @Test
    public void test5() {
        assertEquals(Blogger.closestSum(Arrays.asList(1, 1, 1, 0), -100), 2);
    }

    @Test
    public void test6() {
        assertEquals(Blogger.closestSum(Arrays.asList(1, 1, 1, 0), 100), 3);
    }

    @Test
    public void test7() {
        assertEquals(Blogger.closestSum(Arrays.asList(0, 2, 1, -3), 1), 0);
    }
}
