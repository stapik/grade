package grade;

import javax.swing.plaf.PanelUI;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTraining {

    static class Person {
        String name;
        int age;

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return name + " " + age;
        }
    }

    public static void main(String[] args) {
//        collectItems();
//        createStreams();
//        sorting();
//        flatMap();
    }

    public static void intStream() {
        Stream.of(2,4,5,6)
                .mapToInt(n -> n)
                .sum();

        Stream.of(2,4,5,6)
                .mapToInt(n -> n)
                .average()
                .getAsDouble();
    }

    public static void flatMap() {
        System.out.println("flatMap 2 strings");
        Stream
                .of("H e l l o", "w o r l d !")
                .flatMap((p) -> Arrays.stream(p.split(" ")))
                .forEach(System.out::println);

        System.out.println("flatMap 2 strings with numbers");
        Stream.of("1 2 3 4", "5 6 7 8")
                .map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).boxed().toArray())
                .flatMap(Stream::of)
                .forEach(System.out::println);
    }

    public static void sorting() {
        System.out.println("sorting by length:");
        Stream.of("test", "lo", "k", "last item", "link", "l").sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        System.out.println("sorting by character:");
        Stream.of("test", "lo", "k", "last item", "link", "l")
                .sorted((s1, s2) -> Integer.compare(s2.charAt(0), s1.charAt(0)))
                .forEach(System.out::println);

        Stream.of(
                        new Person("Stas", 32),
                        new Person("Vasya", 33),
                        new Person("Gavin", 55),
                        new Person("Abram", 55),
                        new Person("Richard", 55)
                )
                .sorted(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getName))
                .map(Person::toString)
                .forEach(System.out::println);
    }

    public static void collectItems() {
        Stream.generate(Math::random).limit(3).collect(Collectors.toList());
        Map<Integer, Integer> map = Stream.iterate(1, x -> x + x).limit(4).collect(Collectors.toMap(x -> -x, x -> x));
        System.out.println(map);
        double mean = Stream.iterate(1, x -> x + x).limit(4).collect(Collectors.averagingDouble(value -> -value)).doubleValue();
        System.out.println("mean = " + mean);
        long sum = Stream.iterate(1, x -> x + x).limit(4).collect(Collectors.summarizingInt(value -> value)).getSum();
        System.out.println("sum = " + sum);
        Map<Boolean, List<Integer>> partitionBy = Stream.iterate(4, x -> (int) (x + x + Math.random() * 100)).limit(10).collect(Collectors.partitioningBy(value -> value % 2 == 0));
        System.out.println("partitionBy = " + partitionBy);

        Map<Integer, List<Integer>> groupingBy = Stream.iterate(4, x -> (int) (x + x + Math.random() * 100)).limit(10).collect(Collectors.groupingBy(value -> value % 10));
        System.out.println("groupingBy = " + groupingBy);

        Map<Integer, Set<Integer>> mapping = Stream.iterate(4, x -> (int) (x + x + Math.random() * 100)).limit(10)
                .collect(Collectors.groupingBy(value -> value % 3, Collectors.mapping(value -> -value, Collectors.toSet())));
        System.out.println("groupingBy mapping = " + mapping);
    }

    public static void createStreams() {
        System.out.println("str arr to int arr");
        Arrays.stream(new String[]{"1", "2", "3"}).mapToInt(Integer::parseInt).forEach(System.out::println);

        System.out.println("array as list");
        Arrays.asList(1, 2, 3).stream().forEach(System.out::println);

        System.out.println("stream of");
        Stream.of(2, 3, 4).forEach(System.out::println);

        System.out.println("stream array");
        Arrays.stream(new int[]{1, 2, 3}).sorted().forEach(System.out::println);

        System.out.println("stream chars");
        "sdl35".chars().forEach(System.out::println);

        System.out.println("stream builder");
        Stream.Builder<String> builder = Stream.builder();
        builder.add("builder 1");
        builder.add("builder 2");
        builder.add("builder 3");
        Stream<String> stream2 = builder.build();
        stream2.forEach(System.out::println);

        System.out.println("parallerl stream");
        List.of(1, 2, 3).parallelStream().forEach(System.out::println);

        System.out.println("stream iterate");
        Stream.iterate(0, x -> x + 2).limit(10).forEach(System.out::println);

        System.out.println("stream generate");
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
