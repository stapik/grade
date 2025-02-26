package codeRun;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class HorsesBFS {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = reader.readLine().split(" ");
        Map<Character, Integer> charMap = Map.of('a', 0, 'b', 1, 'c', 2, 'd', 3, 'e', 4, 'f', 5, 'g', 6, 'h', 7);
        int[] first = new int[]{
                charMap.get(input[0].toCharArray()[0]),
                Character.getNumericValue(input[0].toCharArray()[1]) - 1
        };

        int[] second = new int[]{
                charMap.get(input[1].toCharArray()[0]),
                Character.getNumericValue(input[1].toCharArray()[1]) - 1
        };

        int[][] firstDistances = bfs(first);
        int[][] secondDistances = bfs(second);

        int result = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(firstDistances[i][j] == secondDistances[i][j]) {
                    result = result == -1 ? firstDistances[i][j] : Math.min(result, firstDistances[i][j]);
                }
            }
        }

        writer.write(String.valueOf(result));

        reader.close();
        writer.close();
    }

    private static int[][] bfs(int[] horse) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[8][8];
        int[][] distance = new int[8][8];
        int[][] moves = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        queue.add(horse);
        visited[horse[0]][horse[1]] = true;
        distance[horse[0]][horse[1]] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int[] move: moves) {
                int newX = curX + move[0];
                int newY = curY + move[1];

                if(newX < 0 || newX > 7 || newY < 0 || newY > 7 || visited[newX][newY]) {
                    continue;
                }
                queue.add(new int[]{newX, newY});
                visited[newX][newY] = true;
                distance[newX][newY] = distance[curX][curY] + 1;
            }
        }

        return distance;
    }
}
