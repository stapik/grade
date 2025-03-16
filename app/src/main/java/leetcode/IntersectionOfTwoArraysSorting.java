package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArraysSorting {

    public static void main(String[] args) {
        System.out.printf(
                Arrays.toString(
                        intersect(
                                new int[]{1, 2, 2, 1},
                                new int[]{2, 2})
                )
        );
        System.out.printf(
                Arrays.toString(
                        intersect(
                                new int[]{4, 9, 5},
                                new int[]{9, 4, 9, 8, 4})
                )
        );
    }

    private static int[] intersect(int[] a, int[] b) {
        quickSort(a, 0, a.length - 1);
        quickSort(b, 0, b.length - 1);
        int aIdx = 0, bIdx = 0;
        Set<Integer> set = new HashSet<>();

        while (a.length - 1 >= aIdx && b.length - 1 >= bIdx) {
            if (a[aIdx] == b[bIdx]) {
                set.add(a[aIdx]);
                aIdx++;
                bIdx++;
            } else if (a[aIdx] > b[bIdx]) {
                bIdx++;
            } else {
                aIdx++;
            }
        }

        return set.stream().mapToInt(i -> i).toArray();
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(j, i, arr);
            }
        }
        swap(right, i + 1, arr);
        return i + 1;
    }

    private static void swap(int from, int to, int[] arr) {
        int temp = arr[to];
        arr[to] = arr[from];
        arr[from] = temp;
    }
}
