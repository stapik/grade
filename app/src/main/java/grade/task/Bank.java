package grade.task;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Bank {

    public static void main(String[] args) {
        int[] banknotes = {100, 500, 1000};
        int amount = 1700;
        int result = minBanknotes(banknotes, amount);
        if (result == -1) {
            System.out.println("No banknotes");
        } else {
            System.out.println(result);
        }
    }

    public static int minBanknotes(int[] banknotes, int amount) {
        Arrays.sort(banknotes);
        Arrays.stream(banknotes).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int total = 0, count = 0;
        for (int i = banknotes.length - 1; i >= 0; i--) {
            count = amount / banknotes[i];
            if (count > 0) {
                total += count;
                amount -= count * banknotes[i];
            }
        }

        return amount == 0 ? total : -1;
    }
}
