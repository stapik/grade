package codeRun;

import java.io.*;

public class CheCity {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        long n = Integer.parseInt(parts[0]), r = Integer.parseInt(parts[1]);
        String[] parts2 = reader.readLine().split(" ");
        long[] monuments = new long[parts2.length];
        for(int i=0; i < parts2.length; i++){
            monuments[i] = Integer.parseInt(parts2[i]);
        }
        long i = 0, j = 1, count = 0;

        while (j < monuments.length && i < monuments.length - 1) {
            long rightInt = monuments[(int) j];
            long leftInt = monuments[(int) i];
            if (rightInt - leftInt <= r) {
                j++;
            } else {
                count += n - j;
                i++;
            }
        }

        writer.write(String.valueOf(count));

        reader.close();
        writer.close();
    }
}
