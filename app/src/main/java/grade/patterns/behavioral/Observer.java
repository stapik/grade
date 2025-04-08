package grade.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Один объект (субъект) уведомляет множество зависимых объектов (наблюдателей) об изменениях своего состояния.
 */
public class Observer {
    public static void main(String[] args) {
        Blog blog = new Blog();
        blog.add(new ChatLogger());
        blog.add(new MessageMonitoring());

        blog.publish("my first message");
    }
}

interface MessageObserver {
    void message(String message);
}

class ChatLogger implements MessageObserver {
    @Override
    public void message(String message) {
        System.out.println("ChatLogger: " + message);
    }
}

class MessageMonitoring implements MessageObserver {
    @Override
    public void message(String message) {
        System.out.println("MessageMonitoring: " + message);
    }
}

class Blog {
    private List<MessageObserver> observers = new ArrayList<>();

    public void add(MessageObserver observer) {
        observers.add(observer);
    }

    public void publish(String message) {
        for (MessageObserver observer : observers) {
            observer.message(message);
        }
    }
}
