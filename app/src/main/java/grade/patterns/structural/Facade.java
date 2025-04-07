package grade.patterns.structural;

/**
 * Когда: нужно упростить работу с комплексной системой.
 * Пример: ты жмёшь одну кнопку — машина сама заводится, прогревается и включает музыку.
 * Фасад — это паттерн, который предоставляет упрощённый интерфейс к сложной подсистеме.
 * Он скрывает сложность множества классов, предоставляя единый и понятный способ взаимодействия с ними.
 * По сути, это "единое окно" для работы с целой группой классов.
 */
public class Facade {

    static class Engine {
        void start() {
            System.out.println("Engine start");
        }
    }

    static class Music {
        void play() {
            System.out.println("Music on");
        }
    }

    static class CarFacade {
        private Engine engine = new Engine();
        private Music music = new Music();

        void startCar() {
            engine.start();
            music.play();
        }
    }

    public static void main(String[] args) {
        CarFacade carFacade = new CarFacade();
        carFacade.startCar();
    }
}
