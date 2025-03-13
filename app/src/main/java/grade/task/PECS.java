package grade.task;

import java.util.ArrayList;
import java.util.List;

public class PECS {

    /**
     * Смотреть нужно со стороны коллекции. Если из коллекции достаём элемент, то это производство. Другими словами коллекция достает нам элемент.
     * Если мы добавляем элемент, коллекция потребляет элемент.
     * ? extends Number ограничивает добавление, потому что не известно, какого типа коллекция, и добавление может нарушить типизацию.
     * ? super Integer позволяет добавлять объекты типа Integer, потому что мы уверены, что коллекция примет Integer или любой его суперкласс.
     */
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        // Точно понимаем, что там есть Number и можно считать Number
        List<? extends Number> producerList = integerList;

        // нельзя: producerList.add(6);
        producerList.forEach(num -> System.out.println(num.doubleValue()));

        // Точно понимаем, что там есть Integer и можно добавить Integer
        List<? super Integer> consumerList = integerList;
        consumerList.add(20);
        consumerList.add(30);
        consumerList.add(40);
        //consumerList.add(new Object());  // Ошибка компиляции!


        // точно понимаем, что там есть Object и ниже по иерархии до Integer (все супер классы)
        // можем добавить объекты с типами в диапазоне Object -> Number -> Integer
        integerList.forEach(System.out::println);
    }
}
