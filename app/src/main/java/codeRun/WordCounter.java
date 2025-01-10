package codeRun;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class WordCounter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> words = new HashSet<>();
        String line;
        char space = " ".charAt(0);

        while ((line = reader.readLine()) != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character c : line.toCharArray()) {
                if (c.equals(space)) {
                    if (stringBuilder.length() > 0) {
                        words.add(stringBuilder.toString());
                        stringBuilder.setLength(0);
                    }
                    continue;
                }
                stringBuilder.append(c);
            }
            if (stringBuilder.length() > 0) {
                words.add(stringBuilder.toString());
            }
        }

        writer.write(String.valueOf(words.size()));

        reader.close();
        writer.close();
    }
}
