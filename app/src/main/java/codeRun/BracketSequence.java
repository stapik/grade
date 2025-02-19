package codeRun;

import java.io.*;
import java.util.*;

public class BracketSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = reader.readLine().toCharArray();
        String result = "yes";
        List<Character> openChars = List.of('(', '{', '[');
        List<Character> closeChars = List.of(')', '}', ']');
        Deque<Character> q = new ArrayDeque<>();

        for (char aChar : chars) {
            int openIdx = openChars.indexOf(aChar);
            int closeIdx = closeChars.indexOf(aChar);

            if (q.isEmpty() && closeIdx != -1) {
                result = "no";
                break;
            }

            if (openIdx != -1) {
                q.push(aChar);
            }
            if (closeIdx != -1) {
                if (!q.isEmpty() && closeIdx != openChars.indexOf(q.peek())) {
                    result = "no";
                    break;
                } else {
                    q.pop();
                }
            }
        }

        if(chars.length == 1 || !q.isEmpty()){
            result = "no";
        }

        writer.write(result);

        reader.close();
        writer.close();
    }
}
