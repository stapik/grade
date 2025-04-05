package grade.patterns.creational;

/**
 * Одиночка — это порождающий паттерн, который гарантирует существование только одного объекта определённого класса,
 * а также позволяет достучаться до этого объекта из любого места программы.
 */
public class Singleton {

    public static void main(String[] args) {
        // singleton
        SingleMan david = SingleMan.getInstance("David", 32);
        System.out.println(david.getName());

        SingleMan sam = SingleMan.getInstance("Sam", 32); // возвращаем первый instance
        System.out.println(sam.getName());

        // singleton
        Runtime runtime = Runtime.getRuntime();
    }
}

 class SingleMan {
    private final String name;
    private final int age;
    private static SingleMan instance;

    // private constructor
    private SingleMan(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static SingleMan getInstance(String name, int age) {
        if (instance == null) {
            instance = new SingleMan(name, age);
        }

        return instance;
    }
}