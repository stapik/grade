package grade.patterns.creational;

import java.time.Instant;

/**
 * Фабричный метод — это порождающий паттерн проектирования,
 * который определяет общий интерфейс для создания объектов в суперклассе,
 * позволяя подклассам изменять тип создаваемых объектов.
 */
public class FactoryMethod {

    abstract static class TextItem {
        public abstract String createTitle();
    }

    static class Button extends TextItem {

        private String name = "button";

        /**
         * Factory method
         * @return string
         */
        @Override
        public String createTitle() {
            return new StringBuilder(name).append("\n").toString();
        }
    }

    public static void main(String[] args) {
        Button button = new Button();
        System.out.println(button.createTitle());

        // Factory method
        Instant.now();
    }
}
