package leetcode;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    private static boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[right]) {
                return false;
            }

            right--;
            if (right < i) {
                break;
            }
        }
        return true;
    }
}




