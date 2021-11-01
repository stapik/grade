package yandex.b4;

import java.util.*;

public class FrequencyAnalysis {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Map<String, Integer> result = new HashMap<>();

        while (inp.hasNext()) {
            result.merge(inp.next(), 1, Integer::sum);
        }

        result.entrySet().stream().sorted(((o1, o2) -> {
            int c1 = o1.getValue(), c2 = o2.getValue();
            if (c1 != c2) {
                return c1 < c2 ? 1 : -1;
            }
            return o1.getKey().compareTo(o2.getKey());
        })).forEach(item -> System.out.println(item.getKey()));
        inp.close();
    }
}