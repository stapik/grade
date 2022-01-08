package sberfight;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SubStrings {

    public static void main(String[] args) {
        System.out.println(getResult("aaa bbb", "a")); // 7
        System.out.println(getResult("bbbb cc aa", "b")); // 10
        System.out.println(getResult("b", "b")); // 1
        System.out.println(getResult("b b", "b")); // 3
    }

    public static int getResult(String s, String symbol) {
        String[] subStrings = s.split(" ");
        int maxSubstringLength = 0;

        for (int i = 0; i < subStrings.length; i++) {
            if (subStrings[i].contains(symbol)) {
                maxSubstringLength = Math.max(calcMaxSubstring(subStrings, i, symbol), maxSubstringLength);
            }
        }
        return maxSubstringLength;
    }

    private static int calcMaxSubstring(String[] subStrings, int index, String symbol) {
        int leftIdx = index - 1, rightIdx = index + 1, leftSize = 0, rightSize = 0;
        Set<Integer> selectedSubstrings = new HashSet<>();
        selectedSubstrings.add(index);

        Predicate<Integer> indexExists = (idx) -> subStrings.length > idx && idx > -1;
        Supplier<Integer> totalSymbols = () -> selectedSubstrings
                .stream()
                .mapToInt(i -> subStrings[i].length()).sum()
                + selectedSubstrings.size() - 1;

        while (true) {
            // -1 = all symbols, 0 = nothing, n > 0 = other symbols
            if (indexExists.test(leftIdx)) {
                leftSize = subStrings[leftIdx].contains(symbol) ? -1 : subStrings[leftIdx].length();
            }
            if (indexExists.test(rightIdx)) {
                rightSize = subStrings[rightIdx].contains(symbol) ? -1 : subStrings[rightIdx].length();
            }

            if (leftSize == -1 || totalSymbols.get() >= leftSize && leftIdx > - 1 && leftSize > 0) {
                selectedSubstrings.add(leftIdx);
                leftIdx--;
            }
            if (rightSize == -1 || totalSymbols.get() >= rightSize && rightIdx > -1 && rightSize > 0) {
                selectedSubstrings.add(rightIdx);
                rightIdx++;
            }

            if (leftSize == 0 && rightSize == 0) {
                break;
            }

            leftSize = 0;
            rightSize = 0;
        }

        return totalSymbols.get();
    }
}