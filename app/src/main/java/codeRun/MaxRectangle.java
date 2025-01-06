package codeRun;

import java.io.*;
import java.util.Arrays;

public class MaxRectangle {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(reader.readLine());
        Integer[] temp;
        Integer x1 = null, y1 = null, x2 = null, y2 = null;
        for (int i = 0; i < total; i++) {
            temp = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            if (x1 == null) {
                x1 = temp[0];
                y1 = temp[1];
            }
            x1 = x1 > temp[0] ? temp[0] : x1;
            y1 = y1 > temp[1] ? temp[1] : y1;

            if (x2 == null) {
                x2 = temp[0];
                y2 = temp[1];
            }
            x2 = x2 < temp[0] ? temp[0] : x2;
            y2 = y2 < temp[1] ? temp[1] : y2;
        }

        writer.write(String.format("%s %s %s %s", x1, y1, x2, y2));

        reader.close();
        writer.close();
    }
}
