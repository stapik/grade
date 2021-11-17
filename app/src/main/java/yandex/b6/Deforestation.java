package yandex.b6;

import java.math.BigInteger;
import java.util.Scanner;

public class Deforestation {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        long a = inp.nextLong(), k = inp.nextLong(), b = inp.nextLong(), m = inp.nextLong(), x = inp.nextLong();
        long days, l = 0, r = x * 2 / a + 1, hda, hdb;
        BigInteger t1, t2, trees;

        while (l < r) {
            days = (l + r) / 2;
            hda = days / k;
            hdb = days / m;
            t1 = new BigInteger(String.valueOf(days - hda)).multiply(BigInteger.valueOf(a));
            t2 = new BigInteger(String.valueOf(days - hdb)).multiply(BigInteger.valueOf(b));
            trees = t1.add(t2);
            if (trees.compareTo(BigInteger.valueOf(x)) < 0) {
                l = days + 1;
            } else {
                r = days;
            }
        }

        System.out.println(l);
        inp.close();
    }
}
