package leetcode;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome instance = new Palindrome();
        System.out.println("Answer: " + instance.longestPalindrome("adam"));
    }

    public String longestPalindrome(String s) {
        String result = s.substring(0, 1), p1, p2;
        int left, right;
        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = i;

            if (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i) && result.length() < 2) {
                result = s.substring(i - 1, i + 1);
            }

            p1 = findPalindrome(left, right, s);
            p2 = findPalindrome(left, right + 1, s);
            if (result.length() < p1.length() || result.length() < p2.length()) {
                result = p1.length() > p2.length() ? p1 : p2;
            }
        }
        return result;
    }

    private String findPalindrome(int left, int right, String s) {
        String result = "";
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left > result.length()) {
                result = s.substring(left, right + 1);
            }
            left--;
            right++;
        }

        return result;
    }
}
