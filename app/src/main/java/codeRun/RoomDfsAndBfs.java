package codeRun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class RoomDfsAndBfs {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();

        char[][] labyrinth = new char[n][n];
        for (int i = 0; i < n; i++) {
            labyrinth[i] = sc.next().toCharArray();
        }
        int x = sc.nextInt() - 1, y = sc.nextInt() - 1;

        boolean[][] visited = new boolean[n][n];
        List<Boolean> visitedList = new ArrayList<>();

        bfsStack(labyrinth, visited, x, y, visitedList);

        //
        writer.write(String.valueOf(visitedList.size()));

        writer.close();
        sc.close();
    }

    private static void bfsStack(char[][] labyrinth, boolean[][] visited, int row, int col, List<Boolean> visitedList) {
        Deque<int[]> stack = new LinkedList<>();
        stack.offer(new int[]{row, col});

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int curRow = cell[0], curCol = cell[1];
            if (curRow < 0 || curRow >= labyrinth.length || curCol < 0 || curCol >= labyrinth[0].length
                    || visited[curRow][curCol] || labyrinth[curRow][curCol] == '*') {
                continue;
            }
            visited[curRow][col] = true;
            visitedList.add(true);

            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : dirs) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                stack.offer(new int[]{newRow, newCol});
            }
        }
    }

    private static void dfsStack(char[][] labyrinth, boolean[][] visited, int row, int col, List<Boolean> visitedList) {
        Deque<Integer> stackRow = new LinkedList<>();
        Deque<Integer> stackCol = new LinkedList<>();
        stackRow.push(row);
        stackCol.push(col);

        while (!stackRow.isEmpty()) {
            int curRow = stackRow.pop();
            int curCol = stackCol.pop();
            if (curRow < 0 || curRow >= labyrinth.length || curCol < 0 || curCol >= labyrinth[0].length
                    || visited[curRow][curCol] || labyrinth[curRow][curCol] == '*') {
                continue;
            }
            visited[curRow][col] = true;
            visitedList.add(true);

            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : dirs) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                stackRow.push(newRow);
                stackCol.push(newCol);
            }
        }
    }

    private static void dfsRecursion(char[][] labyrinth, boolean[][] visited, int row, int col, List<Boolean> visitedList) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        visitedList.add(true);
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < labyrinth.length && newCol >= 0 && newCol < labyrinth.length && labyrinth[newRow][newCol] != '*') {
                dfsRecursion(labyrinth, visited, newRow, newCol, visitedList);
            }
        }
    }
}
