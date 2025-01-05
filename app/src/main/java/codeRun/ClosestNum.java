package codeRun;

import java.io.*;
import java.util.Arrays;

public class ClosestNum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(reader.readLine());
        String[] parts = reader.readLine().split(" ");
        int x = Integer.parseInt(reader.readLine());
        int closestNum = Integer.parseInt(parts[0]);
        int lastDiff = Integer.MAX_VALUE;
        int temp;
        for (String part : parts) {
            temp = Integer.parseInt(part);
            if(Math.abs(x - temp) < lastDiff){
                lastDiff = Math.abs(x - temp);
                closestNum = temp;
            }
        }

        writer.write(closestNum + "");
        reader.close();
        writer.close();
    }
}
