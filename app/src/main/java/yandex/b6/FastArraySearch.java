package yandex.b6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FastArraySearch {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt(), leftIdx, rightIdx;
        List<Integer> arr = new ArrayList<>();
        List<String> result = new ArrayList<>();

        while (n != 0) {
            arr.add(inp.nextInt());
            n--;
        }
        Collections.sort(arr);

        int countRequests = inp.nextInt();
        while (countRequests > 0) {
            int leftBorder = inp.nextInt();
            int rightBorder = inp.nextInt();
            leftIdx = lBinSearch(0, arr.size() - 1, (index) -> index < arr.size() && arr.get(index) >= leftBorder);
            rightIdx = rBinSearch(leftIdx, arr.size() - 1, (index) -> index < arr.size() && arr.get(index) <= rightBorder);

            if (leftIdx == rightIdx && !(arr.get(leftIdx) >= leftBorder && arr.get(leftIdx) <= rightBorder)) {
                result.add("0");
            } else {
                result.add(String.valueOf(rightIdx - leftIdx + 1));
            }

            countRequests--;
        }

        System.out.println(String.join(" ", result));
        inp.close();
    }

    private static Integer lBinSearch(int l, int r, Predicate<Integer> checker) {
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (checker.test(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private static Integer rBinSearch(int l, int r, Predicate<Integer> checker) {
        int m;
        while (l < r) {
            m = (l + r + 1) / 2;
            if (checker.test(m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
