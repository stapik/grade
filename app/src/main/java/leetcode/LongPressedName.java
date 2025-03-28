package leetcode;

public class LongPressedName {

    public static void main(String[] args) {
        LongPressedName v = new LongPressedName();
        System.out.println(v.isLongPressedName("alex", "aaleexa"));
    }

    public boolean isLongPressedName(String name, String typed) {
        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();

        int left = 0, right = 0;
        while (right < typed.length()) {
            if (left < name.length() && nameChars[left] == typedChars[right]) {
                left++;
                right++;
            } else if (right > 0 && typedChars[right - 1] == typedChars[right]) {
                right++;
            } else {
               return false;
            }
        }

        return left == name.length();
    }
}
