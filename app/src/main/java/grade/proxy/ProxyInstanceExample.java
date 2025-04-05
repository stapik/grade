package grade.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInstanceExample {

    interface BarConnection {
        void saySomething();
    }

    static class PlayStationBar implements BarConnection {

        @Override
        public void saySomething() {
            System.out.println("Let's play the game");
        }
    }

    static class BarProxy implements InvocationHandler {

        BarConnection target;

        BarProxy(BarConnection target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Loading bar info");
            return method.invoke(target, args);
        }
    }

    public static void main(String[] args) {

        PlayStationBar target = new PlayStationBar();
        BarConnection proxy = (BarConnection) Proxy.newProxyInstance(
                PlayStationBar.class.getClassLoader(),
                PlayStationBar.class.getInterfaces(),
                new BarProxy(target)
        );

        proxy.saySomething();
    }
}
