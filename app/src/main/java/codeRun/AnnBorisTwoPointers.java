package codeRun;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class AnnBorisTwoPointers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);

        int[] annNums = new int[n];
        for (int i = 0; i < n; i++) {
            annNums[i] = Integer.parseInt(reader.readLine());
        }
        int[] borNums = new int[m];
        for (int i = 0; i < m; i++) {
            borNums[i] = Integer.parseInt(reader.readLine());
        }

        Set<Integer> commonNums = new TreeSet<>();
        Arrays.sort(borNums);
        Arrays.sort(annNums);
        int a = 0, b = 0;
        while (a < n && b < m) {
            if (annNums[a] == borNums[b]) {
                commonNums.add(annNums[a]);
                a++;
                b++;
            } else if (annNums[a] > borNums[b]) {
                b++;
            } else {
                a++;
            }
        }

        StringJoiner sj = new StringJoiner("\n");
        sj.add(String.valueOf(commonNums.size()));
        sj.add(commonNums.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        sj.add(String.valueOf(n - commonNums.size()));
        sj.add(Arrays.stream(annNums).filter(num -> !commonNums.contains(num)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        sj.add(String.valueOf(m - commonNums.size()));
        sj.add(Arrays.stream(borNums).filter(num -> !commonNums.contains(num)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        writer.write(sj.toString());
        reader.close();
        writer.close();
    }
}
