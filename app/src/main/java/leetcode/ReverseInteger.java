package leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger instance = new ReverseInteger();
        System.out.println(instance.reverse(-123));
        System.out.println(instance.reverse(120));
    }

    public int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        int sign = 1;
        char[] chars = String.valueOf(x).toCharArray();

        for (int i = chars.length - 1; i > -1; i--) {
            if (chars[i] == '-') {
                sign = -1;
            } else {
                stringBuilder.append(chars[i]);
            }
        }

        long longValue = Long.parseLong(stringBuilder.toString());
        if (longValue > Integer.MAX_VALUE || longValue < Integer.MIN_VALUE) {
            return 0;
        }

        return sign * (int) longValue;
    }
}
