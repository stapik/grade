package codeRun;

import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;

public class Sets {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts1 = reader.readLine().split(" ");
        String[] parts2 = reader.readLine().split(" ");

        int[] nums1 = new int[parts1.length];
        for (int i = 0; i < parts1.length; i++) {
            nums1[i] = Integer.parseInt(parts1[i]);
        }
        Arrays.sort(nums1);

        int[] nums2 = new int[parts2.length];
        for (int i = 0; i < parts2.length; i++) {
            nums2[i] = Integer.parseInt(parts2[i]);
        }
        Arrays.sort(nums2);

        StringJoiner result = new StringJoiner(" ");

        int nums1idx = 0;
        int nums2idx = 0;
        while (nums1idx < nums1.length && nums2idx < nums2.length) {
            if (nums1[nums1idx] == nums2[nums2idx]) {
                result.add(String.valueOf(nums1[nums1idx]));
                nums1idx++;
                nums2idx++;
                continue;
            }

            if (nums1[nums1idx] > nums2[nums2idx]) {
                nums2idx++;
                continue;
            }

            if (nums1[nums1idx] < nums2[nums2idx]) {
                nums1idx++;
            }
        }

        writer.write(result.toString());

        reader.close();
        writer.close();
    }
}
