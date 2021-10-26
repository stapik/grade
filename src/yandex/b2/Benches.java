package yandex.b2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Benches {

    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        int length = inp.nextInt(), benchesCount = inp.nextInt(), nextValue, prevValue = 0, center = (length - length % 2) / 2;
        boolean isOdd = length % 2 == 1;
        List<String> result = new LinkedList<>();

        for (int i = 0; i < benchesCount; i++) {
            nextValue = inp.nextInt();
            if (isOdd && nextValue == center) {
                result.add(String.valueOf(nextValue));
                break;
            }

            if (prevValue <= center && nextValue >= center) {
                result.add(String.valueOf(prevValue));
                result.add(String.valueOf(nextValue));
                break;
            }

            prevValue = nextValue;
        }

        System.out.println(String.join(" ", result));
    }
}
