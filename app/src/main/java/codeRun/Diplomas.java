package codeRun;

import java.io.*;

public class Diplomas {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = reader.readLine().split(" ");
        long w = Integer.parseInt(parts[0]), h = Integer.parseInt(parts[1]), n = Integer.parseInt(parts[2]);
        long minSide = Math.max(w, h);
        long maxSide = (long) Math.ceil((Math.sqrt(n))) * Math.max(w, h);
        long result = maxSide;

        while (minSide <= maxSide) {
            long mid = (minSide + maxSide) / 2;
            if (check(mid, w, h, n)) {
                result = mid;
                maxSide = mid - 1;
            } else {
                minSide = mid + 1;
            }
        }

        writer.write(String.valueOf(result));
        reader.close();
        writer.close();
    }

    private static boolean check(long size, long w, long h, long n) {
        long rows = size / w;
        long cols = size / h;
        return rows * cols >= n;
    }
}
