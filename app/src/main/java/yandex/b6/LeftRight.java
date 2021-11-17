package yandex.b6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class LeftRight {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt(), leftIdx, rightIdx;
        List<Integer> arr = new ArrayList<>();

        while (n != 0) {
            arr.add(inp.nextInt());
            n--;
        }

        int countRequests = inp.nextInt();
        while (countRequests > 0) {
            int number = inp.nextInt();
            leftIdx = lBinSearch(0, arr.size() - 1, (index) -> arr.get(index) >= number);
            rightIdx = rBinSearch(leftIdx, arr.size() - 1, (index) -> arr.get(index) <= number);

            if (leftIdx == rightIdx && arr.get(leftIdx) != number) {
                System.out.println("0 0");
            } else {
                System.out.println((leftIdx + 1) + " " + (rightIdx + 1));
            }

            countRequests--;
        }

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
