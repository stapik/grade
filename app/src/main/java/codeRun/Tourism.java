package codeRun;

import java.io.*;

public class Tourism {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int pointCount = Integer.parseInt(reader.readLine());
        int[][] pointsArr = new int[pointCount][2];
        String[] temp;

        for (int i = 0; i < pointCount; i++) {
            temp = reader.readLine().split(" ");
            pointsArr[i][0] = Integer.parseInt(temp[0]);
            pointsArr[i][1] = Integer.parseInt(temp[1]);
        }

        int[] prefixSumUp = new int[pointCount];
        for (int i = 1; i < pointCount; i++) {
            int diff = Math.max(pointsArr[i][1] - pointsArr[i - 1][1], 0);
            prefixSumUp[i] = prefixSumUp[i - 1] + diff;
        }

        int[] prefixSumDown = new int[pointCount];
        for (int i = pointCount - 2; i >= 0; i--) {
            int diff = Math.max(pointsArr[i][1] - pointsArr[i + 1][1], 0);
            prefixSumDown[i] = prefixSumDown[i + 1] + diff;
        }

        int trackCount = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < trackCount; i++) {
            temp = reader.readLine().split(" ");
            int firstIdx = Integer.parseInt(temp[0]) - 1;
            int secondIdx = Integer.parseInt(temp[1]) - 1;

            int distance;
            if (firstIdx < secondIdx) {
                distance = prefixSumUp[secondIdx] - prefixSumUp[firstIdx];
            } else {
                distance = prefixSumDown[secondIdx] - prefixSumDown[firstIdx];
            }
            result.append(distance).append("\n");
        }

        // Вывод результата
        writer.write(result.toString());
        reader.close();
        writer.close();
    }
}
