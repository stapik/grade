package codeRun;

import java.io.*;

public class Max {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = reader.readLine().split(" ");
        int current, prev, next;
        int result = 0;
        for(int i=1; i < parts.length - 1; i++) {
            current = Integer.parseInt(parts[i]);
            prev = Integer.parseInt(parts[i-1]);
            next = Integer.parseInt(parts[i+1]);
            if(current > prev && current > next){
                result++;
            }
        }

        writer.write(result + "");
        reader.close();
        writer.close();
    }
}
