package yandex.b7;

import java.io.*;
import java.util.*;

public class SolidLine {

    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        int count = inp.nextInt(), numberOfLayers = 0, length = 0, from = 0;
        List<Event> events = new ArrayList<>(count * 2);
        while (count > 0) {
            events.add(new Event(Type.START, inp.nextInt()));
            events.add(new Event(Type.END, inp.nextInt()));
            count--;
        }
        inp.close();
        events.sort(Comparator.comparing(Event::getValue).thenComparing(Event::getType));

        for (Event event : events) {
            if (event.type.equals(Type.START)) {
                if (numberOfLayers == 0) {
                    from = event.getValue();
                }
                numberOfLayers += 1;
            }

            if (event.type.equals(Type.END)) {
                numberOfLayers -= 1;
                if (numberOfLayers == 0) {
                    length += event.getValue() - from;
                }
            }
        }

        System.out.println(length);
    }

    private enum Type {
        START, END
    }

    private static class Event {
        private final Type type;
        private final int value;

        public Event(Type type, int value) {
            this.type = type;
            this.value = value;
        }

        public Type getType() {
            return type;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "type=" + type +
                    ", value=" + value +
                    '}';
        }
    }
}
