package codeRun;

import java.io.*;

public class OnlyUp {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = reader.readLine().split(" ");
        String result = "YES";
        long v = Long.parseLong(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            if (v < Long.parseLong(parts[i])) {
                v = Long.parseLong(parts[i]);
            } else {
                result = "NO";
                break;
            }
        }

        writer.write(result);

        reader.close();
        writer.close();
    }
}
