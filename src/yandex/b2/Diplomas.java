package yandex.b2;

import java.io.IOException;
import java.util.Scanner;

public class Diplomas {

    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        int folders = inp.nextInt(), seconds = 0, maxDiplomas = 0, diplomas;

        for (int i = 0; i < folders; i++) {
            diplomas = inp.nextInt();
            maxDiplomas = Math.max(diplomas, maxDiplomas);
            seconds += diplomas;
        }
        seconds -= maxDiplomas;

        System.out.println(seconds);
    }
}
