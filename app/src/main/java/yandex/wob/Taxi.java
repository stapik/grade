package yandex.wob;

import java.util.*;

public class Taxi {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int rows = inp.nextInt(), prevValue, curValue;
        List<Integer> rating = new ArrayList<>();
        Map<Integer, Integer> sumMap = new HashMap<>();
        while (rows != 0) {
            rating.add(inp.nextInt());
            rows--;
        }

        // to right
        for (int i = 0; i < rating.size(); i++) {
            curValue = rating.get(i);
            prevValue = rating.get(i - 1 >= 0 ? i - 1 : i);
            if (prevValue < curValue) {
                sumMap.put(i, sumMap.get(i - 1) + 500);
            } else {
                sumMap.put(i, 500);
            }
        }

        // to left
        for (int i = rating.size() - 1; i >= 0; i--) {
            curValue = rating.get(i);
            prevValue = rating.get(i + 1 < rating.size() - 1 ? i + 1 : i);
            if (prevValue < curValue) {
                sumMap.put(i, sumMap.get(i + 1) + 500);
            }
        }

        System.out.println(sumMap.values().stream().reduce(Integer::sum).orElse(0));
        inp.close();
    }
}
