package yandex.b2;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String str = inp.next();
        int count = 0, div = str.length() % 2;
        for (int i = 0; i < (str.length() - div) / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                count++;
            }
        }
        System.out.println(count);
        inp.close();
    }
}
