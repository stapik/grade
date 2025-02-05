package codeRun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class ConnectedComponentsDFS {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(to).add(from);
            graph.get(from).add(to);
        }

        boolean[] visited = new boolean[n + 1];
        Set<Integer> result = new TreeSet<>();
        dfs(1, graph, visited);

        for (int i = 0; i < n + 1; i++) {
            if (visited[i]) {
                result.add(i);
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        result.forEach(x -> sj.add(x.toString()));

        writer.write(result.size() + "\n");
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
