package grade.patterns.behavioral;

/**
 * Передаёт запрос по цепочке обработчиков, пока один из них его не обработает.
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Logger infoLogger = new InfoLogger();
        Logger infoLogger1 = new InfoLogger();
        Logger infoLogger2 = new InfoLogger();
        infoLogger.setNext(infoLogger1);
        infoLogger1.setNext(infoLogger2);

        // запуск цепочки
        infoLogger.log("my secret message");
    }
}

abstract class Logger {
    protected Logger next;

    public void setNext(Logger next) {
        this.next = next;
    }

    abstract void log(String message);
}

class InfoLogger extends Logger {
    @Override
    void log(String message) {
        System.out.println(message);
        if (next != null) {
            next.log(message);
        }
    }
}
