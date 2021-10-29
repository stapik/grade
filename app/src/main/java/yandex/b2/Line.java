package yandex.b2;

import java.util.*;

public class Line {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int number;
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        while (inp.hasNext()) {
            number = inp.nextInt();
            map.merge(number, 1, Integer::sum);
            if (number == 0) {
                break;
            }
        }

        System.out.println(map.isEmpty() ? null : map.lastEntry().getValue());
        inp.close();
    }
}
