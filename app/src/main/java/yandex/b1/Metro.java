package yandex.b1;

import java.io.*;

public class Metro {

    private static String[] readInputValues() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        return str.split(" ");
    }

    public static void main(String[] args) throws IOException {
        String[] input = readInputValues();
        int total = Integer.parseInt(input[0]), first = Integer.parseInt(input[1]), last = Integer.parseInt(input[2]);
        int firstDistance = Math.abs(first - last);
        int secondDistance = first < last ? first + total - last : last + total - first;
        System.out.println(Math.min(firstDistance, secondDistance) - 1);
    }
}
