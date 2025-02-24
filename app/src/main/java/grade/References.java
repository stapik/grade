package grade;

import java.lang.ref.*;

public class References {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object);
        WeakReference<Object> weakReference = new WeakReference<>(object);

        System.out.println("Strong reference " + object);
        System.out.println("Soft reference " + softReference.get());
        System.out.println("Weak reference " + weakReference.get());

        object = null;
        System.gc();
        Thread.sleep(1000); // Ждем срабатывания GC
        System.out.println("Run GC");

        System.out.println("Strong reference " + object);
        System.out.println("Soft reference " + softReference.get());
        System.out.println("Weak reference " + weakReference.get());

        System.out.println("\n\n\n");

        phantomReference();
    }

    private static void phantomReference() throws InterruptedException {
        // Очередь для фантомных ссылок
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        // Создаем объект и фантомную ссылку на него
        Object myObject = new Object();
        PhantomReference<Object> phantomRef = new PhantomReference<>(myObject, referenceQueue);

        // Убираем сильную ссылку, чтобы GC мог удалить объект
        myObject = null;

        // Запрашиваем сборку мусора
        System.gc();
        Thread.sleep(1000); // Ждем срабатывания GC

        // Проверяем, попала ли фантомная ссылка в очередь
        Reference<?> ref = referenceQueue.poll();
        if (ref != null) {
            System.out.println("Phantom reference " + ref);
            System.out.println("Объект перед удалением отловлен в ReferenceQueue!");
        } else {
            System.out.println("Объект пока не удален.");
        }
    }
}
