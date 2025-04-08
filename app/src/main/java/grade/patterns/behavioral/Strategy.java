package grade.patterns.behavioral;

/**
 * Определяет семейство алгоритмов, позволяя менять их на лету.
 * Если коротко: Алгоритм работы с данными (без данных внутри)
 * В паттерне Strategy же объект инкапсулирует только алгоритм (действие), но не данные.
 */
public class Strategy {


    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard();
        Cash cash = new Cash();

        Shop shop = new Shop();
        shop.setStrategy(creditCard);
        shop.pay(300.0);

        shop.setStrategy(cash);
        shop.pay(890.0);
    }
}


interface PaymentStrategy {
    void pay(double amount);
}

class CreditCard implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата картой: " + amount);
    }
}

class Cash implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата наличными: " + amount);
    }
}

class Shop {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        strategy.pay(amount);
    }
}
