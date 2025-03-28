package leetcode;

public class ValidPalindrome2 {

    public static void main(String[] args) {
//        System.out.println(validPalindrome("eedede"));
        System.out.println(validPalindrome("cbbcc"));
    }

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return true;
        }

        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return isPalindrome(chars, left + 1, right) || isPalindrome(chars, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
