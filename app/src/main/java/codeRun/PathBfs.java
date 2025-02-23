package codeRun;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PathBfs {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        String[] input;
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(input[j]) == 0) {
                    continue;
                }
                graph.get(i).add(j);
                graph.get(j).add(i);
            }
        }
        input = reader.readLine().split(" ");
        int from = Integer.parseInt(input[0]) - 1, to = Integer.parseInt(input[1]) - 1;

        List<Integer> result = new ArrayList<>();
        boolean pathExists = bfs(graph, from, to, result);
        if (!pathExists) {
            writer.write("-1");
        } else if (result.isEmpty()) {
            writer.write("0");
        } else {
            writer.write((result.size() - 1) + "\n");
            writer.write(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }

        reader.close();
        writer.close();
    }

    private static boolean bfs(List<List<Integer>> graph, int from, int to, List<Integer> result) {
        if (from == to) {
            return true;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        Map<Integer, Integer> path = new HashMap<>();

        q.offer(from);
        visited[from] = true;

        while (!q.isEmpty()) {
            int parent = q.poll();

            if (parent == to) {
                break;
            }

            for (int child : graph.get(parent)) {
                if (visited[child]) {
                    continue;
                }
                visited[child] = true;
                path.put(child, parent);
                q.offer(child);
            }
        }

        if (!path.containsKey(to)) {
            return false;
        }

        int child = to;
        while (child != from) {
            result.add(child + 1);
            child = path.get(child);
        }
        result.add(from + 1);

        Collections.reverse(result);
        return true;
    }
}
