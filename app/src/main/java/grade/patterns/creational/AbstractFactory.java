package grade.patterns.creational;

/**
 * Абстрактная фабрика — это порождающий паттерн проектирования,
 * который решает проблему создания целых семейств связанных продуктов, без указания конкретных классов продуктов.
 */
public class AbstractFactory {

    interface ProductTop {
    }

    interface ProductBottom {
    }

    // Abstract Factory
    interface ProductMapper {

        ProductTop getTop();

        ProductBottom getBottom();
    }


    public static class BurgerTop implements ProductTop {

    }

    public static class ColaBottom implements ProductBottom {

    }

    public static class FoodProductMapper implements ProductMapper {

        @Override
        public ProductTop getTop() {
            return new BurgerTop();
        }

        @Override
        public ProductBottom getBottom() {
            return new ColaBottom();
        }
    }

    public static void main(String[] args) {
        FoodProductMapper mapper = new FoodProductMapper();
        mapper.getBottom();
        mapper.getTop();
    }
}
