package codeRun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ConnectedComponents2DFS {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            int from = Integer.parseInt(input[0]), to = Integer.parseInt(input[1]);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> components = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfsComponent(i, graph, visited, component);
                components.add(component);
            }
        }

        StringJoiner sj = new StringJoiner("\n");
        sj.add(String.valueOf(components.size()));
        for (List<Integer> component : components) {
            sj.add(String.valueOf(component.size()));
            sj.add(String.join(" ", component.stream().map(String::valueOf).toArray(String[]::new)));
        }

        writer.write(sj.toString());
        reader.close();
        writer.close();
    }

    private static void dfsComponent(int from, List<List<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[from] = true;
        component.add(from);

        for (Integer neighbor : graph.get(from)) {
            if (!visited[neighbor]) {
                dfsComponent(neighbor, graph, visited, component);
            }
        }
    }
}
