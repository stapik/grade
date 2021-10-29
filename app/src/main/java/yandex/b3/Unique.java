package yandex.b3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.lang.String;

public class Unique {

    public static void main(java.lang.String[] args) {
        Scanner inp = new Scanner(System.in);
        Set<String> unique = new LinkedHashSet<>();
        Set<String> notUnique = new HashSet<>();
        String[] list = inp.nextLine().split(" ");

        for (String value : list) {
            if (notUnique.contains(value) || unique.contains(value)) {
                unique.remove(value);
                notUnique.add(value);
            } else {
                unique.add(value);
            }
        }

        System.out.println(String.join(" ", unique));

        inp.close();
    }
}
