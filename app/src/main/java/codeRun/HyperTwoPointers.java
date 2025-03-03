package codeRun;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class HyperTwoPointers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long k = Long.parseLong(input[1]);
        long[] xArr = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();
        long result = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // Сдвигаем левый указатель, чтобы удовлетворить условие xArr[right] <= xArr[left] * k
            while (xArr[right] > xArr[left] * k) {
                left++;
            }

            // Количество чисел в текущем диапазоне
            int count = right - left + 1;

            // Если чисел достаточно для формирования тройки
            if (count >= 3) {
                // Количество троек: C(count, 3) = count * (count - 1) * (count - 2) / 6
                result += (long) (count / 3 + count % 3) * 3;
                // TODO: ???
            }
        }

        writer.write(String.valueOf(result));
        reader.close();
        writer.close();
    }
}
