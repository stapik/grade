package yandex.b3;

import java.lang.String;
import java.util.*;
import java.util.stream.IntStream;

public class Car {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        boolean status;
        int maxValue = 0, numberCount = 0;
        String number;
        Set<char[]> witnesses = new HashSet<>();
        Set<Item> numbers = new LinkedHashSet<>();

        IntStream.range(0, inp.nextInt()).forEach(i -> witnesses.add(inp.next().toCharArray()));

        int n = inp.nextInt();
        while (n != 0) {
            number = inp.next();
            numberCount = 0;

            for (char[] chars : witnesses) {
                status = true;
                for (char c : chars) {
                    if (number.indexOf(c) == -1) {
                        status = false;
                        break;
                    }
                }
                if (status) {
                    numberCount++;
                }
            }
            numbers.add(new Item(number, numberCount));
            maxValue = Math.max(maxValue, numberCount);
            n--;
        }

        int finalMaxValue = maxValue;
        numbers.stream()
                .filter(entry -> entry.getCount() == finalMaxValue)
                .forEach(item -> System.out.print(item.getNumber() + "\n"));
        inp.close();
    }

    private static class Item {
        String number;
        int count;

        public Item(String number, int count) {
            this.number = number;
            this.count = count;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
