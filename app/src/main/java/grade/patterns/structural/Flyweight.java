package grade.patterns.structural;

import java.util.HashMap;
import java.util.Map;

/**
 * Когда: нужно сэкономить память при большом количестве однотипных объектов.
 * Пример: символы в редакторе — буква "а" хранится одна, но отображается много раз.
 */
public class Flyweight {

    static class MyCharacter {
        private char symbol;

        public MyCharacter(char symbol) {
            this.symbol = symbol;
        }
    }

    class MyCharacterFactory {
        private Map<Character, MyCharacter> pool = new HashMap<>();

        MyCharacter get(char c) {
            return pool.computeIfAbsent(c, k -> new MyCharacter(c));
        }
    }

    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";

        System.out.println(s1 == s2); // same

        String s3 = new String("Hello");
        System.out.println(s2 == s3); // not same

        s3 = s3.intern();
        System.out.println(s2 == s3); // same

        System.out.println("-------------- (-127 => 127) cache --------------");

        Integer int1 = Integer.valueOf(100);
        Integer int2 = Integer.valueOf(100);
        System.out.println(int1 == int2);

        Integer int3 = Integer.valueOf(200);
        Integer int4 = Integer.valueOf(200);
        System.out.println(int3 == int4);
    }
}
