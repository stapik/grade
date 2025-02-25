package codeRun;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class FleasBFS {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = reader.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        int s = Integer.parseInt(inputArr[2]) - 1;
        int t = Integer.parseInt(inputArr[3]) - 1;
        int q = Integer.parseInt(inputArr[4]);
        int[][] fleas = new int[q][2];

        for (int i = 0; i < q; i++) {
            inputArr = reader.readLine().split(" ");
            fleas[i][0] = Integer.parseInt(inputArr[0]) - 1;
            fleas[i][1] = Integer.parseInt(inputArr[1]) - 1;
        }

        int sum = 0, temp;
        for (int[] flea : fleas) {
            temp = bfs(flea, n, m, s, t);
            if (temp == -1) {
                sum = -1;
                break;
            }
            sum += temp;
        }

        writer.write(String.valueOf(sum));

        writer.close();
        reader.close();
    }

    private static int bfs(final int[] start, int n, int m, int s, int t) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        int[][] moves = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        queue.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == s && cur[1] == t) {
                return distance[cur[0]][cur[1]];
            }

            for (int[] move : moves) {
                int newX = cur[0] + move[0];
                int newY = cur[1] + move[1];

                if (newX < 0 || !(newX < n) || newY < 0 || !(newY < m)) {
                    continue;
                }
                if (visited[newX][newY]) {
                    continue;
                }
                queue.add(new int[]{newX, newY});
                visited[newX][newY] = true;
                distance[newX][newY] = distance[cur[0]][cur[1]] + 1;

            }
        }
        return -1;
    }
}
