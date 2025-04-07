package grade.patterns.creational;

import java.util.stream.IntStream;

/**
 * Строитель концентрируется на построении сложных объектов шаг за шагом.
 */
public class Builder {

    static class IntBuilder {
        int sum = 0;

        IntBuilder append(int n) {
            sum += n;
            return this;
        }

        IntBuilder append(int n, int multiplier) {
            sum += n * multiplier;
            return this;
        }

        int sum() {
            return sum;
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, 10).forEach(sb::append);
        System.out.println(sb);


        IntBuilder intBuilder = new IntBuilder();
        IntStream.range(0, 5).forEach(intBuilder::append);
        intBuilder.append(10).append(15, 4);
        System.out.println(intBuilder.sum());
    }
}
