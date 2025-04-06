package grade.patterns.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * Компоновщик — это структурный паттерн проектирования,
 * который позволяет сгруппировать множество объектов в древовидную структуру,
 * а затем работать с ней так, как будто это единичный объект.
 */
public class Composite {

    interface Component {
        void show();
    }

    static class File implements Component {
        private String name;

        public File(String name) {
            this.name = name;
        }

        @Override
        public void show() {
            System.out.println(name);
        }
    }

    static class Folder implements Component {

        private String name;

        public Folder(String name) {
            this.name = name;
        }

        private List<Component> children = new ArrayList<>();

        public void addComponent(Component component) {
            children.add(component);
        }

        @Override
        public void show() {
            System.out.println(name + ":");
            children.forEach(Component::show);
        }
    }

    public static void main(String[] args) {
        File file1 = new File("David.jpg");
        File file2 = new File("Steve.jpg");
        File file3 = new File("mother.jpg");

        Folder myPhotos = new Folder("My photos");
        Folder friends = new Folder("friends");
        friends.addComponent(file1);
        friends.addComponent(file2);

        myPhotos.addComponent(friends);
        myPhotos.addComponent(file3);

        myPhotos.show();
    }
}
