package codeRun;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TreesTwoPointers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nAndK = reader.readLine().split(" ");
        int n = Integer.parseInt(nAndK[0]);
        int k = Integer.parseInt(nAndK[1]);
        String[] numsStr = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        int resultLeftIdx = 0, resultRightIdx = 0;
        int leftIdx = 0, rightIdx = 0, minDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        while (rightIdx < n) {
            int rightInt = nums[rightIdx];
            map.compute(rightInt, (key, v) -> v == null ? 1 : v + 1);

            if (map.keySet().size() == k) {
                int total = map.values().stream().reduce(Integer::sum).orElse(0);
                while (map.keySet().size() == k) {
                    if (total < minDistance) {
                        minDistance = total;
                        resultLeftIdx = leftIdx;
                        resultRightIdx = rightIdx;
                    }
                    int leftInt = nums[leftIdx];
                    map.compute(leftInt, (key, v) -> v == null ? 0 : v - 1);
                    if (map.get(leftInt) == 0) {
                        map.remove(leftInt);
                    }
                    leftIdx++;
                    total--;
                }
            }

            rightIdx++;
        }

        writer.write((resultLeftIdx + 1) + " " + (resultRightIdx + 1));
        reader.close();
        writer.close();
    }
}
