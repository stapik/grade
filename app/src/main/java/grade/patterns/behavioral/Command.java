package grade.patterns.behavioral;

/**
 * Инкапсулирует запрос как объект, позволяя настраивать действия и откатывать их.
 * Он позволяет отделить инициатора запроса от его выполнения.
 * С помощью этого паттерна можно параметризовать объекты с операциями (командами),
 * ставить их в очередь, логировать их выполнение, а также поддерживать отмену операций.
 *
 * Когда необходимо запросить выполнение действия без знания о том, как оно будет выполнено.
 * Основная цель: Инкапсуляция действия и передача его в виде объекта.
 * Если коротко: В паттерне Command объект инкапсулирует как действие, так и данные.
 */
public class Command {
    public static void main(String[] args) {
        Light light = new Light();
        lightOffAction lightOffAction = new lightOffAction(light);
        LightOnAction lightOnAction = new LightOnAction(light);

        Remote remote = new Remote();

        remote.setLightAction(lightOnAction);
        remote.pressButton();

        remote.setLightAction(lightOffAction);
        remote.pressButton();
    }
}


class Light {

    public void lightOn() {
        System.out.println("Light on");
    }

    public void lightOff() {
        System.out.println("Light off");
    }
}

interface LightAction {
    void execute();
}

class LightOnAction implements LightAction {
    private Light light;

    public LightOnAction(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOn();
    }
}

class lightOffAction implements LightAction {
    private Light light;

    public lightOffAction(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOff();
    }
}

class Remote {
    private LightAction lightAction;

    public void setLightAction(LightAction lightAction) {
        this.lightAction = lightAction;
    }

    public void pressButton() {
        lightAction.execute();
    }
}