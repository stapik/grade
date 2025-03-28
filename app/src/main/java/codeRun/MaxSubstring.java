package codeRun;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxSubstring {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        String line = reader.readLine();
        char[] chars = line.toCharArray();
        int resultLength = 0, startNumber = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int leftIdx = 0, rightIdx = 0;

        new ArrayList<Integer>().stream().max(Integer::compareTo).orElse(0);

        while (rightIdx < n) {
            char right = chars[rightIdx];
            charMap.compute(right, (key, value) -> value == null ? 1 : value + 1);
            boolean valid = charMap.get(right) <= k;

            if (valid) {
                int length = rightIdx - leftIdx + 1;
                if (length > resultLength) {
                    resultLength = length;
                    startNumber = leftIdx + 1;
                }
            }

            while (charMap.get(right) > k) {
                char left = chars[leftIdx];
                charMap.compute(left, (key, value) -> value == null ? 0 : value - 1);
                if (charMap.get(left) == 0) {
                    charMap.remove(left);
                }
                leftIdx++;
            }

            rightIdx++;
        }

        writer.write(resultLength + " " + startNumber);

        reader.close();
        writer.close();
    }
}
