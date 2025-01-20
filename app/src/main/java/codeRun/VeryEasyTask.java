package codeRun;

import java.io.*;

public class VeryEasyTask {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]) - 1, x = Integer.parseInt(parts[1]), y = Integer.parseInt(parts[2]);
        int min = 0;
        int max = Math.max(x, y) * n;
        int result = max;

        while (min <= max) {
            int m = (max + min) / 2;
            if (check(m, n, x, y)) {
                result = m;
                max = m - 1;
            } else {
                min = m + 1;
            }
        }

        writer.write(String.valueOf(result + Math.min(x, y)));
        reader.close();
        writer.close();
    }

    private static boolean check(int seconds, int n, int x, int y) {
        return seconds / x + seconds / y >= n;
    }
}
