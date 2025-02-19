package codeRun;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class BracketSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = reader.readLine().toCharArray();
        String result = "yes";
        Map<Character, Character> bracketMap = Map.of(')', '(', ']', '[', '}', '{');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (bracketMap.containsValue(c)) {
                stack.push(c);
            } else if (bracketMap.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != bracketMap.get(c)) {
                    result = "no";
                    break;
                }
            }
        }

        if(!stack.isEmpty()){
            result = "no";
        }

        writer.write(result);

        reader.close();
        writer.close();
    }
}
