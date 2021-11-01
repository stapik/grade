package x5;

import java.util.*;

public class Salary {

    public static int getResult(List<Integer> cash, int s) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Map.Entry<Integer, Integer> entry;
        cash.forEach(v -> map.merge(v, 1, Integer::sum));
        int count, key, value, div;

        while (s > 0) {
            entry = map.firstEntry();
            key = entry.getKey();
            value = entry.getValue();
            if (value > 1) {
                value -= 1;
                map.put(key, value);
            } else {
                map.pollFirstEntry();
            }
            div = s % 3;
            count = div == 0 ? 3 : div;
            key += count;
            s -= count;
            map.merge(key, 1, Integer::sum);
        }
        return map.entrySet().stream().limit(map.size() - 1).map(Map.Entry::getValue).reduce(Integer::sum).orElse(0);
    }
}
