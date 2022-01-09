package sberfight;

import java.util.*;
import java.util.stream.IntStream;

public class Passers {

    public static void main(String[] args) {
        System.out.println(getResult(Arrays.asList(3, 10, 4, 8))); // 11
        System.out.println(getResult(Arrays.asList(5, 12, 6))); // 7
    }

    public static int getResult(List<Integer> passersby) {
        int result = 0;
        TreeMap<Integer, Integer> passersMap = new TreeMap<>();
        Map.Entry<Integer, Integer> rich, poor;
        IntStream.range(0, passersby.size()).forEach(i -> passersMap.merge(passersby.get(i), 1, Integer::sum));

        while (true) {
            if (passersMap.size() == 1) {
                break;
            }
            rich = passersMap.pollLastEntry();

            if (rich.getValue() > 1) {
                passersMap.put(rich.getKey(), rich.getValue() - 1);
            }
            result += rich.getKey();

            poor = passersMap.pollFirstEntry();
            if (poor.getValue() > 1) {
                passersMap.put(poor.getKey(), poor.getValue() - 1);
            }
            result -= poor.getKey();

            if (passersMap.size() == 0) {
                break;
            }
        }

        return result;
    }
}