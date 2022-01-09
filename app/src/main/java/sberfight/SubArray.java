package sberfight;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SubArray {

    public static void main(String[] args) {
        System.out.println(getResult(Arrays.asList("x", "x", "x", "y", "y"), 12)); // true
        System.out.println(getResult(Arrays.asList("x", "x", "y", "y"), 20)); // true
    }

    public static boolean getResult(List<String> subArray, int k) {
        Map<String, Integer> symbolCount = new HashMap<>();
        List<int[]> numberFactors = new ArrayList<>();
        subArray.forEach(s -> symbolCount.merge(s, 1, Integer::sum));
        symbolCount.forEach((s, number) -> numberFactors.add(new int[]{number, -1}));
        Supplier<Integer> checker = () -> Integer.compare(
                numberFactors.stream().mapToInt(arr -> arr[0] * arr[1]).sum(),
                k
        );
        Consumer<Integer> incrementById = (idx) -> {
            if (idx >= numberFactors.size()) {
                return;
            }
            int[] arr = numberFactors.get(idx);
            arr[1] = arr[1] + 1;
            numberFactors.set(idx, arr);
        };
        Consumer<Integer> resetById = (idx) -> {
            if (idx >= numberFactors.size()) {
                return;
            }
            int[] arr = numberFactors.get(idx);
            arr[1] = 0;
            numberFactors.set(idx, arr);
        };

        for (int i = 0; i <= 150; i++) {

            if (checker.get() == 0) return true;
            if (checker.get() > 0) break;

            incrementById.accept(0);

            if (numberFactors.size() < 2) continue;

            resetById.accept(1);
            resetById.accept(2);

            for (int j = 0; j <= 150; j++) {

                if (checker.get() == 0) return true;
                if (checker.get() > 0) break;

                incrementById.accept(1);

                if (numberFactors.size() < 3) continue;

                resetById.accept(2);

                for (int y = 0; y <= 150; y++) {

                    if (checker.get() == 0) return true;
                    if (checker.get() > 0) break;

                    incrementById.accept(2);
                }
            }
        }

        return false;
    }
}