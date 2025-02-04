package codeRun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class FirstPeakDFS {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            reverseGraph.get(to).add(from);
        }

        boolean[] visited = new boolean[n + 1];
        List<Integer> result = new ArrayList<>();
        dfs(1, reverseGraph, visited);

        for (int i = 0; i < n + 1; i++) {
            if (visited[i]) {
                result.add(i);
            }
        }

        Collections.sort(result);
        StringJoiner sj = new StringJoiner(" ");
        for (int value : result) {
            sj.add(String.valueOf(value));
        }

        writer.write(sj.toString());
        writer.close();
    }

    private static void dfs(int v, List<List<Integer>> reverseGraph, boolean[] visited) {
        visited[v] = true;
        for (int next : reverseGraph.get(v)) {
            if (!visited[next]) {
                dfs(next, reverseGraph, visited);
            }
        }
    }
}
