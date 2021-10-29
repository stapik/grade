package yandex.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HousesAndShops {

    private static String[] readInputValues() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        return str.split(" ");
    }

    public static void main(String[] args) throws IOException {
        String[] arr = readInputValues();
        Map<Integer, Integer> houseShopMap = new HashMap<>();
        int lastShopIdx = -1, houseType;

        for (int i = 0; i < arr.length; i++) {
            houseType = Integer.parseInt(arr[i]);
            // house
            if (houseType == 1 && lastShopIdx > -1) {
                houseShopMap.put(i, i - lastShopIdx);
            }
            // shop
            if (houseType == 2) {
                lastShopIdx = i;
            }
        }

        lastShopIdx = -1;
        for (int i = arr.length - 1; i > -1; i--) {
            houseType = Integer.parseInt(arr[i]);
            // house
            if (houseType == 1 && lastShopIdx > -1) {
                houseShopMap.merge(i, lastShopIdx - i, Math::min);
            }
            // shop
            if (houseType == 2) {
                lastShopIdx = i;
            }
        }

        System.out.println(Collections.max(houseShopMap.values()));
    }
}
