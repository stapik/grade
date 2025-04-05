package grade.patterns.creational;

import java.util.stream.IntStream;

/**
 * Строитель концентрируется на построении сложных объектов шаг за шагом.
 */
public class Builder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, 10).forEach(sb::append);
        System.out.println(sb);
    }
}
