package sberfight;

import java.util.function.Predicate;

public class SubStrings {

    public static void main(String[] args) {
        System.out.println(getResult("aaa bbb", "a")); // 7
        System.out.println(getResult("a a bb a", "a")); // 8
        System.out.println(getResult("bbbb cc aa", "b")); // 10
        System.out.println(getResult("aaaaaaaa  dddd bbb ccc", "b")); // 22
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
        int leftIdx = index - 1, rightIdx = index + 1, totalSymbols = subStrings[index].length(), countSubstrings = 1;
        Predicate<Integer> indexExists = (idx) -> subStrings.length > idx && idx > -1;
        boolean leftFlag = false, rightFlag = false;

        while (true) {
            if (indexExists.test(leftIdx) && (subStrings[leftIdx].contains(symbol) || subStrings[leftIdx].length() <= totalSymbols)) {
                totalSymbols += subStrings[leftIdx].length();
                countSubstrings++;
                leftFlag = true;
                leftIdx--;
            }
            if (indexExists.test(rightIdx) && (subStrings[rightIdx].contains(symbol) || subStrings[rightIdx].length() <= totalSymbols)) {
                totalSymbols += subStrings[rightIdx].length();
                countSubstrings++;
                rightFlag = true;
                rightIdx++;
            }

            if (!leftFlag && !rightFlag) {
                break;
            }
            leftFlag = false;
            rightFlag = false;
        }

        return totalSymbols + countSubstrings - 1;
    }
}