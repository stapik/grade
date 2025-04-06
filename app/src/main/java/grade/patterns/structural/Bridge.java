package grade.patterns.structural;

/**
 * Bridge = разделение на 2 независимые иерархии, которые можно свободно комбинировать:
 * одна — абстракции, вторая — реализации, связанных через композицию.
 * Главное - это связь по композиции.
 * Используется, когда одна абстракция может использовать разные реализации,
 * и реализации тоже могут быть разными типами.
 * Bridge позволяет избежать декартова произведения классов,
 * разделив одну сложную иерархию на две независимые — абстракции и реализации, связанные через композицию.
 * Декартово произведение — это математическая операция, которая берёт все возможные комбинации элементов из двух множеств.
 * Абстракция — это первая иерархия, та, с которой работает клиент (в нашем примере это RemoteControl)
 * Реализация — это вторая иерархия, которая делегируется внутри абстракции (в нашем примере это Device)
 */
public class Bridge {

    interface Device {
        void turnOn();
    }

    static class Radio implements Device {
        @Override
        public void turnOn() {
            System.out.println("Turn on radio");
        }
    }

    static class TV implements Device {
        @Override
        public void turnOn() {
            System.out.println("Turn on TV");
        }
    }

    abstract static class RemoteControl {

        protected Device device;

        public RemoteControl(Device device) {
            this.device = device;
        }

        abstract void pressPower();
    }

    static class BasicRemote extends RemoteControl {

        public BasicRemote(Device device) {
            super(device);
        }

        @Override
        void pressPower() {
            device.turnOn();
        }
    }

    public static void main(String[] args) {
        Device tv = new TV();
        BasicRemote basicRemote = new BasicRemote(tv);
        basicRemote.pressPower();
    }
}
