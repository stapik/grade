package codeRun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Type {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> sequence = new ArrayList<>();
        final int END_MARKER = -2_000_000_000;

        while (true) {
            int num = Integer.parseInt(reader.readLine());
            if (num == END_MARKER) break;
            sequence.add(num);
        }

        if (sequence.size() < 2) {
            writer.write("CONSTANT");
            return;
        }

        boolean isConstant = true;
        boolean isAscending = true;
        boolean isWeaklyAscending = true;
        boolean isDescending = true;
        boolean isWeaklyDescending = true;

        for (int i = 1; i < sequence.size(); i++) {
            int prev = sequence.get(i - 1);
            int curr = sequence.get(i);

            if (curr != prev) isConstant = false;
            if (curr <= prev) isAscending = false;
            if (curr < prev) isWeaklyAscending = false;
            if (curr >= prev) isDescending = false;
            if (curr > prev) isWeaklyDescending = false;
        }

        if (isConstant) {
            writer.write("CONSTANT");
        } else if (isAscending) {
            writer.write("ASCENDING");
        } else if (isWeaklyAscending) {
            writer.write("WEAKLY ASCENDING");
        } else if (isDescending) {
            writer.write("DESCENDING");
        } else if (isWeaklyDescending) {
            writer.write("WEAKLY DESCENDING");
        } else {
            writer.write("RANDOM");
        }
        writer.close();
        reader.close();
    }
}
