package codeRun;

import java.io.*;
import java.util.Arrays;

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
        prefixSumUp[0] = 0;
        int diff;
        for (int i = 1; i < pointsArr.length; i++) {
            diff = Math.max(pointsArr[i][1] - pointsArr[i - 1][1], 0);
            prefixSumUp[i] = prefixSumUp[i - 1] + diff;
        }

        int[] prefixSumDown = new int[pointCount];
        prefixSumDown[pointCount - 1] = 0;
        for (int i = pointsArr.length - 2; i > 0; i--) {
            diff = Math.max(pointsArr[i][1] - pointsArr[i + 1][1], 0);
            prefixSumDown[i] = prefixSumDown[i + 1] + diff;
        }

        int trackCount = Integer.parseInt(reader.readLine());
        int firstIdx, secondIdx;
        int distance;
        int[] result = new int[trackCount];
        for (int i = 0; i < trackCount; i++) {
            temp = reader.readLine().split(" ");
            firstIdx = Integer.parseInt(temp[0]) - 1;
            secondIdx = Integer.parseInt(temp[1]) - 1;

            if (firstIdx < secondIdx) {
                distance = prefixSumUp[secondIdx] - prefixSumUp[firstIdx];
            } else {
                distance = prefixSumDown[secondIdx] - prefixSumDown[firstIdx];
            }
            result[i] = distance;
        }
        String[] resultStrArr = Arrays.toString(result).split("[\\[\\]]")[1].split(", ");
        writer.write(String.join("\n", resultStrArr));

        reader.close();
        writer.close();
    }
}
