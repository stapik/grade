package codeRun;

import java.io.*;
import java.util.*;

public class MetroBFS {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine()), m = Integer.parseInt(reader.readLine());
        List<List<Integer>> lineStations = new ArrayList<>(n);
        List<List<Integer>> stationLines = new ArrayList<>(m + 1);

        for (int i = 0; i < n + 1; i++) {
            stationLines.add(new ArrayList<>());
        }
        StringTokenizer tokenizer;
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int p = Integer.parseInt(tokenizer.nextToken());
            lineStations.add(i, new ArrayList<>());
            for (int j = 0; j < p; j++) {
                int station = Integer.parseInt(tokenizer.nextToken());
                lineStations.get(i).add(station);
                stationLines.get(station).add(i);
            }
        }
        tokenizer = new StringTokenizer(reader.readLine());
        int from = Integer.parseInt(tokenizer.nextToken());
        int to = Integer.parseInt(tokenizer.nextToken());

        writer.write(String.valueOf(bfs(lineStations, stationLines, from, to)));

        reader.close();
        writer.close();
    }

    private static int bfs(List<List<Integer>> lineStations, List<List<Integer>> stationLines, int from, int to) {
        if (from == to) return 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedLines = new HashSet<>();
        Set<Integer> visitedStations = new HashSet<>();

        for (int line : stationLines.get(from)) {
            queue.add(line);
            visitedLines.add(line);
        }

        int transfers = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int line = queue.poll();

                for (int station : lineStations.get(line)) {
                    if (station == to) {
                        return transfers;
                    }
                    if (!visitedStations.contains(station)) {
                        visitedStations.add(station);
                        for (int nextLine : stationLines.get(station)) {
                            if (!visitedLines.contains(nextLine)) {
                                queue.add(nextLine);
                                visitedLines.add(nextLine);
                            }
                        }
                    }
                }
            }
            transfers++;
        }

        return -1;
    }
}
