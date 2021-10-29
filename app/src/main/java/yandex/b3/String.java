package yandex.b3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class String {

    public static void main(java.lang.String[] args) {
        Scanner inp = new Scanner(System.in);
        Set<java.lang.String> set = new HashSet<>();
        java.lang.String[] list = inp.nextLine().split(" ");

        for(java.lang.String value: list){
            if(set.contains(value)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
                set.add(value);
            }
        }

        inp.close();
    }
}
