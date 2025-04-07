package grade.patterns.structural;

/**
 * Когда: нужно добавить поведение объекту без изменения его класса.
 * Паттерн Декоратор позволяет добавлять новые функции объекту динамически, не меняя его исходный код.
 * Пример: кофе + молоко + сироп = декорация базового кофе.
 * Паттерн основан на принципе композиции, а не наследования,
 * и часто используется, когда нужно расширить поведение объекта гибким и переиспользуемым способом.
 * Декоратор — это структурный паттерн проектирования, который позволяет динамически добавлять новые обязанности
 * (функциональность) объектам, не изменяя их исходный код. Он основан на принципе композиции,
 * а не наследования, и часто используется, когда нужно расширить поведение объекта гибким и переиспользуемым способом.
 */
public class Decorator {

    interface Coffee {
        String getDescription();

        int getCost();
    }

    static class BasicCoffee implements Coffee {
        @Override
        public String getDescription() {
            return "Cappuccino";
        }

        @Override
        public int getCost() {
            return 10;
        }
    }

    static class MilkDecorator implements Coffee {

        // Объект базового компонента, композиция
        private Coffee decoratedCoffee;

        public MilkDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription() + " + Milk";
        }

        /**
         * Добавление нового поведения в дополнение к вложенному объекту
         */
        @Override
        public int getCost() {
            return decoratedCoffee.getCost() + 3;
        }
    }
}
