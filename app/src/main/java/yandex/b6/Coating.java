package yandex.b6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Coating {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt(), k = inp.nextInt();
        List<Integer> dots = new ArrayList<>(n);
        IntStream.range(0, n).forEach(i -> dots.add(inp.nextInt()));
        Collections.sort(dots);
        int left = 0, right = dots.get(dots.size() - 1) - dots.get(0);
        int l, cnt, maxRight;

        while (left < right) {
            l = (right + left) / 2;
            cnt = 0;
            maxRight = dots.get(0) - 1;
            for (Integer dot : dots) {
                if (dot > maxRight) {
                    cnt++;
                    maxRight = dot + l;
                }
            }
            if (cnt <= k) {
                right = l;
            } else {
                left = l + 1;
            }
        }

        System.out.println(left);
    }
}
