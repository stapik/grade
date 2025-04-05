package grade.patterns.creational;

import java.util.Objects;

/**
 * Прототип — это порождающий паттерн,
 * который позволяет копировать объекты любой сложности без привязки к их конкретным классам.
 */
public class Prototype {

    interface Shape {
        // prototype
        Shape clone();
    }

    public static class Figure implements Shape {
        private int length = 5;
        private int width = 3;
        private int high = 10;

        public Figure(int length, int width, int high) {
            this.length = length;
            this.width = width;
            this.high = high;
        }

        public Figure clone() {
            return new Figure(length, width, high);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Figure figure = (Figure) o;
            return length == figure.length && width == figure.width && high == figure.high;
        }

        @Override
        public int hashCode() {
            return Objects.hash(length, width, high);
        }
    }

    public static void main(String[] args) {
        Shape f1 = new Figure(2, 4, 5);
        Shape clone = f1.clone();

        if (f1 == clone) {
            System.out.println("same");
        } else if (f1.equals(clone)) {
            System.out.println("clone");
        } else {
            throw new RuntimeException("Something went wrong");
        }
    }
}
