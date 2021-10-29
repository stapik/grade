package yandex.b1;

import java.util.Scanner;

public class SchoolBuilder {

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        int totalCount = myInput.nextInt(), val = 0;
        for (int i = 0; i < totalCount; i++) {
            val = myInput.nextInt();
            if (totalCount / 2 == i) {
                break;
            }
        }
        System.out.println(val);
        myInput.close();
    }
}
