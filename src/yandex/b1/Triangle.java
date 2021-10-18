package yandex.b1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        double d = myInput.nextDouble(), pX = myInput.nextDouble(), pY = myInput.nextDouble();
        Map<Integer, Double> map = new HashMap<>();

        if (pX >= 0 && pY >= 0 && pX + pY <= d) {
            System.out.println(0);
        } else {
            map.put(1, Math.pow(pX, 2) + Math.pow(pY, 2));
            map.put(2, Math.pow(pX - d, 2) + Math.pow(pY, 2));
            map.put(3, Math.pow(pX, 2) + Math.pow(pY - d, 2));
            System.out.println(getKeyWithMinValue(map));
        }
    }

    private static Integer getKeyWithMinValue(Map<Integer, Double> map) {
        Map.Entry<Integer, Double> min = null;
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            if (min == null || min.getValue() > entry.getValue()) {
                min = entry;
            }
        }

        assert min != null;
        return min.getKey();
    }
}
