package yandex.b3;

import java.util.*;
import java.lang.String;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class August {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        String str = inp.nextLine();
        Set<Integer> numbers;
        Set<Integer> result = IntStream.iterate(1, i -> i + 1)
                .limit(n)
                .boxed().collect(Collectors.toCollection(TreeSet::new));

        while (!str.equals("HELP")) {

            if (str.equals("")) {
                str = inp.nextLine();
                continue;
            }

            numbers = parseNumbers(str);
            str = inp.nextLine();

            if (str.equals("YES")) {
                result.retainAll(numbers);
            } else {
                result.removeAll(numbers);
            }
            numbers = null;
            str = inp.nextLine();
        }
        result.forEach(item -> System.out.print(item + " "));
        inp.close();
    }

    private static Set<Integer> parseNumbers(String s) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(s.split(" ")).forEach(item -> set.add(Integer.parseInt(item)));
        return set;
    }
}
