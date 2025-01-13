package codeRun;

import java.io.*;
import java.util.*;

public class WordOccurrenceNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        Map<String, Integer> wordCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            if(line.equals("")){
                break;
            }
            for (String word : line.split(" ")) {
                wordCount.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
                result.add(wordCount.get(word) - 1);
            }
        }

        String[] resultStrArr = new String[result.size()];
        int i = 0;
        for(Integer count: result){
            resultStrArr[i] = String.valueOf(count);
            i++;
        }

        writer.write(String.join(" ", resultStrArr));

        reader.close();
        writer.close();
    }
}
