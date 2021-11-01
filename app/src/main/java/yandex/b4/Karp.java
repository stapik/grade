package yandex.b4;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Karp {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int count = inp.nextInt();
        Map<Long, Long> result = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            result.merge(inp.nextLong(), inp.nextLong(), Long::sum);
        }

        result.forEach((key, value) -> System.out.println(key + " " + value));
        inp.close();
    }
}
