package x5;

import org.junit.Test;

import static org.junit.Assert.*;

public class IpTest {

    @Test
    public void test1(){
        assertTrue(Ip.isValid("192.168.1.1"));
    }

    @Test
    public void test2(){
        assertFalse(Ip.isValid("192.168.1"));
    }

    @Test
    public void test3(){
        assertFalse(Ip.isValid(".168.1.123"));
    }

    @Test
    public void test4(){
        assertFalse(Ip.isValid("1.1.."));
    }

    @Test
    public void test5(){
        assertFalse(Ip.isValid("abc.a.a.s"));
    }
}
