package yandex.b_n;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class SolidLine {

    public static void main(String[] args) throws IOException {
        AtomicInteger sum = new AtomicInteger();
        Files.lines(Paths.get("input.txt")).skip(1).forEach(row -> {
            String[] numberList = row.split(" ");
            if (numberList.length == 2) {
                int a = Integer.parseInt(numberList[0]), b = Integer.parseInt(numberList[1]);
                sum.addAndGet(Math.abs(b - a));
            }
        });
        System.out.println(sum.get());
    }
}
