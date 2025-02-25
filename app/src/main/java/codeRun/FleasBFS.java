package codeRun;

import java.io.*;
import java.util.Arrays;
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

        int sum = 0;
        int[][] fieldDistances = bfsFieldDistances(n, m, s, t);
        for (int[] flea : fleas) {
            if (fieldDistances[flea[0]][flea[1]] == -1) {
                sum = -1;
                break;
            }
            sum += fieldDistances[flea[0]][flea[1]];
        }

        writer.write(String.valueOf(sum));

        writer.close();
        reader.close();
    }

    private static int[][] bfsFieldDistances(int n, int m, int s, int t) {
        int[][] fieldDistances = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(fieldDistances[i], -1);
        }
        int[][] moves = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, t});
        visited[s][t] = true;
        fieldDistances[s][t] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] move : moves) {
                int newX = x + move[0];
                int newY = y + move[1];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
                    q.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    fieldDistances[newX][newY] = fieldDistances[x][y] + 1;
                }
            }
        }

        return fieldDistances;
    }
}
