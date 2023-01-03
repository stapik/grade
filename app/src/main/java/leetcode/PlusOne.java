package leetcode;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] result = Arrays.copyOf(digits, digits.length);
        int i = result.length - 1;
        boolean plusOne = true;

        if (digits[digits.length - 1] == 9) {

            while (plusOne) {
                if (i > -1 && result[i] + 1 == 10) {
                    result[i] = 0;
                    i--;
                    continue;
                }
                if (i == -1) {
                    int[] temp = new int[result.length + 1];
                    System.arraycopy(result, 0, temp, 1, result.length);
                    result = temp;
                    result[0] = 1;
                } else {
                    result[i] = result[i] + 1;
                }

                plusOne = false;
            }
        } else {
            result[result.length - 1] = result[result.length - 1] + 1;
        }
        return result;
    }
}
