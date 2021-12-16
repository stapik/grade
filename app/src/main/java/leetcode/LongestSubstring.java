package leetcode;

import java.util.*;

public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> sequence = new HashMap<>();
        int maxSequenceSize = 0;

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if (sequence.containsKey(ch)) {
                Integer idx = sequence.get(ch);
                maxSequenceSize = Math.max(sequence.size(), maxSequenceSize);
                sequence.entrySet().removeIf(entry -> entry.getValue() <= idx);
            }
            sequence.put(ch, i);
        }
        maxSequenceSize = Math.max(sequence.size(), maxSequenceSize);

        return maxSequenceSize;
    }
}
