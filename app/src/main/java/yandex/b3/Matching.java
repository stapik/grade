package yandex.b3;

import java.util.*;
import java.lang.String;

public class Matching {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String[] list1 = inp.nextLine().split(" ");
        Set<String> list2 = new HashSet<>(Arrays.asList(inp.nextLine().split(" ")));
        int count = 0;

        for (String s : list1) {
            if (list2.contains(s)) {
                count++;
            }
        }

        System.out.println(count);
        inp.close();
    }
}
