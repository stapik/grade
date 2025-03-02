package codeRun;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GoodRowTwoPointers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(reader.readLine());
        char[] chars = reader.readLine().toCharArray();
        int n = chars.length, max = 0, topCharCount = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char rightChar = chars[right];
            map.compute(rightChar, (key, v) -> v == null ? 1 : v + 1);
            topCharCount = Math.max(topCharCount, map.get(rightChar));

            while (right - left + 1 > topCharCount + k) {
                char leftChar = chars[left];
                map.compute(leftChar, (key, v) -> v == null ? 0 : v - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }


        writer.write(String.valueOf(max));
        reader.close();
        writer.close();
    }
}
