package codeRun;

import java.io.*;
import java.util.*;

public class ShortestPathBFS {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine().trim());
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        String[] parts = reader.readLine().trim().split("\\s+");
        int start = Integer.parseInt(parts[0]) - 1;
        int end = Integer.parseInt(parts[1]) - 1;

        if (start == end) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(graph, start, end, n));
    }

    private static int bfs(int[][] graph, int start, int end, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, -1);

        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph[current][neighbor] == 1 && distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);

                    if (neighbor == end) {
                        return distance[neighbor];
                    }
                }
            }
        }
        return -1;
    }
}
