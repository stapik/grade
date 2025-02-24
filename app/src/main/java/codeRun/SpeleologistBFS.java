package codeRun;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpeleologistBFS {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String input;
        char[] chars;
        List<List<List<Integer>>> cube = new ArrayList<>();
        int block = 0, row = 0, col = 0;

        for (int i = 0; i < n; i++) {
            reader.readLine();
            cube.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                cube.get(i).add(new ArrayList<>());
                input = reader.readLine();
                chars = input.toCharArray();
                for (int k = 0; k < n; k++) {
                    int value;
                    if (chars[k] == '#') {
                        value = -1;
                    } else if (chars[k] == '.') {
                        value = 0;
                    } else {
                        block = i;
                        row = j;
                        col = k;
                        value = 1;
                    }
                    cube.get(i).get(j).add(value);
                }
            }
        }

        writer.write(String.valueOf(bfs(cube, block, row, col)));

        reader.close();
        writer.close();
    }

    private static int bfs(List<List<List<Integer>>> cube, int block, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[cube.size()][cube.size()][cube.size()];
        int[][][] counter = new int[cube.size()][cube.size()][cube.size()];
        int[][] moves = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

        queue.add(new int[]{block, row, col});
        visited[block][row][col] = true;
        counter[block][row][col] = 0;

        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            int parentCount = counter[parent[0]][parent[1]][parent[2]];

            for (int[] move : moves) {
                int newBlock = parent[0] + move[0];
                int newRow = parent[1] + move[1];
                int newCol = parent[2] + move[2];
                if (newBlock < 0 || newBlock >= cube.size()
                        || newRow < 0 || newRow >= cube.size()
                        || newCol < 0 || newCol >= cube.size()) {
                    continue;
                }
                if (visited[newBlock][newRow][newCol]) {
                    continue;
                }
                if (cube.get(newBlock).get(newRow).get(newCol) == -1) {
                    continue;
                }
                queue.add(new int[]{newBlock, newRow, newCol});
                visited[newBlock][newRow][newCol] = true;
                counter[newBlock][newRow][newCol] = parentCount + 1;

                if (newBlock == 0) {
                    return counter[newBlock][newRow][newCol];
                }
            }
        }
        return 0;
    }
}
