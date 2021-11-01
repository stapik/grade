package yandex.b4;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class Elections {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String v;
        Map<String, Integer> result = new TreeMap<>();
        while (inp.hasNext()) {
            v = inp.next();
            if (Objects.equals(v, "")) {
                return;
            }
            result.merge(v, inp.nextInt(), Integer::sum);
        }

        result.forEach((key, value) -> System.out.println(key + " " + value));
        inp.close();
    }
}
