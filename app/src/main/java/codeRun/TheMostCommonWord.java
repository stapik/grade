package codeRun;

import java.io.*;
import java.util.*;

public class TheMostCommonWord {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        Map<String, Integer> wordCount = new HashMap<>();
        while ((line = reader.readLine()) != null) {
            for (String word : line.split(" ")) {
                wordCount.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
            }
        }

        int maxCount = 0;
        Set<String> resultWords = new HashSet<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (maxCount < entry.getValue()) {
                maxCount = entry.getValue();
                resultWords.clear();
                resultWords.add(entry.getKey());
            }
            if (maxCount == entry.getValue()) {
                resultWords.add(entry.getKey());
            }
        }
        String[] resultArr = resultWords.toArray(new String[]{});
        Arrays.sort(resultArr);

        writer.write(resultArr[0]);
        reader.close();
        writer.close();
    }
}
