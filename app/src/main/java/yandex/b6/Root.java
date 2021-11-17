package yandex.b6;

import java.util.Scanner;

public class Root {

    static double a, b, c, d;

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        a = inp.nextDouble();
        b = inp.nextDouble();
        c = inp.nextDouble();
        d = inp.nextDouble();

        double right = 1, middle;
        while (func(right) * func(-right) >= 0) right *= 2;
        double left = -right;

        while (right - left > 1e-6) {
            middle = (left + right) / 2;
            if (func(middle) * func(right) > 0) right = middle;
            else left = middle;
        }

        System.out.println(left);
        inp.close();
    }

    public static Double func(Double x) {
        return a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
    }
}
