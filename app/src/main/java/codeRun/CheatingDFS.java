package codeRun;

import java.io.*;
import java.util.*;

public class CheatingDFS {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            int from = Integer.parseInt(input[0]), to = Integer.parseInt(input[1]);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        boolean[] visited = new boolean[graph.size()];
        String result = "YES";
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i] && dsf(i, graph, visited).equals("NO")) {
                result = "NO";
                break;
            }
        }
        writer.write(result);
        reader.close();
        writer.close();
    }


    private static String dsf(int from, List<List<Integer>> graph, boolean[] visited) {
        String ans = "YES";
        Deque<Integer> stack = new ArrayDeque<>();
        int[] groups = new int[graph.size() + 1];

        stack.push(from);
        groups[from] = 1;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = true;

            for (Integer neighbor : graph.get(current)) {
                if (groups[neighbor] == 0) {
                    groups[neighbor] = -groups[current];
                    stack.push(neighbor);
                } else if (groups[neighbor] == groups[current]) {
                    ans = "NO";
                    break;
                }
            }

            if (ans.equals("NO")) {
                break;
            }
        }

        return ans;
    }
}
