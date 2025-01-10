package codeRun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Vasily {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(reader.readLine());
        int[] results = new int[total];
        String[] resultsStr = reader.readLine().split(" ");

        for (int i = 0; i < total; i++) {
            results[i] = Integer.parseInt(resultsStr[i]);
        }
        List<Integer> vasilyList = new ArrayList<>();
        int winnerIdx = 0;
        int winnerDistance = results[0];
        for (int i = 1; i < total - 1; i++) {
            if(winnerDistance < results[i]){
                winnerDistance = results[i];
                winnerIdx = i;
                continue;
            }
            if (results[i] % 10 == 5 && results[i + 1] < results[i] && results[i] <= winnerDistance) {
                vasilyList.add(i);
            }
        }

        String answer = "0";
        if (!vasilyList.isEmpty()) {
            int vasilyScore = 0;
            for (int idx: vasilyList){
                if(idx > winnerIdx){
                    vasilyScore = Math.max(results[idx], vasilyScore);
                }
            }
            int place = 1;
            for (int i = 0; i < total; i++) {
                if (results[i] > vasilyScore) {
                    place++;
                }
            }
            answer = String.valueOf(place);
        }

        writer.write(answer);
        reader.close();
        writer.close();
    }
}
